package repository.databaseRepository;

import dao.CustomerSubscriptionDao;
import dao.interaces.ICustomerSubscriptionDao;
import domain.money.CustomerSubscription;
import domain.money.SubscriptionType;
import domain.persons.Customer;
import repository.DatabaseRepository;
import repository.interfaces.ICustomerSubscriptionRepository;

import java.util.ArrayList;

public class CustomerSubscriptionDatabaseRepository extends DatabaseRepository<CustomerSubscription> implements ICustomerSubscriptionRepository
{
    private static CustomerSubscriptionDatabaseRepository instance;

    private final ICustomerSubscriptionDao customerSubscriptionDao;

    private CustomerSubscriptionDatabaseRepository()
    {
        super(CustomerSubscriptionDao.getInstance());
        customerSubscriptionDao = CustomerSubscriptionDao.getInstance();

    }

    public static CustomerSubscriptionDatabaseRepository getInstance()
    {
        if (instance == null) instance = new CustomerSubscriptionDatabaseRepository();
        return instance;
    }

    @Override
    public ArrayList<CustomerSubscription> searchSubscriptionsOfUser(String username)
    {
        return customerSubscriptionDao.searchSubscriptionsOfUser(username);
    }

    @Override
    public ArrayList<CustomerSubscription> searchSubscriptionByType(SubscriptionType subscriptionType)
    {
        return customerSubscriptionDao.searchSubscriptionByType(subscriptionType);
    }

    @Override
    public Boolean hasValidSubscription(Customer customer)
    {
        return customerSubscriptionDao.hasValidSubscription(customer);
    }

    @Override
    public void subscriptionTypeDeleted(SubscriptionType subscriptionType)
    {
        customerSubscriptionDao.subscriptionTypeDeleted(subscriptionType);
    }
}
