package repository.inMemoryRepository;

import domain.money.CustomerSubscription;
import domain.money.SubscriptionType;
import domain.persons.Customer;
import repository.InMemoryRepository;
import repository.interfaces.ICustomerSubscriptionRepository;

import java.time.LocalDate;
import java.util.ArrayList;

public class CustomerSubscriptionInMemoryRepository extends InMemoryRepository<CustomerSubscription> implements ICustomerSubscriptionRepository {
    private static CustomerSubscriptionInMemoryRepository instance;

    private CustomerSubscriptionInMemoryRepository()
    {
        // Populate table
        ArrayList<Customer> customers = CustomerInMemoryRepository.getInstance().getAllEntities();
        ArrayList<SubscriptionType> subscriptionTypes = SubscriptionTypeInMemoryRepository.getInstance().getAllEntities();
        CustomerSubscription subscription1 = new CustomerSubscription(customers.get(1), subscriptionTypes.get(1), LocalDate.now(), LocalDate.now());
        CustomerSubscription subscription2 = new CustomerSubscription(customers.get(0), subscriptionTypes.get(0),  LocalDate.now(), LocalDate.now());
        arrayList.add(subscription1);
        arrayList.add(subscription2);
    }

    public static CustomerSubscriptionInMemoryRepository getInstance()
    {
        if (instance == null) instance = new CustomerSubscriptionInMemoryRepository();
        return instance;
    }

    @Override
    public ArrayList<CustomerSubscription> searchSubscriptionsOfUser(String username) {
        ArrayList<CustomerSubscription> result = new ArrayList<>();
        for (CustomerSubscription customerSubscription : arrayList)
        {
            if (username.equals(customerSubscription.getCustomer().getUsername())){
                result.add(customerSubscription);
            }
        }
        return result;
    }

    @Override
    public ArrayList<CustomerSubscription> searchSubscriptionByType(SubscriptionType subscriptionType) {
        ArrayList<CustomerSubscription> result = new ArrayList<>();
        for (CustomerSubscription customerSubscription : arrayList)
        {
            if (subscriptionType.equals(customerSubscription.getSubscriptionType())) result.add(customerSubscription);
        }
        return result;
    }

    @Override
    public Boolean hasValidSubscription(Customer customer) {
        for (CustomerSubscription customerSubscription : arrayList)
        {
            if (customerSubscription.getCustomer().equals(customer) && customerSubscription.checkValidity()) return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public void subscriptionTypeDeleted(SubscriptionType subscriptionType)
    {
        for (CustomerSubscription customerSubscription : arrayList)
        {
            if (customerSubscription.getSubscriptionType().equals(subscriptionType))
            {
                customerSubscription.setSubscriptionType(SubscriptionType.getNullSubscriptionType());
            }
        }
    }
}
