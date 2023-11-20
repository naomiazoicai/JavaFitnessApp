package dao;

import dao.interaces.ISubscriptionTypeDao;
import domain.gym.Room;
import domain.money.SubscriptionType;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;

import java.sql.*;
import java.util.ArrayList;

public class SubscriptionTypeDao implements IDao<SubscriptionType>, ISubscriptionTypeDao {
    private static SubscriptionTypeDao instance;

    private SubscriptionTypeDao(){
    }

    public static SubscriptionTypeDao getInstance()
    {
        if (instance == null) instance = new SubscriptionTypeDao();
        return instance;
    }

    @Override
    public void insertEntity(SubscriptionType subscriptionType) throws ObjectAlreadyContained {
        String name = subscriptionType.getName();
        String description = subscriptionType.getDescription();
        double price = subscriptionType.getPrice();
        try {
            String insertQuery = "INSERT INTO SubscriptionType(name, description, price) VALUES (?, ?, ?);";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setString(1, name);
            insertStatement.setString(2, description);
            insertStatement.setDouble(3, price);
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
    public void updateEntity(SubscriptionType subscriptionType) throws ObjectNotContained {
        try {
            // Add object
            String name = subscriptionType.getName();
            String description = subscriptionType.getDescription();
            double price = subscriptionType.getPrice();

            String updateQuery = "UPDATE subscriptiontype SET description = ?, price = ? WHERE name = ?;";
            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
            updateStatement.setString(1, description);
            updateStatement.setDouble(2, price);
            updateStatement.setString(3, name);
            int rowsAffected = updateStatement.executeUpdate();
            if (rowsAffected == 0) throw new ObjectNotContained();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEntity(SubscriptionType subscriptionType) throws ObjectNotContained {
        try {
            // Add object
            String name = subscriptionType.getName();

            String deleteQuery = "DELETE FROM subscriptiontype WHERE name = ?;";
            PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
            deleteStatement.setString(1, name);
            int rowsAffected = deleteStatement.executeUpdate();
            if (rowsAffected == 0) throw new ObjectNotContained();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<SubscriptionType> getAllEntities() {
        ArrayList<SubscriptionType> result = new ArrayList<>();

        try {
            String query = "SELECT * FROM subscriptiontype ORDER BY price ASC;";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next())
            {
                SubscriptionType subscriptionType = new SubscriptionType();
                subscriptionType.setName(resultSet.getString("name"));
                subscriptionType.setDescription(resultSet.getString("description"));
                subscriptionType.setPrice(resultSet.getDouble("price"));
                result.add(subscriptionType);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public Boolean keyNameInRepo(String keyName) {
        try {
            String query = "SELECT COUNT(*) AS row_count FROM subscriptiontype WHERE name = ?";
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
    public ArrayList<SubscriptionType> searchByPartialKeyName(String keyName) {
        ArrayList<SubscriptionType> result = new ArrayList<>();
        String partialName = "%" + keyName + "%";
        try {
            String query = "SELECT * FROM subscriptiontype WHERE name LIKE ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, partialName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                SubscriptionType subscriptionType = new SubscriptionType();
                subscriptionType.setName(resultSet.getString("name"));
                subscriptionType.setDescription(resultSet.getString("description"));
                subscriptionType.setPrice(resultSet.getDouble("price"));
                result.add(subscriptionType);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public SubscriptionType searchByKeyName(String keyName) {
        try {
            String query = "SELECT * FROM subscriptiontype WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, keyName);
            ResultSet resultSet = statement.executeQuery();
            // Analyse result
            if (resultSet.next())
            {
                SubscriptionType subscriptionType = new SubscriptionType();
                subscriptionType.setName(resultSet.getString("name"));
                subscriptionType.setDescription(resultSet.getString("description"));
                subscriptionType.setPrice(resultSet.getDouble("price"));
                return subscriptionType;
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // No subscription type found
        return new SubscriptionType();
    }

    @Override
    public void addRoomToSubscription(SubscriptionType subscriptionType, Room room) {
        //TODO
    }

    @Override
    public void removeRoomFromSubscription(SubscriptionType subscriptionType, Room room) {
        //TODO
    }

    @Override
    public void roomDeleted(Room room) {
        //TODO
    }
}
