package repository.inMemoryRepository;

import domain.money.CustomerSubscription;
import domain.persons.Customer;
import domain.persons.Gender;
import repository.IRepository;

import java.time.LocalDate;
import java.util.ArrayList;

public class CustomerRepository implements IRepository<Customer>
{
    private final ArrayList<Customer> customers;
    private static CustomerRepository instance;

    private CustomerRepository()
    {
        customers = new ArrayList<>();
        Customer customer1 = new Customer("gigiSlay", "gigi", LocalDate.of(2000, 10, 10), Gender.male);
        Customer customer2 = new Customer("swiftie", "taylorSwift", LocalDate.of(1900, 10, 10), Gender.female);
        customers.add(customer1);
        customers.add(customer2);
    }

    public static CustomerRepository getInstance()
    {
        if (instance == null) instance = new CustomerRepository();
        return instance;
    }

    @Override
    public void add(Customer object)
    {
        customers.add(object);
    }

    @Override
    public void update(Customer object)
    {
        customers.remove(object);
        customers.add(object);
    }

    @Override
    public void delete(Customer object)
    {
        customers.remove(object);
    }

    @Override
    public ArrayList<Customer> getAll() {
        return new ArrayList<>(customers);
    }
}
