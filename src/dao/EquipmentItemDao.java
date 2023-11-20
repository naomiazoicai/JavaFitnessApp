package dao;

import dao.interaces.IEquipmentItemDao;
import domain.gym.EquipmentItem;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

public class EquipmentItemDao implements IDao<EquipmentItem>, IEquipmentItemDao {
    private static EquipmentItemDao instance;

    private EquipmentItemDao(){}

    public static EquipmentItemDao getInstance()
    {
        if (instance == null) instance = new EquipmentItemDao();
        return instance;
    }

    @Override
    public void insertEntity(EquipmentItem equipmentItem) throws ObjectAlreadyContained {
        int id = generateNextId();
        String name = equipmentItem.getName();
        try {
            String insertQuery = "INSERT INTO equipmentitem (id, name) VALUES (?, ?);";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setInt(1, id);
            insertStatement.setString(2, name);
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
    public void updateEntity(EquipmentItem equipmentItem) throws ObjectNotContained {
        // Add object
        int id = equipmentItem.getID();
        String name = equipmentItem.getName();
        try {
            String updateQuery = "UPDATE equipmentitem SET name = ? WHERE id = ?;";
            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
            updateStatement.setString(1, name);
            updateStatement.setInt(2, id);
            int rowsAffected = updateStatement.executeUpdate();
            if (rowsAffected == 0) throw new ObjectNotContained();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEntity(EquipmentItem equipmentItem) throws ObjectNotContained {
        int id = equipmentItem.getID();
        try {
            String deleteQuery = "DELETE FROM equipmentitem WHERE id = ?;";
            PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
            deleteStatement.setInt(1, id);
            int rowsAffected = deleteStatement.executeUpdate();
            if (rowsAffected == 0) throw new ObjectNotContained();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<EquipmentItem> getAllEntities() {
        ArrayList<EquipmentItem> result = new ArrayList<>();

        try {
            String query = "SELECT * FROM equipmentitem";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next())
            {
                EquipmentItem equipmentItem = new EquipmentItem();
                equipmentItem.setID(resultSet.getInt("id"));
                equipmentItem.setName(resultSet.getString("name"));
                result.add(equipmentItem);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public Boolean idInRepo(int id) {
        try {
            String query = "SELECT COUNT(*) AS row_count FROM equipmentitem WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
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
    public EquipmentItem searchById(int id){
        try {
            String query = "SELECT * FROM equipmentitem WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
            {
                EquipmentItem equipmentItem = new EquipmentItem();
                equipmentItem.setID(resultSet.getInt("id"));
                equipmentItem.setName(resultSet.getString("name"));
                return equipmentItem;
            }
        }  catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return EquipmentItem.getNullEquipmentItem();
    }

    @Override
    public int generateNextId() {
        try {
            String query = "SELECT id FROM equipmentitem E ORDER BY id DESC LIMIT 1";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) return resultSet.getInt("id") + 1;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        throw new RuntimeException();
    }
}
