package controller;

import controller.interfaces.CustomerControllerInterface;
import domain.persons.Customer;
import repository.inMemoryRepository.CustomerRepository;
import repository.interfaces.ICustomerRepository;

import java.util.ArrayList;


public class CustomerController extends Controller<Customer> implements CustomerControllerInterface, ISubjectNewCustomer
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
    public ArrayList<Customer> searchByPartialUsername(String username)
    {
        return ICustomerRepository.searchByPartialUsername(username);
    }

    @Override
    public Boolean usernameInRepo(String username)
    {
        return ICustomerRepository.usernameInRepo(username);
    }

    @Override
    public Customer searchByUsername(String username) {
        return ICustomerRepository.searchByUsername(username);
    }





    @Override
    public void registerObserver(IObserverNewCostumer observer) {
        observerList.add(observer);
    }

    @Override
    public boolean removeObserver(IObserverNewCostumer observer) {
        return observerList.remove(observer);
    }

    @Override
    public void notifyNewCustomerAdded() {

    }
}
