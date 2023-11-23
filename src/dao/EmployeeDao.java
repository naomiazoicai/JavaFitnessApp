package dao;

import dao.interaces.IEmployeeDao;
import domain.persons.Employee;
import domain.persons.Gender;
import domain.persons.Person;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class EmployeeDao implements IDao<Employee>, IEmployeeDao {
    private static EmployeeDao instance;
    private final PersonDao personDao;
    private EmployeeDao(){
        personDao = PersonDao.getInstance();
    }

    public static EmployeeDao getInstance()
    {
        if (instance == null) instance = new EmployeeDao();
        return instance;
    }

    @Override
    public void addEntity(Employee employee) throws ObjectAlreadyContained
    {
        if (Objects.equals(employee.getUsername(), "null")) throw new ObjectAlreadyContained();
        // Save fields
        String username = employee.getUsername();
        double salary = employee.getSalary();
        // Update person and add employee
        updatePerson(employee);
        try {
            // Add to employee
            String insertQuery = "INSERT INTO employee (username, salary) VALUES (?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setString(1, username);
            insertStatement.setDouble(2, salary);
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
    public void updateEntity(Employee employee) throws ObjectNotContained
    {
        if (Objects.equals(employee.getUsername(), "null")) throw new ObjectNotContained();
        String username = employee.getUsername();
        double salary = employee.getSalary();
        // Update person and then employee
        updatePerson(employee);
        try {
            // Update employee
            String insertQuery = "UPDATE employee SET salary = ? WHERE username = ?";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setDouble(1, salary);
            insertStatement.setString(2, username);
            int rowsAffected = insertStatement.executeUpdate();
            if (rowsAffected == 0) throw new ObjectNotContained();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEntity(Employee employee) throws ObjectNotContained
    {
        if (Objects.equals(employee.getUsername(), "null")) throw new ObjectNotContained();
        String username = employee.getUsername();
        try {
            String insertQuery = "DELETE FROM employee WHERE username = ?";
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
    public ArrayList<Employee> getAllEntities()
    {
        ArrayList<Employee> result = new ArrayList<>();
        try {
            String query = "SELECT * FROM employee ORDER BY username;";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            // For each result, search person, build employee add it to result list
            while (resultSet.next())
            {
                String username = resultSet.getString("username");
                Person person = personDao.searchByUsername(username);
                int salary = resultSet.getInt("salary");
                Employee employee = new Employee(person.getUsername(), person.getName(),
                        person.getBirthDate(), person.getGender(), salary);
                result.add(employee);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        result.remove(Employee.getNullEmployee());
        return result;
    }

    @Override
    public Boolean usernameInRepo(String username)
    {
        if (Objects.equals(username, "null")) return Boolean.FALSE;
        try {
            String query = "SELECT COUNT(*) AS row_count FROM employee WHERE username = ?";
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
    public Employee searchByUsername(String username)
    {
        if (Objects.equals(username, "null")) return Employee.getNullEmployee();
        try {
            String query = "SELECT * FROM employee WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            // Analyse result
            if (resultSet.next())
            {
                Person person = personDao.searchByUsername(username);
                if (person.equals(Person.getNullPerson())) return Employee.getNullEmployee();
                int salary = resultSet.getInt("salary");
                return new Employee(person.getUsername(), person.getName(), person.getBirthDate(), person.getGender(), salary);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // No subscription type found
        return Employee.getNullEmployee();
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
