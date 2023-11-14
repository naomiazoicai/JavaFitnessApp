package controller;

import controller.interfaces.ICustomerSubscriptionController;
import domain.money.CustomerSubscription;
import domain.money.SubscriptionType;
import domain.persons.Customer;
import repository.inMemoryRepository.CustomerRepository;
import repository.inMemoryRepository.CustomerSubscriptionRepository;
import repository.inMemoryRepository.SubscriptionTypeRepository;
import repository.interfaces.ICustomerSubscriptionRepository;

import java.time.LocalDate;
import java.util.ArrayList;


public class CustomerSubscriptionController extends Controller<CustomerSubscription> implements ICustomerSubscriptionController
{
    //TODO Observer for budget to increase budget when subscription is sold
    private static CustomerSubscriptionController instance;

    private final ICustomerSubscriptionRepository customerSubscriptionRepository;

    private CustomerSubscriptionController(CustomerSubscriptionRepository customerSubscriptionRepository)
    {
        super(customerSubscriptionRepository);
        this.customerSubscriptionRepository = customerSubscriptionRepository;
    }

    public static CustomerSubscriptionController getInstance()
    {
        if (instance == null) instance = new CustomerSubscriptionController(CustomerSubscriptionRepository.getInstance());
        return instance;
    }

    @Override
    public ArrayList<CustomerSubscription> searchSubscriptionsOfUser(String username) {
        return customerSubscriptionRepository.searchSubscriptionsOfUser(username);
    }

    @Override
    public ArrayList<CustomerSubscription> searchSubscriptionByType(SubscriptionType subscriptionType) {
        return customerSubscriptionRepository.searchSubscriptionByType(subscriptionType);
    }

    @Override
    public boolean customerInRepo(String username)
    {
        CustomerRepository customerRepository = CustomerRepository.getInstance();
        return customerRepository.keyNameInRepo(username);
    }

    @Override
    public Customer searchCustomerInRepo(String username)
    {
        CustomerRepository customerRepository = CustomerRepository.getInstance();
        if (customerRepository.keyNameInRepo(username))
        {
            return customerRepository.searchByKeyName(username);
        }
        return new Customer();
    }

    @Override
    public boolean subscriptionTypeInRepo(String name) {
        SubscriptionTypeRepository subscriptionTypeRepository = SubscriptionTypeRepository.getInstance();
        return subscriptionTypeRepository.keyNameInRepo(name);
    }

    @Override
    public SubscriptionType searchSubscriptionType(String name) {
        SubscriptionTypeRepository subscriptionTypeRepository = SubscriptionTypeRepository.getInstance();
        if (subscriptionTypeRepository.keyNameInRepo(name))
        {
            return subscriptionTypeRepository.searchByKeyName(name);
        }
        return new SubscriptionType();
    }

    @Override
    public CustomerSubscription searchCustomerSubscription(Customer customer, SubscriptionType subscriptionType, LocalDate validFrom) {
        for (CustomerSubscription subscription : repository.getAll()) {
            if (subscription.getCustomer().equals(customer)
                    && subscription.getSubscriptionType().equals(subscriptionType)
                    && subscription.getValidFrom().equals(validFrom)) {
                return subscription;
            }
        }
        return null;
    }

    @Override
    public Boolean hasValidSubscription(Customer customer) {
        return customerSubscriptionRepository.hasValidSubscription(customer);
    }
}
