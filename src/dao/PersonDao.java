package dao;

import dao.interaces.IPersonDao;
import domain.persons.Gender;
import domain.persons.Person;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class PersonDao implements IDao<Person>, IPersonDao
{
    private static PersonDao instance;
    private PersonDao(){}

    public static PersonDao getInstance()
    {
        if (instance == null) instance = new PersonDao();
        return instance;
    }

    @Override
    public void addEntity(Person person) throws ObjectAlreadyContained
    {
        if (Objects.equals(person.getUsername(), "null")) throw new ObjectAlreadyContained();
        // Save fields
        String username = person.getUsername();
        String name = person.getName();
        LocalDate birthdate = person.getBirthDate();
        Gender gender = person.getGender();
        // Add
        try {
            String insertQuery = "INSERT INTO person (username, name, birthdate, gender) VALUES (?, ?, ?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setString(1, username);
            insertStatement.setString(2, name);
            insertStatement.setDate(3, Date.valueOf(birthdate));
            insertStatement.setString(4, gender.toString());
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
    public void updateEntity(Person person) throws ObjectNotContained
    {
        if (Objects.equals(person.getUsername(), "null")) throw new ObjectNotContained();
        // Save fields
        String username = person.getUsername();
        String name = person.getName();
        LocalDate birthdate = person.getBirthDate();
        Gender gender = person.getGender();
        // Update
        try {
            String insertQuery = "UPDATE person SET name = ?, birthdate = ?, gender = ? WHERE username = ?";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setString(4, username);
            insertStatement.setString(1, name);
            insertStatement.setDate(2, Date.valueOf(birthdate));
            insertStatement.setString(3, gender.toString());
            int rowsAffected = insertStatement.executeUpdate();
            if (rowsAffected == 0) throw new ObjectNotContained();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEntity(Person person) throws ObjectNotContained
    {
        if (Objects.equals(person.getUsername(), "null")) throw new ObjectNotContained();
        String username = person.getUsername();
        try {
            String insertQuery = "DELETE FROM person WHERE username = ?";
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
    public ArrayList<Person> getAllEntities()
    {
        ArrayList<Person> result = new ArrayList<>();
        try {
            String query = "SELECT * FROM person ORDER BY username;";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                String username = resultSet.getString("username");
                String name = resultSet.getString("name");
                LocalDate birthdate = resultSet.getDate("birthDate").toLocalDate();
                Gender gender = Gender.valueOf(resultSet.getString("gender"));
                Person person = new Person(username, name, birthdate, gender);
                result.add(person);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        result.remove(Person.getNullPerson());
        return result;
    }

    @Override
    public Person searchByUsername(String username)
    {
        if (Objects.equals(username, "null")) return Person.getNullPerson();
        try {
            String query = "SELECT * FROM person WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            // Analyse result
            if (resultSet.next())
            {
                String name = resultSet.getString("name");
                LocalDate birthdate = resultSet.getDate("birthDate").toLocalDate();
                Gender gender = Gender.valueOf(resultSet.getString("gender"));
                return new Person(username, name, birthdate, gender);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // No subscription type found
        return Person.getNullPerson();
    }
}
