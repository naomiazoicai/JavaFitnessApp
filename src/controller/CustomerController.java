package controller;

import domain.persons.Customer;
import repository.inMemoryRepository.CustomerRepository;

public class CustomerController implements IController<Customer>
{
    private final CustomerRepository repository;
    private static CustomerController instance;

    private CustomerController(CustomerRepository repository)
    {
        this.repository = repository;
    }

    public static CustomerController getInstance(CustomerRepository repository)
    {
        if (instance == null) instance = new CustomerController(repository);
        return instance;
    }

    public static CustomerController getInstance()
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
}
