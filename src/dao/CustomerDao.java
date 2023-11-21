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
    public void addEntity(Customer customer) throws ObjectAlreadyContained {
        if (Objects.equals(customer.getUsername(), "null")) throw new ObjectAlreadyContained();
        String username = customer.getUsername();
        String name = customer.getName();
        LocalDate birthdate = customer.getBirthDate();
        Gender gender = customer.getGender();
        String trainerUsername = customer.getAssignedTrainer().getUsername();
        try {
            // Check if contained in person table
            try {
                personDao.addEntity(new Person(username, name, birthdate, gender));
            } catch (ObjectAlreadyContained ignored) {
                // If contained, update person
                try {
                    personDao.updateEntity(new Person(username, name, birthdate, gender));
                } catch (ObjectNotContained e) {
                    throw new RuntimeException(e);
                }
            }
            // Check if valid trainer id
            if (!trainerDao.keyNameInRepo(trainerUsername)) trainerUsername = "null";
            // Add to employee
            String insertQuery = "INSERT INTO customer (username, assignedTrainerUsername) VALUES (?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setString(1, username);
            insertStatement.setString(2, trainerUsername);
            insertStatement.executeUpdate();
        }
        catch (SQLIntegrityConstraintViolationException e) {
            throw new ObjectAlreadyContained();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateEntity(Customer customer) throws ObjectNotContained {
        if (Objects.equals(customer.getUsername(), "null")) throw new ObjectNotContained();
        String username = customer.getUsername();
        String name = customer.getName();
        LocalDate birthdate = customer.getBirthDate();
        Gender gender = customer.getGender();
        String trainerUsername = customer.getAssignedTrainer().getUsername();
        try {
            // Check if contained in person table
            try {
                personDao.addEntity(new Person(username, name, birthdate, gender));
            } catch (ObjectAlreadyContained ignored) {
                // If contained, update person
                try {
                    personDao.updateEntity(new Person(username, name, birthdate, gender));
                } catch (ObjectNotContained e) {
                    throw new RuntimeException(e);
                }
            }
            // Check if valid trainer id
            if (!trainerDao.keyNameInRepo(trainerUsername)) trainerUsername = "null";
            // Add to employee
            String insertQuery = "UPDATE customer SET assignedTrainerUsername = ? WHERE username = ?";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setString(2, username);
            insertStatement.setString(1, trainerUsername);
            insertStatement.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEntity(Customer customer) throws ObjectNotContained {
        if (Objects.equals(customer.getUsername(), "null")) throw new ObjectNotContained();
        String username = customer.getUsername();
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
    public ArrayList<Customer> getAllEntities() {
        ArrayList<Customer> result = new ArrayList<>();
        try {
            String query = "SELECT * FROM customer";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                String username = resultSet.getString("username");
                String trainerUsername = resultSet.getString("assignedTrainerUsername");
                Person person = personDao.searchByKeyName(username);
                Trainer trainer = trainerDao.searchByKeyName(trainerUsername);
                Customer customer = new Customer(person.getUsername(), person.getName(), person.getBirthDate(), person.getGender(), trainer);
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
    public Boolean keyNameInRepo(String keyName) {
        if (Objects.equals(keyName, "null")) return Boolean.FALSE;
        try {
            String query = "SELECT COUNT(*) AS row_count FROM customer WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, keyName);
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
    public Customer searchByKeyName(String keyName) {
        if (Objects.equals(keyName, "null")) return Customer.getNullCustomer();
        try {
            String query = "SELECT * FROM customer WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, keyName);
            ResultSet resultSet = statement.executeQuery();
            // Analyse result
            if (resultSet.next())
            {
                Person person = personDao.searchByKeyName(keyName);
                if (person.equals(Person.getNullPerson())) return Customer.getNullCustomer();
                String trainerUsername = resultSet.getString("assignedTrainerUsername");
                Trainer trainer;
                if (trainerUsername.equals("null")) trainer = Trainer.getNullTrainer();
                else trainer = trainerDao.searchByKeyName(trainerUsername);
                return new Customer(person.getUsername(), person.getName(), person.getBirthDate(), person.getGender(), trainer);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // No subscription type found
        return Customer.getNullCustomer();
    }

    @Override
    public ArrayList<Customer> searchByPartialKeyName(String keyName) {
        ArrayList<Customer> result = new ArrayList<>();
        String partialName = "%" + keyName + "%";
        try {
            String query = "SELECT * FROM customer WHERE customer.username LIKE ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, partialName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                String username = resultSet.getString("username");
                String trainerUsername = resultSet.getString("assignedTrainerUsername");
                Person person = personDao.searchByKeyName(username);
                Trainer trainer = trainerDao.searchByKeyName(trainerUsername);
                Customer customer = new Customer(person.getUsername(), person.getName(), person.getBirthDate(), person.getGender(), trainer);
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
    public void trainerDeleted(Trainer trainer) {
        if (trainer.getUsername().equals("null")) return;
        String trainerUsername = trainer.getUsername();
        try {
            String insertQuery = "UPDATE customer SET assignedTrainerUsername = ? WHERE assignedTrainerUsername = ?";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setString(1, "null");
            insertStatement.setString(2, trainerUsername);
            insertStatement.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
