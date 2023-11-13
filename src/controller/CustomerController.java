package controller;

import controller.interfaces.ICustomerController;
import domain.persons.Customer;
import repository.inMemoryRepository.CustomerRepository;
import repository.interfaces.ICustomerRepository;

import java.util.ArrayList;


public class CustomerController extends Controller<Customer> implements ICustomerController
{
    private static CustomerController instance;

    private final ICustomerRepository ICustomerRepository;

    private CustomerController(CustomerRepository customerRepository)
    {
        super(customerRepository);
        ICustomerRepository = customerRepository;
    }

    public static CustomerController getInstance()
    {
        if (instance == null) instance = new CustomerController(CustomerRepository.getInstance());
        return instance;
    }

    @Override
    public ArrayList<Customer> searchByPartialKeyName(String keyName)
    {
        return ICustomerRepository.searchByPartialKeyName(keyName);
    }

    @Override
    public Boolean keyNameInRepo(String keyName)
    {
        return ICustomerRepository.keyNameInRepo(keyName);
    }

    @Override
    public Customer searchByKeyName(String keyName) {
        return ICustomerRepository.searchByKeyName(keyName);
    }
}
