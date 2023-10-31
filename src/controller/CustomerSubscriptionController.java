package controller;

import domain.money.CustomerSubscription;
import repository.exceptions.ObjectAlreadyContained;
import repository.inMemoryRepository.CustomerSubscriptionRepository;

import java.util.ArrayList;

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
    public void add(CustomerSubscription object) throws ObjectAlreadyContained {
        repository.add(object);
    }

    @Override
    public void update(CustomerSubscription object) throws ObjectAlreadyContained {
        repository.add(object);
    }

    @Override
    public void delete(CustomerSubscription object) throws ObjectAlreadyContained {
        repository.add(object);
    }

    @Override
    public ArrayList<CustomerSubscription> getAll() {
        return repository.getAll();
    }
}
