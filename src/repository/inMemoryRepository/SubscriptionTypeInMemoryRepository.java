package repository.inMemoryRepository;

import domain.gym.Room;
import domain.money.SubscriptionType;
import repository.InMemoryRepository;
import repository.interfaces.ISubscriptionTypeRepository;

import java.util.ArrayList;

public class SubscriptionTypeInMemoryRepository extends InMemoryRepository<SubscriptionType> implements ISubscriptionTypeRepository
{
    private static SubscriptionTypeInMemoryRepository instance;

    private SubscriptionTypeInMemoryRepository()
    {
        SubscriptionType subscriptionType1 = new SubscriptionType("Silver", "Basic plan", 100);
        SubscriptionType subscriptionType2 = new SubscriptionType("Diamond", "King", 1000);
        arrayList.add(subscriptionType1);
        arrayList.add(subscriptionType2);
    }

    public static SubscriptionTypeInMemoryRepository getInstance()
    {
        if (instance == null) instance = new SubscriptionTypeInMemoryRepository();
        return instance;
    }

    @Override
    public Boolean usernameInRepo(String keyName) {
        for (SubscriptionType subscriptionType : arrayList)
        {
            if (keyName.equals(subscriptionType.getName())) return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public ArrayList<SubscriptionType> searchByPartialKeyName(String keyName) {
        ArrayList<SubscriptionType> result = new ArrayList<>();
        for (SubscriptionType subscriptionType : arrayList)
        {
            if (subscriptionType.getName().contains(keyName)) result.add(subscriptionType.copy());
        }
        return result;
    }

    @Override
    public SubscriptionType searchByUsername(String keyName) {
        for (SubscriptionType subscriptionType : arrayList)
        {
            if (keyName.equals(subscriptionType.getName())) return subscriptionType.copy();
        }
        return new SubscriptionType();
    }

    @Override
    public void addRoomToSubscription(SubscriptionType subscriptionType, Room room) {
        for (SubscriptionType subscription : arrayList)
        {
            if (subscription.equals(subscriptionType))
            {
                subscription.addRoomAccess(room);
                return;
            }
        }
    }

    @Override
    public void removeRoomFromSubscription(SubscriptionType subscriptionType, Room room) {
        for (SubscriptionType subscription : arrayList)
        {
            if (subscription.equals(subscriptionType))
            {
                subscription.removeRoomAccess(room);
                return;
            }
        }
    }

    @Override
    public void roomDeleted(Room room) {
        for (SubscriptionType subscriptionType : arrayList)
        {
            subscriptionType.removeRoomAccess(room);
        }
    }
}
