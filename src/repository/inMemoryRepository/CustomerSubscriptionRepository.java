package repository.inMemoryRepository;

import domain.money.CustomerSubscription;
import domain.money.SubscriptionType;
import domain.persons.Customer;
import repository.Repository;
import java.time.LocalDate;
import java.util.ArrayList;

public class CustomerSubscriptionRepository extends Repository<CustomerSubscription> {
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
}
