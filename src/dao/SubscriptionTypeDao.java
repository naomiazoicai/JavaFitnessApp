package dao;

import dao.interaces.ISubscriptionTypeDao;
import domain.gym.Room;
import domain.money.SubscriptionType;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;

import java.sql.*;
import java.util.ArrayList;

public class SubscriptionTypeDao implements IDao<SubscriptionType>, ISubscriptionTypeDao
{
    private static SubscriptionTypeDao instance;
    private final SpecialisedRoomDao roomDao;

    private SubscriptionTypeDao()
    {
        roomDao = SpecialisedRoomDao.getInstance();
    }

    public static SubscriptionTypeDao getInstance()
    {
        if (instance == null) instance = new SubscriptionTypeDao();
        return instance;
    }

    @Override
    public void addEntity(SubscriptionType subscriptionType) throws ObjectAlreadyContained
    {
        if (subscriptionType.getName().equals("null")) throw new ObjectAlreadyContained();
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
    public void updateEntity(SubscriptionType subscriptionType) throws ObjectNotContained
    {
        if (subscriptionType.getName().equals("null")) throw new ObjectNotContained();
        String name = subscriptionType.getName();
        String description = subscriptionType.getDescription();
        double price = subscriptionType.getPrice();
        try {
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
    public void deleteEntity(SubscriptionType subscriptionType) throws ObjectNotContained
    {
        if (subscriptionType.getName().equals("null")) throw new ObjectNotContained();
        String name = subscriptionType.getName();
        try {
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
    public ArrayList<SubscriptionType> getAllEntities()
    {
        ArrayList<SubscriptionType> result = new ArrayList<>();
        try {
            String query = "SELECT * FROM subscriptiontype ORDER BY price";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                SubscriptionType subscriptionType = new SubscriptionType();
                subscriptionType.setName(resultSet.getString("name"));
                subscriptionType.setDescription(resultSet.getString("description"));
                subscriptionType.setPrice(resultSet.getDouble("price"));
                addRooms(subscriptionType);
                // Return
                result.add(subscriptionType);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        result.remove(SubscriptionType.getNullSubscriptionType());
        return result;
    }

    private void addRooms (SubscriptionType subscriptionType) throws SQLException {
        // Add rooms
        String roomQuery = "SELECT roomId FROM accessiblerestrictedroom WHERE subscriptionTypeName = ?";
        PreparedStatement roomStatement = connection.prepareStatement(roomQuery);
        roomStatement.setString(1, subscriptionType.getName());
        ResultSet roomResultSet = roomStatement.executeQuery();
        while (roomResultSet.next())
        {
            int roomId = roomResultSet.getInt("roomId");
            if (roomDao.idInRepo(roomId))
            {
                Room room = roomDao.searchById(roomId);
                subscriptionType.addRoomAccess(room);
            }
        }
    }

    @Override
    public Boolean nameInRepo(String name)
    {
        try {
            String query = "SELECT COUNT(*) AS row_count FROM subscriptiontype WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
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
    public ArrayList<SubscriptionType> searchByPartialName(String name)
    {
        ArrayList<SubscriptionType> result = new ArrayList<>();
        String partialName = "%" + name + "%";
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
                addRooms(subscriptionType);
                result.add(subscriptionType);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public SubscriptionType searchByName(String name)
    {
        try {
            String query = "SELECT * FROM subscriptiontype WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            // Analyse result
            if (resultSet.next())
            {
                SubscriptionType subscriptionType = new SubscriptionType();
                subscriptionType.setName(resultSet.getString("name"));
                subscriptionType.setDescription(resultSet.getString("description"));
                subscriptionType.setPrice(resultSet.getDouble("price"));
                addRooms(subscriptionType);
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
    public void addRoomToSubscription(SubscriptionType subscriptionType, Room room)
    {
        String subscriptionName = subscriptionType.getName();
        if (!nameInRepo(subscriptionName)) return;
        int roomId = room.getId();
        if (!roomDao.idInRepo(roomId)) return;
        try{
            String query = "INSERT INTO accessiblerestrictedroom (roomId, subscriptionTypeName) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, roomId);
            statement.setString(2, subscriptionName);
            statement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException ignore){} // IF already added, ignore
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeRoomFromSubscription(SubscriptionType subscriptionType, Room room)
    {
        String subscriptionName = subscriptionType.getName();
        if (!nameInRepo(subscriptionName)) return;
        int roomId = room.getId();
        if (!roomDao.idInRepo(roomId)) return;
        try{
            String query = "DELETE FROM accessiblerestrictedroom WHERE roomId = ? AND subscriptionTypeName = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, roomId);
            statement.setString(2, subscriptionName);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void roomDeleted(Room room)
    {
        int id = room.getId();
        try {
            String insertQuery = "DELETE FROM accessiblerestrictedroom WHERE roomId = ?";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setInt(1, id);
            insertStatement.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
