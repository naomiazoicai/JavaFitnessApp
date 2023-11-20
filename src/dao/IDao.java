package dao;

import java.sql.Connection;
import java.util.ArrayList;

public interface IDao<Entity>{
    Connection connection = DatabaseConnection.getConnection();
    void insertEntity(Entity entity);

    void updateEntity(Entity entity);

    void deleteEntity(Entity entity);

    ArrayList<Entity> getAllEntities();
}
