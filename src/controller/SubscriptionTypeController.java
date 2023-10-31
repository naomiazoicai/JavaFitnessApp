package controller;

import domain.money.Customer;
import repository.inMemoryRepository.SubscriptionTypeRepository;

import java.util.ArrayList;

public class SubscriptionTypeController implements IController<Customer>{
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
    public void add(Customer object)
    {
        repository.add(object);
    }

    @Override
    public void update(Customer object)
    {
        repository.update(object);
    }

    @Override
    public void delete(Customer object)
    {
        repository.delete(object);
    }

    @Override
    public ArrayList<Customer> getAll() {
        return repository.getAll();
    }
}
