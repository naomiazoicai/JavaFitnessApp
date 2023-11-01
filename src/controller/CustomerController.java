package controller;

import domain.persons.Customer;
import repository.inMemoryRepository.CustomerRepository;


public class CustomerController extends Controller<Customer>
{
    private static CustomerController instance;

    private CustomerController()
    {
        super(CustomerRepository.getInstance());
    }

    public static CustomerController getInstance()
    {
        if (instance == null) instance = new CustomerController();
        return instance;
    }
}
