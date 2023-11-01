package repository.inMemoryRepository;

import domain.money.SubscriptionType;
import repository.IRepository;
import repository.Repository;

import java.util.ArrayList;

public class SubscriptionTypeRepository extends Repository<SubscriptionType>
{
    private static SubscriptionTypeRepository instance;

    private SubscriptionTypeRepository()
    {
        SubscriptionType subscriptionType1 = new SubscriptionType("Silver", "Basic plan", 100);
        SubscriptionType subscriptionType2 = new SubscriptionType("Diamond", "King", 1000);
        arrayList.add(subscriptionType1);
        arrayList.add(subscriptionType2);
    }

    public static SubscriptionTypeRepository getInstance()
    {
        if (instance == null) instance = new SubscriptionTypeRepository();
        return instance;
    }
}
