package repository.inMemoryRepository;

import domain.money.SubscriptionType;
import repository.IRepository;

import java.util.ArrayList;

public class SubscriptionTypeRepository implements IRepository<SubscriptionType>
{
    private final ArrayList<SubscriptionType> subscriptionTypes;

    private static SubscriptionTypeRepository instance;

    private SubscriptionTypeRepository()
    {
        subscriptionTypes = new ArrayList<>();
        SubscriptionType subscriptionType1 = new SubscriptionType("Silver", "Basic plan", 100);
        SubscriptionType subscriptionType2 = new SubscriptionType("Diamond", "King", 1000);
        subscriptionTypes.add(subscriptionType1);
        subscriptionTypes.add(subscriptionType2);
    }

    public static SubscriptionTypeRepository getInstance()
    {
        if (instance == null) instance = new SubscriptionTypeRepository();
        return instance;
    }

    @Override
    public void add(SubscriptionType object) {
        subscriptionTypes.add(object);
    }

    @Override
    public void update(SubscriptionType object) {
        subscriptionTypes.remove(object);
        subscriptionTypes.add(object);
    }

    @Override
    public void delete(SubscriptionType object) {
        subscriptionTypes.remove(object);
    }

    @Override
    public ArrayList<SubscriptionType> getAll() {
        return new ArrayList<>(subscriptionTypes);
    }
}
