package repository.inMemoryRepository;

import domain.money.CustomerSubscription;
import domain.persons.Customer;
import repository.IRepository;
import repository.Repository;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;

import java.time.LocalDate;
import java.util.ArrayList;

public class CustomerSubscriptionRepository extends Repository<CustomerSubscription> {
    private static CustomerSubscriptionRepository instance;

    private CustomerSubscriptionRepository()
    {
        // Populate table
        CustomerRepository customerRepository = CustomerRepository.getInstance();
        ArrayList<Customer> customers = customerRepository.getAll();
        CustomerSubscription subscription1 = new CustomerSubscription("Silver", "Basic plan", 100, customers.get(1), LocalDate.now(), LocalDate.now());
        CustomerSubscription subscription2 = new CustomerSubscription("Premium", "King++", 1000, customers.get(0), LocalDate.now(), LocalDate.now());
        arrayList.add(subscription1);
        arrayList.add(subscription2);
    }

    public static CustomerSubscriptionRepository getInstance()
    {
        if (instance == null) instance = new CustomerSubscriptionRepository();
        return instance;
    }
}
