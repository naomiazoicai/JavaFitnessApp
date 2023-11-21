package dao;

import dao.interaces.ITrainerDao;
import domain.persons.*;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class TrainerDao implements IDao<Trainer>, ITrainerDao {
    private static TrainerDao instance;

    private final EmployeeDao employeeDao;

    private TrainerDao(){
        employeeDao = EmployeeDao.getInstance();
    }

    public static TrainerDao getInstance()
    {
        if (instance == null) instance = new TrainerDao();
        return instance;
    }

    @Override
    public void addEntity(Trainer trainer) throws ObjectAlreadyContained {
        if (Objects.equals(trainer.getUsername(), "null")) throw new ObjectAlreadyContained();
        String username = trainer.getUsername();
        String name = trainer.getName();
        LocalDate birthdate = trainer.getBirthDate();
        Gender gender = trainer.getGender();
        double salary = trainer.getSalary();
        TrainerSpecialization trainerSpecialization = trainer.getSpecialization();
        try {
            // Check if contained in employee table
            try {
                employeeDao.addEntity(new Employee(username, name, birthdate, gender, salary));
            } catch (ObjectAlreadyContained ignored) {}
            // Add to employee
            String insertQuery = "INSERT INTO trainer (username, trainerSpecialisation) VALUES (?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setString(1, username);
            insertStatement.setString(2, trainerSpecialization.toString());
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
    public void updateEntity(Trainer trainer) throws ObjectNotContained {
        if (Objects.equals(trainer.getUsername(), "null")) throw new ObjectNotContained();
        String username = trainer.getUsername();
        String name = trainer.getName();
        LocalDate birthdate = trainer.getBirthDate();
        Gender gender = trainer.getGender();
        double salary = trainer.getSalary();
        TrainerSpecialization trainerSpecialization = trainer.getSpecialization();
        try {
            // Update employee
            employeeDao.updateEntity(new Employee(username, name, birthdate, gender, salary));
            // Update trainer
            String insertQuery = "UPDATE trainer SET trainerSpecialisation = ? WHERE username = ?";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setString(2, username);
            insertStatement.setString(1, trainerSpecialization.toString());
            insertStatement.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEntity(Trainer trainer) throws ObjectNotContained {
        if (Objects.equals(trainer.getUsername(), "null")) throw new ObjectNotContained();
        String username = trainer.getUsername();
        try {
            String insertQuery = "DELETE FROM trainer WHERE username = ?";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setString(1, username);
            int rowsAffected = insertStatement.executeUpdate();
            if (rowsAffected == 0) throw new ObjectNotContained();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // Delete from employee as well
        try {
            employeeDao.deleteEntity(new Employee(username));
        } catch (ObjectNotContained ignored) {}
    }

    @Override
    public ArrayList<Trainer> getAllEntities() {
        ArrayList<Trainer> result = new ArrayList<>();
        try {
            String query = "SELECT * FROM trainer";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                String username = resultSet.getString("username");
                Employee employee = employeeDao.searchByKeyName(username);
                TrainerSpecialization trainerSpecialization = TrainerSpecialization.valueOf(resultSet.getString("trainerSpecialisation"));
                Trainer trainer = new Trainer(employee.getUsername(), employee.getName(), employee.getBirthDate(), employee.getGender(),
                        employee.getSalary(), trainerSpecialization);
                result.add(trainer);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        result.remove(Trainer.getNullTrainer());
        return result;
    }

    @Override
    public Boolean keyNameInRepo(String keyName) {
        if (Objects.equals(keyName, "null")) return Boolean.FALSE;
        try {
            String query = "SELECT COUNT(*) AS row_count FROM trainer WHERE username = ?";
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
    public Trainer searchByKeyName(String keyName) {
        if (Objects.equals(keyName, "null")) return Trainer.getNullTrainer();
        try {
            String query = "SELECT * FROM trainer WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, keyName);
            ResultSet resultSet = statement.executeQuery();
            // Analyse result
            if (resultSet.next())
            {
                Employee employee = employeeDao.searchByKeyName(keyName);
                if (employee.equals(Person.getNullPerson())) return Trainer.getNullTrainer();
                TrainerSpecialization trainerSpecialization = TrainerSpecialization.valueOf(resultSet.getString("trainerSpecialisation"));
                return new Trainer(employee.getUsername(), employee.getName(), employee.getBirthDate(), employee.getGender(),
                        employee.getSalary(), trainerSpecialization);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // No subscription type found
        return Trainer.getNullTrainer();
    }

    @Override
    public ArrayList<Trainer> searchByPartialKeyName(String keyName) {
        ArrayList<Trainer> result = new ArrayList<>();
        String partialName = "%" + keyName + "%";
        try {
            String query = "SELECT * FROM trainer WHERE trainer.username LIKE ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, partialName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                String username = resultSet.getString("username");
                Employee employee = employeeDao.searchByKeyName(username);
                TrainerSpecialization trainerSpecialization = TrainerSpecialization.valueOf(resultSet.getString("trainerSpecialisation"));
                Trainer trainer = new Trainer(employee.getUsername(), employee.getName(), employee.getBirthDate(), employee.getGender(),
                        employee.getSalary(), trainerSpecialization);
                result.add(trainer);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        result.remove(Trainer.getNullTrainer());
        return result;
    }
}
