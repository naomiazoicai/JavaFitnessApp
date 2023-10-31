package repository.inMemoryRepository;

import domain.money.Customer;
import repository.IRepository;

import java.util.ArrayList;

public class SubscriptionTypeRepository implements IRepository<Customer>
{
    private final ArrayList<Customer> subscriptionTypes;

    private static SubscriptionTypeRepository instance;

    private SubscriptionTypeRepository()
    {
        subscriptionTypes = new ArrayList<>();
        Customer subscriptionType1 = new Customer("Silver", "Basic plan", 100);
        Customer subscriptionType2 = new Customer("Diamond", "King", 1000);
        subscriptionTypes.add(subscriptionType1);
        subscriptionTypes.add(subscriptionType2);
    }

    public static SubscriptionTypeRepository getInstance()
    {
        if (instance == null) instance = new SubscriptionTypeRepository();
        return instance;
    }

    @Override
    public void add(Customer object) {
        subscriptionTypes.add(object);
    }

    @Override
    public void update(Customer object) {
        subscriptionTypes.remove(object);
        subscriptionTypes.add(object);
    }

    @Override
    public void delete(Customer object) {
        subscriptionTypes.remove(object);
    }

    @Override
    public ArrayList<Customer> getAll() {
        return new ArrayList<>(subscriptionTypes);
    }
}
