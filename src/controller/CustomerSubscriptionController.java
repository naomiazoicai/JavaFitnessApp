package controller;

import domain.money.CustomerSubscription;
import repository.inMemoryRepository.CustomerRepository;
import repository.inMemoryRepository.CustomerSubscriptionRepository;

public class CustomerSubscriptionController implements IController<CustomerSubscription>
{
    private final CustomerSubscriptionRepository repository;
    private static CustomerSubscriptionController instance;

    private CustomerSubscriptionController(CustomerSubscriptionRepository repository)
    {
        this.repository = repository;
    }

    public static CustomerSubscriptionController getInstance(CustomerSubscriptionRepository repository)
    {
        if (instance == null) instance = new CustomerSubscriptionController(repository);
        return instance;
    }

    public static CustomerSubscriptionController getInstance()
    {
        if (instance == null) throw new Error("Repository was never provided");
        return instance;
    }

    @Override
    public void add(CustomerSubscription object)
    {
        repository.add(object);
    }

    @Override
    public void update(CustomerSubscription object)
    {
        repository.add(object);
    }

    @Override
    public void delete(CustomerSubscription object)
    {
        repository.add(object);
    }
}
