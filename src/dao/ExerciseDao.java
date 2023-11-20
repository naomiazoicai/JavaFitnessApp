package dao;

import dao.interaces.IExerciseDao;
import domain.gym.EquipmentItem;
import domain.gym.Exercise;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

public class ExerciseDao implements IDao<Exercise>, IExerciseDao {
    private static ExerciseDao instance;

    private ExerciseDao(){}

    public static ExerciseDao getInstance()
    {
        if (instance == null) instance = new ExerciseDao();
        return instance;
    }

    @Override
    public void addEntity(Exercise exercise) throws ObjectAlreadyContained {
        int id = generateNextId();
        String name = exercise.getName();
        String muscleTrained = exercise.getMuscleTrained();
        int equipmentItemId = exercise.getEquipmentUsed().getID();
        int sets = exercise.getSets();
        int reps = exercise.getReps();
        try {
            String updateQuery = "INSERT INTO exercise VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(updateQuery);
            insertStatement.setInt(1, id);
            insertStatement.setString(2, name);
            insertStatement.setString(3, muscleTrained);
            insertStatement.setInt(4, equipmentItemId);
            insertStatement.setInt(5, sets);
            insertStatement.setInt(6, reps);
            insertStatement.executeUpdate();
        }
        catch (SQLIntegrityConstraintViolationException e) {
            if (e.getErrorCode() == 1452) throw new RuntimeException(e);
            throw new ObjectAlreadyContained();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateEntity(Exercise exercise) throws ObjectNotContained {
        int id = exercise.getId();
        if (id == 0) throw new ObjectNotContained();
        String name = exercise.getName();
        String muscleTrained = exercise.getMuscleTrained();
        int equipmentItemId = exercise.getEquipmentUsed().getID();
        int sets = exercise.getSets();
        int reps = exercise.getReps();
        try {
            String updateQuery = "UPDATE exercise SET name = ?, muscleTrained = ?, equipmentItemId = ?, sets = ?, reps =? WHERE id = ?;";
            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
            updateStatement.setString(1, name);
            updateStatement.setString(2, muscleTrained);
            updateStatement.setInt(3, equipmentItemId);
            updateStatement.setInt(4, sets);
            updateStatement.setInt(5, reps);
            updateStatement.setInt(6, id);
            int rowsAffected = updateStatement.executeUpdate();
            if (rowsAffected == 0) throw new ObjectNotContained();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEntity(Exercise exercise) throws ObjectNotContained {
        int id = exercise.getId();
        if (id == 0) throw new ObjectNotContained();
        try {
            String deleteQuery = "DELETE FROM exercise WHERE id = ?;";
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
    public ArrayList<Exercise> getAllEntities() {
        ArrayList<Exercise> result = new ArrayList<>();
        try {
            String query = "SELECT * FROM exercise";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next())
            {
                Exercise exercise = new Exercise();
                exercise.setId(resultSet.getInt("id"));
                exercise.setName(resultSet.getString("name"));
                exercise.setMuscleTrained(resultSet.getString("muscleTrained"));
                exercise.setSets(resultSet.getInt("sets"));
                exercise.setReps(resultSet.getInt("reps"));
                exercise.setEquipmentUsed(EquipmentItemDao.getInstance().searchById(resultSet.getInt("equipmentItemId")));
                result.add(exercise);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        result.remove(new Exercise(0));
        return result;
    }

    @Override
    public Boolean idInRepo(int id) {
        if (id == 0) return Boolean.FALSE;
        try {
            String query = "SELECT COUNT(*) AS row_count FROM exercise WHERE id = ?";
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
    public Exercise searchById(int id) {
        if (id == 0) return Exercise.getNullExercise();
        try {
            String query = "SELECT * FROM exercise WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
            {
                Exercise exercise = new Exercise();
                exercise.setId(resultSet.getInt("id"));
                exercise.setName(resultSet.getString("name"));
                exercise.setMuscleTrained(resultSet.getString("muscleTrained"));
                exercise.setSets(resultSet.getInt("sets"));
                exercise.setReps(resultSet.getInt("reps"));
                exercise.setEquipmentUsed(EquipmentItemDao.getInstance().searchById(resultSet.getInt("equipmentItemId")));
                return exercise;
            }
        }  catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Exercise.getNullExercise();
    }

    @Override
    public int generateNextId() {
        try {
            String query = "SELECT id FROM exercise ORDER BY id DESC LIMIT 1";
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

    @Override
    public void equipmentItemDeleted(EquipmentItem removedEquipmentItem) {
        int id = removedEquipmentItem.getID();
        try {
            String insertQuery = "UPDATE exercise SET equipmentItemId = 0 WHERE equipmentItemId = ?";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setInt(1, id);
            insertStatement.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
