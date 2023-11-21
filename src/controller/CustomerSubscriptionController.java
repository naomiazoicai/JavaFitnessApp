package controller;

import controller.interfaces.ICustomerSubscriptionController;
import controller.interfaces.observers.IObserverCustomerSubscriptionAdded;
import controller.interfaces.observers.IObserverDeletedSubscriptionType;
import controller.interfaces.subjects.ISubjectCustomerSubscriptionAdded;
import domain.money.CustomerSubscription;
import domain.money.SubscriptionType;
import domain.persons.Customer;
import repository.exceptions.ObjectAlreadyContained;
import repository.inMemoryRepository.CustomerInMemoryRepository;
import repository.inMemoryRepository.CustomerSubscriptionInMemoryRepository;
import repository.inMemoryRepository.SubscriptionTypeInMemoryRepository;
import repository.interfaces.ICustomerSubscriptionRepository;

import java.time.LocalDate;
import java.util.ArrayList;


public class CustomerSubscriptionController extends Controller<CustomerSubscription>
        implements ICustomerSubscriptionController, IObserverDeletedSubscriptionType, ISubjectCustomerSubscriptionAdded
{
    private static CustomerSubscriptionController instance;

    private final ICustomerSubscriptionRepository customerSubscriptionRepository;

    private CustomerSubscriptionController(CustomerSubscriptionInMemoryRepository customerSubscriptionRepository)
    {
        super(customerSubscriptionRepository);
        this.customerSubscriptionRepository = customerSubscriptionRepository;
        addObserver(BudgetController.getInstance());
    }

    public static CustomerSubscriptionController getInstance()
    {
        if (instance == null) instance = new CustomerSubscriptionController(CustomerSubscriptionInMemoryRepository.getInstance());
        return instance;
    }

    @Override
    public void add(CustomerSubscription object) throws ObjectAlreadyContained
    {
        super.add(object);
        notifyAddedCustomerSubscription(object);
    }

    @Override
    public ArrayList<CustomerSubscription> searchSubscriptionsOfUser(String username)
    {
        return customerSubscriptionRepository.searchSubscriptionsOfUser(username);
    }

    @Override
    public ArrayList<CustomerSubscription> searchSubscriptionByType(SubscriptionType subscriptionType)
    {
        return customerSubscriptionRepository.searchSubscriptionByType(subscriptionType);
    }

    @Override
    public boolean customerInRepo(String username)
    {
        CustomerInMemoryRepository customerRepository = CustomerInMemoryRepository.getInstance();
        return customerRepository.keyNameInRepo(username);
    }

    @Override
    public Customer searchCustomerInRepo(String username)
    {
        CustomerInMemoryRepository customerRepository = CustomerInMemoryRepository.getInstance();
        if (customerRepository.keyNameInRepo(username))
        {
            return customerRepository.searchByKeyName(username);
        }
        return new Customer();
    }

    @Override
    public boolean subscriptionTypeInRepo(String name)
    {
        SubscriptionTypeInMemoryRepository subscriptionTypeRepository = SubscriptionTypeInMemoryRepository.getInstance();
        return subscriptionTypeRepository.keyNameInRepo(name);
    }

    @Override
    public SubscriptionType searchSubscriptionType(String name)
    {
        SubscriptionTypeInMemoryRepository subscriptionTypeRepository = SubscriptionTypeInMemoryRepository.getInstance();
        if (subscriptionTypeRepository.keyNameInRepo(name))
        {
            return subscriptionTypeRepository.searchByKeyName(name);
        }
        return new SubscriptionType();
    }

    @Override
    public CustomerSubscription searchCustomerSubscription(Customer customer, SubscriptionType subscriptionType, LocalDate validFrom)
    {
        for (CustomerSubscription subscription : repository.getAllEntities())
        {
            if (subscription.getCustomer().equals(customer)
                    && subscription.getSubscriptionType().equals(subscriptionType)
                    && subscription.getValidFrom().equals(validFrom))
            {
                return subscription;
            }
        }
        return null;
    }

    @Override
    public Boolean hasValidSubscription(Customer customer)
    {
        return customerSubscriptionRepository.hasValidSubscription(customer);
    }

    @Override
    public void updateDeletedSubscriptionType(SubscriptionType subscriptionType)
    {
        customerSubscriptionRepository.subscriptionTypeDeleted(subscriptionType);
    }

    @Override
    public void addObserver(IObserverCustomerSubscriptionAdded observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(IObserverCustomerSubscriptionAdded observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyAddedCustomerSubscription(CustomerSubscription customerSubscription)
    {
        for (IObserverCustomerSubscriptionAdded observer : observerList)
        {
            observer.updatedAddedCustomerSubscription(customerSubscription);
        }
    }
}
