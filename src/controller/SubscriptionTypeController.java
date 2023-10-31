package controller;

import domain.money.SubscriptionType;
import domain.persons.Customer;
import repository.inMemoryRepository.CustomerRepository;
import repository.inMemoryRepository.SubscriptionTypeRepository;

public class SubscriptionTypeController implements IController<SubscriptionType>{
    private final SubscriptionTypeRepository repository;
    private static SubscriptionTypeController instance;

    private SubscriptionTypeController(SubscriptionTypeRepository repository)
    {
        this.repository = repository;
    }

    public static SubscriptionTypeController getInstance(SubscriptionTypeRepository repository)
    {
        if (instance == null) instance = new SubscriptionTypeController(repository);
        return instance;
    }

    public static SubscriptionTypeController getInstance()
    {
        if (instance == null) throw new Error("Repository was never provided");
        return instance;
    }

    @Override
    public void add(SubscriptionType object)
    {
        repository.add(object);
    }

    @Override
    public void update(SubscriptionType object)
    {
        repository.update(object);
    }

    @Override
    public void delete(SubscriptionType object)
    {
        repository.delete(object);
    }
}
