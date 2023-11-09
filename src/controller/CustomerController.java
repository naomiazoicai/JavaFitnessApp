package controller;

import domain.persons.Customer;
import repository.CustomerRepositoryInterface;
import repository.inMemoryRepository.CustomerRepository;

import java.util.ArrayList;


public class CustomerController extends Controller<Customer> implements CustomerControllerInterface, ISubjectNewCustomer
{
    private static CustomerController instance;

    private final CustomerRepositoryInterface customerRepositoryInterface;

    private CustomerController(CustomerRepository customerRepository)
    {
        super(customerRepository);
        customerRepositoryInterface = customerRepository;
    }

    public static CustomerController getInstance()
    {
        if (instance == null) instance = new CustomerController(CustomerRepository.getInstance());
        return instance;
    }

    @Override
    public ArrayList<Customer> searchByPartialUsername(String username)
    {
        return customerRepositoryInterface.searchByPartialUsername(username);
    }

    @Override
    public Boolean usernameInRepo(String username)
    {
        return customerRepositoryInterface.usernameInRepo(username);
    }

    @Override
    public Customer searchByUsername(String username) {
        return customerRepositoryInterface.searchByUsername(username);
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
