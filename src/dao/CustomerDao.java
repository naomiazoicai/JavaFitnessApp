package dao;

import dao.interaces.ICustomerDao;
import domain.persons.*;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class CustomerDao implements IDao<Customer>, ICustomerDao
{
    private static CustomerDao instance;
    private final PersonDao personDao;
    private final TrainerDao trainerDao;

    private CustomerDao()
    {
        personDao = PersonDao.getInstance();
        trainerDao = TrainerDao.getInstance();
    }

    public static CustomerDao getInstance()
    {
        if (instance == null) instance = new CustomerDao();
        return instance;
    }

    @Override
    public void addEntity(Customer customer) throws ObjectAlreadyContained
    {
        if (Objects.equals(customer.getUsername(), "null")) throw new ObjectAlreadyContained();
        // Save fields
        String username = customer.getUsername();
        String trainerUsername = validateTrainerUsername(customer.getAssignedTrainer().getUsername());
        // Update person and add customer
        updatePerson(customer);
        try {
            String insertQuery = "INSERT INTO customer (username, assignedTrainerUsername) VALUES (?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setString(1, username);
            insertStatement.setString(2, trainerUsername);
            insertStatement.executeUpdate();
        }
        catch (SQLIntegrityConstraintViolationException e)
        {
            throw new ObjectAlreadyContained();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateEntity(Customer customer) throws ObjectNotContained
    {
        if (Objects.equals(customer.getUsername(), "null")) throw new ObjectNotContained();
        // Save fields
        String username = customer.getUsername();
        String trainerUsername = validateTrainerUsername(customer.getAssignedTrainer().getUsername());
        // Update person and customer
        updatePerson(customer);
        try {
            // Add to employee
            String insertQuery = "UPDATE customer SET assignedTrainerUsername = ? WHERE username = ?";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setString(2, username);
            insertStatement.setString(1, trainerUsername);
            int affectedRows = insertStatement.executeUpdate();
            // No update done
            if (affectedRows == 0) throw new ObjectNotContained();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEntity(Customer customer) throws ObjectNotContained
    {
        if (Objects.equals(customer.getUsername(), "null")) throw new ObjectNotContained();
        String username = customer.getUsername();
        // Delete customer
        try {
            String insertQuery = "DELETE FROM customer WHERE username = ?";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setString(1, username);
            int rowsAffected = insertStatement.executeUpdate();
            if (rowsAffected == 0) throw new ObjectNotContained();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Customer> getAllEntities()
    {
        ArrayList<Customer> result = new ArrayList<>();
        try {
            String query = "SELECT * FROM customer";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            // Add each found customer to result
            while (resultSet.next())
            {
                String username = resultSet.getString("username");
                String trainerUsername = resultSet.getString("assignedTrainerUsername");
                Person person = personDao.searchByUsername(username);
                Trainer trainer = trainerDao.searchByUsername(trainerUsername);
                Customer customer = new Customer(person.getUsername(), person.getName(),
                        person.getBirthDate(), person.getGender(), trainer);
                result.add(customer);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        result.remove(Customer.getNullCustomer());
        return result;
    }

    @Override
    public Boolean usernameInRepo(String username)
    {
        if (Objects.equals(username, "null")) return Boolean.FALSE;
        try {
            String query = "SELECT COUNT(*) AS row_count FROM customer WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            // Analyse result
            if (resultSet.next())
            {
                int row_count = resultSet.getInt("row_count");
                if (row_count != 0) return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer searchByUsername(String username)
    {
        if (Objects.equals(username, "null")) return Customer.getNullCustomer();
        try {
            String query = "SELECT * FROM customer WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            // Analyse result
            if (resultSet.next())
            {
                // Get person
                Person person = personDao.searchByUsername(username);
                if (person.equals(Person.getNullPerson())) return Customer.getNullCustomer();
                String trainerUsername = resultSet.getString("assignedTrainerUsername");
                // Get trainer
                Trainer trainer;
                if (trainerUsername.equals("null")) trainer = Trainer.getNullTrainer();
                else trainer = trainerDao.searchByUsername(trainerUsername);
                // Return
                return new Customer(person.getUsername(), person.getName(),
                        person.getBirthDate(), person.getGender(), trainer);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // No customer found
        return Customer.getNullCustomer();
    }

    @Override
    public ArrayList<Customer> searchByPartialUsername(String username)
    {
        ArrayList<Customer> result = new ArrayList<>();
        String partialName = "%" + username + "%";
        // Search
        try {
            String query = "SELECT * FROM customer WHERE customer.username LIKE ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, partialName);
            ResultSet resultSet = statement.executeQuery();
            // Add each found customer to result
            while (resultSet.next())
            {
                String trainerUsername = resultSet.getString("assignedTrainerUsername");
                Person person = personDao.searchByUsername(username);
                Trainer trainer = trainerDao.searchByUsername(trainerUsername);
                Customer customer = new Customer(person.getUsername(), person.getName(), person.getBirthDate(),
                        person.getGender(), trainer);
                result.add(customer);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        result.remove(Customer.getNullCustomer());
        return result;
    }

    @Override
    public void trainerDeleted(Trainer trainer)
    {
        if (trainer.getUsername().equals("null")) return;
        String trainerUsername = trainer.getUsername();
        try {
            String insertQuery = "UPDATE customer SET assignedTrainerUsername = ? WHERE assignedTrainerUsername = ?";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setString(1, "null");
            insertStatement.setString(2, trainerUsername);
            insertStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private String validateTrainerUsername(String username)
    {
        if (!trainerDao.usernameInRepo(username)) username = "null";
        return username;
    }

    private void updatePerson(Person person)
    {
        String username = person.getUsername();
        String name = person.getName();
        LocalDate birthdate = person.getBirthDate();
        Gender gender = person.getGender();
        // Add person
        try {
            personDao.addEntity(new Person(username, name, birthdate, gender));
        }
        catch (ObjectAlreadyContained ignored) {
            // If contained, update person
            try {
                personDao.updateEntity(new Person(username, name, birthdate, gender));
            } catch (ObjectNotContained e) {
                throw new RuntimeException(e);
            }
        }
    }
}
