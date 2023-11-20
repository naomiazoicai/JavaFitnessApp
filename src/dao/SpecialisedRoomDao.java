package dao;

import dao.interaces.ISpecialisedRoomDao;
import domain.gym.*;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

public class SpecialisedRoomDao implements IDao<SpecialisedRoom>, ISpecialisedRoomDao {
    private static SpecialisedRoomDao instance;

    private SpecialisedRoomDao(){}

    public static SpecialisedRoomDao getInstance()
    {
        if (instance == null) instance = new SpecialisedRoomDao();
        return instance;
    }

    @Override
    public void addEntity(SpecialisedRoom specialisedRoom) throws ObjectAlreadyContained {
        int id = generateNextId();
        boolean occupied = specialisedRoom.isOccupied();
        RoomAccess roomAccess = specialisedRoom.getRoomAccess();
        int personCapacity = specialisedRoom.getPersonCapacity();
        RoomType roomType = specialisedRoom.getRoomType();
        try {
            // Insert in room
            String insertQuery = "INSERT INTO room (id, occupied, roomAccess) VALUES (?, ?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setInt(1, id);
            insertStatement.setBoolean(2, occupied);
            insertStatement.setString(3, roomAccess.toString());
            insertStatement.executeUpdate();
            // Insert in specialisedRoom
            insertQuery = "INSERT INTO specialisedroom (roomId, personCapacity, roomType) VALUES (?, ?, ?)";
            insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setInt(1, id);
            insertStatement.setInt(2, personCapacity);
            insertStatement.setString(3, roomType.toString());
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
    public void updateEntity(SpecialisedRoom specialisedRoom) throws ObjectNotContained {
        int id = specialisedRoom.getId();
        boolean occupied = specialisedRoom.isOccupied();
        RoomAccess roomAccess = specialisedRoom.getRoomAccess();
        int personCapacity = specialisedRoom.getPersonCapacity();
        RoomType roomType = specialisedRoom.getRoomType();
        try {
            // Insert in room
            String insertQuery = "UPDATE room SET occupied = ?, roomAccess = ? WHERE id = ?";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setInt(3, id);
            insertStatement.setBoolean(1, occupied);
            insertStatement.setString(2, roomAccess.toString());
            insertStatement.executeUpdate();
            // Insert in specialisedRoom
            insertQuery = "UPDATE specialisedroom SET personCapacity = ?, roomType = ? WHERE roomId = ?";
            insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setInt(3, id);
            insertStatement.setInt(1, personCapacity);
            insertStatement.setString(2, roomType.toString());
            insertStatement.executeUpdate();

        }
        catch (SQLIntegrityConstraintViolationException e) {
            throw new ObjectNotContained();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEntity(SpecialisedRoom specialisedRoom) throws ObjectNotContained {
        int id = specialisedRoom.getId();
        if (id == 0) throw new ObjectNotContained();
        try {
            // Delete from specialisedRoom
            String deleteQuery = "DELETE FROM specialisedroom WHERE roomId = ?;";
            PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
            deleteStatement.setInt(1, id);
            int rowsAffected = deleteStatement.executeUpdate();
            if (rowsAffected == 0) throw new ObjectNotContained();
            // Delete from room
            deleteQuery = "DELETE FROM room WHERE id = ?;";
            deleteStatement = connection.prepareStatement(deleteQuery);
            deleteStatement.setInt(1, id);
            rowsAffected = deleteStatement.executeUpdate();
            if (rowsAffected == 0) throw new ObjectNotContained();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<SpecialisedRoom> getAllEntities() {
        ArrayList<SpecialisedRoom> result = new ArrayList<>();
        try {
            String query = "SELECT * FROM specialisedroom";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                SpecialisedRoom specialisedRoom = new SpecialisedRoom();
                specialisedRoom.setId(resultSet.getInt("roomId"));
                Room room = searchRoomById(specialisedRoom.getId());
                specialisedRoom.setOccupied(room.isOccupied());
                specialisedRoom.setRoomAccess(room.getRoomAccess());
                specialisedRoom.setPersonCapacity(resultSet.getInt("personCapacity"));
                specialisedRoom.setRoomType(RoomType.valueOf(resultSet.getString("roomType")));
                result.add(specialisedRoom);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        result.remove(new SpecialisedRoom(0));
        return result;
    }

    @Override
    public Boolean idInRepo(int id) {
        if (id == 0) return Boolean.FALSE;
        try {
            String query = "SELECT COUNT(*) AS row_count FROM room WHERE id = ?";
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
    public SpecialisedRoom searchById(int id) {
        if (id == 0) return SpecialisedRoom.getNullSpecialisedRoom();
        try {
            String query = "SELECT * FROM specialisedroom WHERE roomId = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
            {
                SpecialisedRoom specialisedRoom = new SpecialisedRoom();
                Room room = searchRoomById(id);
                specialisedRoom.setId(id);
                specialisedRoom.setOccupied(room.isOccupied());
                specialisedRoom.setRoomAccess(room.getRoomAccess());
                specialisedRoom.setPersonCapacity(resultSet.getInt("personCapacity"));
                specialisedRoom.setRoomType(RoomType.valueOf(resultSet.getString("roomType")));
                return specialisedRoom;
            }
        }  catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return SpecialisedRoom.getNullSpecialisedRoom();
    }

    private Room searchRoomById(int id)
    {
        if (id == 0) return Room.getNullRoom();
        try {
            String query = "SELECT * FROM room WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
            {
                Room room = new Room();
                room.setId(resultSet.getInt("id"));
                room.setOccupied(resultSet.getBoolean("occupied"));
                room.setRoomAccess(RoomAccess.valueOf(resultSet.getString("roomAccess")));
                return room;
            }
        }  catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return SpecialisedRoom.getNullSpecialisedRoom();
    }

    @Override
    public int generateNextId() {
        try {
            String query = "SELECT id FROM room ORDER BY id DESC LIMIT 1";
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
