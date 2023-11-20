package dao;

import dao.interaces.ISubscriptionTypeDao;
import domain.gym.Room;
import domain.money.SubscriptionType;

import java.sql.SQLException;
import java.sql.Statement;
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
    public void insertEntity(SubscriptionType subscriptionType) {
        try {
            Statement statement = connection.createStatement();
            statement.executeQuery("INSERT INTO subscriptiontype (subscriptiontype.name, subscriptiontype.description, subscriptiontype.price);");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateEntity(SubscriptionType subscriptionType) {

    }

    @Override
    public void deleteEntity(SubscriptionType subscriptionType) {

    }

    @Override
    public ArrayList<SubscriptionType> getAllEntities() {
        return null;
    }

    @Override
    public Boolean keyNameInRepo(String keyName) {
        return null;
    }

    @Override
    public ArrayList<SubscriptionType> searchByPartialKeyName(String keyName) {
        return null;
    }

    @Override
    public SubscriptionType searchByKeyName(String keyName) {
        return null;
    }

    @Override
    public void addRoomToSubscription(SubscriptionType subscriptionType, Room room) {

    }

    @Override
    public void removeRoomFromSubscription(SubscriptionType subscriptionType, Room room) {

    }

    @Override
    public void roomDeleted(Room room) {

    }
}
