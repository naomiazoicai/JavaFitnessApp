package dao;

import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;

import java.sql.Connection;
import java.util.ArrayList;

public interface IDao<Entity>{
    Connection connection = DatabaseConnection.getConnection();
    void insertEntity(Entity entity) throws ObjectAlreadyContained;

    void updateEntity(Entity entity) throws ObjectNotContained;

    void deleteEntity(Entity entity) throws ObjectNotContained;

    ArrayList<Entity> getAllEntities();
}
