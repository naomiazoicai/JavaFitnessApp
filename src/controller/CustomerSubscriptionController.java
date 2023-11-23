package controller;

import controller.interfaces.ICustomerSubscriptionController;
import controller.interfaces.observers.IObserverCustomerSubscriptionAdded;
import controller.interfaces.observers.IObserverDeletedSubscriptionType;
import controller.interfaces.subjects.ISubjectCustomerSubscriptionAdded;
import domain.money.CustomerSubscription;
import domain.money.SubscriptionType;
import domain.persons.Customer;
import factory.repo.CustomerRepoFactory;
import factory.repo.CustomerSubscriptionRepoFactory;
import factory.repo.SubscriptionTypeRepoFactory;
import repository.IRepository;
import repository.RepoTypes;
import repository.exceptions.ObjectAlreadyContained;
import repository.interfaces.ICustomerRepository;
import repository.interfaces.ICustomerSubscriptionRepository;
import repository.interfaces.ISubscriptionTypeRepository;

import java.time.LocalDate;
import java.util.ArrayList;


public class CustomerSubscriptionController extends Controller<CustomerSubscription>
        implements ICustomerSubscriptionController, IObserverDeletedSubscriptionType, ISubjectCustomerSubscriptionAdded
{
    private static CustomerSubscriptionController instance;
    private static RepoTypes repoType; // Must be set before getInstance()
    private final ICustomerSubscriptionRepository customerSubscriptionRepository;
    private final ICustomerRepository iCustomerRepository;
    private final ISubscriptionTypeRepository iSubscriptionTypeRepository;
    private CustomerSubscriptionController(IRepository<CustomerSubscription> iRepository,
                                           ICustomerSubscriptionRepository iCustomerSubscriptionRepository,
                                           ICustomerRepository iCustomerRepository,
                                           ISubscriptionTypeRepository iSubscriptionTypeRepository)
    {
        super(iRepository);
        this.customerSubscriptionRepository = iCustomerSubscriptionRepository;
        this.iCustomerRepository = iCustomerRepository;
        this.iSubscriptionTypeRepository = iSubscriptionTypeRepository;
        addObserver(BudgetController.getInstance());
    }

    public static CustomerSubscriptionController getInstance()
    {
        if (instance == null)
        {
            if (repoType == null) throw new RuntimeException("Repo Type not provided!");
            IRepository<CustomerSubscription> iRepository = CustomerSubscriptionRepoFactory.buildIRepository(repoType);
            ICustomerSubscriptionRepository iCustomerRepository = CustomerSubscriptionRepoFactory.buildInterface(repoType);
            ICustomerRepository iCustomerRepository1 = CustomerRepoFactory.buildInterface(repoType);
            ISubscriptionTypeRepository iSubscriptionTypeRepository = SubscriptionTypeRepoFactory.buildInterface(repoType);
            instance = new CustomerSubscriptionController(iRepository, iCustomerRepository, iCustomerRepository1, iSubscriptionTypeRepository);
        }
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
    public boolean usernameInRepo(String username)
    {
        return iCustomerRepository.usernameInRepo(username);
    }

    @Override
    public Customer searchCustomerInRepo(String username)
    {
        if (iCustomerRepository.usernameInRepo(username)) return iCustomerRepository.searchByUsername(username);
        return Customer.getNullCustomer();
    }

    @Override
    public boolean subscriptionTypeInRepo(String name)
    {

        return iSubscriptionTypeRepository.usernameInRepo(name);
    }

    @Override
    public SubscriptionType searchSubscriptionType(String name)
    {
        if (iSubscriptionTypeRepository.usernameInRepo(name)) return iSubscriptionTypeRepository.searchByUsername(name);
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

    public static void setRepoType(RepoTypes newRepoType)
    {
        repoType = newRepoType;
    }
}
