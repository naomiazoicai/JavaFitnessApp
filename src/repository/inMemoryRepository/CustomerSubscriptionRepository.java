package repository.inMemoryRepository;

import domain.money.CustomerSubscription;
import domain.persons.Customer;
import repository.IRepository;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;

import java.time.LocalDate;
import java.util.ArrayList;

public class CustomerSubscriptionRepository implements IRepository<CustomerSubscription> {
    private final ArrayList<CustomerSubscription> customerSubscriptions;
    private static CustomerSubscriptionRepository instance;

    private CustomerSubscriptionRepository()
    {
        customerSubscriptions = new ArrayList<>();
        // Populate table
        CustomerRepository customerRepository = CustomerRepository.getInstance();
        ArrayList<Customer> customers = customerRepository.getAll();
        CustomerSubscription subscription1 = new CustomerSubscription("Silver", "Basic plan", 100, customers.get(1), LocalDate.now(), LocalDate.now());
        CustomerSubscription subscription2 = new CustomerSubscription("Premium", "King++", 1000, customers.get(0), LocalDate.now(), LocalDate.now());
        customerSubscriptions.add(subscription1);
        customerSubscriptions.add(subscription2);
    }

    public static CustomerSubscriptionRepository getInstance()
    {
        if (instance == null) instance = new CustomerSubscriptionRepository();
        return instance;
    }

    @Override
    public void add(CustomerSubscription object) throws ObjectAlreadyContained {
        if (customerSubscriptions.contains(object)) throw new ObjectAlreadyContained();
        customerSubscriptions.add(object);
    }

    @Override
    public void update(CustomerSubscription object)  throws ObjectNotContained {
        if (!customerSubscriptions.contains(object)) throw new ObjectNotContained();
        customerSubscriptions.remove(object);
        customerSubscriptions.add(object);
    }

    @Override
    public void delete(CustomerSubscription object) throws ObjectNotContained {
        if (!customerSubscriptions.contains(object)) throw new ObjectNotContained();
        customerSubscriptions.remove(object);
    }

    @Override
    public ArrayList<CustomerSubscription> getAll() {
        return new ArrayList<>(customerSubscriptions);
    }
}
