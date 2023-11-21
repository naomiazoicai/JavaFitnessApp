package repository.databaseRepository;

import dao.SubscriptionTypeDao;
import dao.interaces.ISubscriptionTypeDao;
import domain.gym.Room;
import domain.money.SubscriptionType;
import repository.DatabaseRepository;
import repository.interfaces.ISubscriptionTypeRepository;

import java.util.ArrayList;

public class SubscriptionTypeDatabaseRepository extends DatabaseRepository<SubscriptionType> implements ISubscriptionTypeRepository
{
    private static SubscriptionTypeDatabaseRepository instance;

    private final ISubscriptionTypeDao subscriptionTypeDao;

    private SubscriptionTypeDatabaseRepository()
    {
        super(SubscriptionTypeDao.getInstance());
        subscriptionTypeDao = SubscriptionTypeDao.getInstance();
    }

    public static SubscriptionTypeDatabaseRepository getInstance()
    {
        if (instance == null) instance = new SubscriptionTypeDatabaseRepository();
        return instance;
    }

    @Override
    public void addRoomToSubscription(SubscriptionType subscriptionType, Room room)
    {
        subscriptionTypeDao.addRoomToSubscription(subscriptionType, room);
    }

    @Override
    public void removeRoomFromSubscription(SubscriptionType subscriptionType, Room room)
    {
        subscriptionTypeDao.removeRoomFromSubscription(subscriptionType, room);
    }

    @Override
    public void roomDeleted(Room room)
    {
        subscriptionTypeDao.roomDeleted(room);
    }

    @Override
    public Boolean keyNameInRepo(String keyName)
    {
        return subscriptionTypeDao.keyNameInRepo(keyName);
    }

    @Override
    public ArrayList<SubscriptionType> searchByPartialKeyName(String keyName)
    {
        return subscriptionTypeDao.searchByPartialKeyName(keyName);
    }

    @Override
    public SubscriptionType searchByKeyName(String keyName)
    {
        return subscriptionTypeDao.searchByKeyName(keyName);
    }
}
