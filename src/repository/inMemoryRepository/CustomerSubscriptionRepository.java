package repository.inMemoryRepository;

import domain.money.CustomerSubscription;
import domain.money.SubscriptionType;
import domain.persons.Customer;
import repository.Repository;
import repository.interfaces.ICustomerSubscriptionRepository;

import java.time.LocalDate;
import java.util.ArrayList;

public class CustomerSubscriptionRepository extends Repository<CustomerSubscription> implements ICustomerSubscriptionRepository {
    private static CustomerSubscriptionRepository instance;

    private CustomerSubscriptionRepository()
    {
        // Populate table
        ArrayList<Customer> customers = CustomerRepository.getInstance().getAll();
        ArrayList<SubscriptionType> subscriptionTypes = SubscriptionTypeRepository.getInstance().getAll();
        CustomerSubscription subscription1 = new CustomerSubscription(customers.get(1), subscriptionTypes.get(1), LocalDate.now(), LocalDate.now());
        CustomerSubscription subscription2 = new CustomerSubscription(customers.get(0), subscriptionTypes.get(0),  LocalDate.now(), LocalDate.now());
        arrayList.add(subscription1);
        arrayList.add(subscription2);
    }

    public static CustomerSubscriptionRepository getInstance()
    {
        if (instance == null) instance = new CustomerSubscriptionRepository();
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
}
