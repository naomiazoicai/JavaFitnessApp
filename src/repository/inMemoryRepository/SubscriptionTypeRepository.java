package repository.inMemoryRepository;

import domain.money.SubscriptionType;
import repository.Repository;
import repository.exceptions.ObjectNotContained;
import repository.interfaces.ISubscriptionTypeRepository;

import java.util.ArrayList;

public class SubscriptionTypeRepository extends Repository<SubscriptionType> implements ISubscriptionTypeRepository
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

    @Override
    public Boolean keyNameInRepo(String keyName) {
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
    public SubscriptionType searchByKeyName(String keyName) {
        for (SubscriptionType subscriptionType : arrayList)
        {
            if (keyName.equals(subscriptionType.getName())) return subscriptionType.copy();
        }
        return new SubscriptionType();
    }
}
