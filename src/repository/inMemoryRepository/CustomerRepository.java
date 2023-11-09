package repository.inMemoryRepository;

import domain.persons.Customer;
import domain.persons.Gender;
import domain.persons.Person;
import domain.persons.Trainer;
import repository.CustomerRepositoryInterface;
import repository.Repository;
import java.time.LocalDate;
import java.util.ArrayList;

public class CustomerRepository extends Repository<Customer> implements CustomerRepositoryInterface
{
    private static CustomerRepository instance;

    private CustomerRepository()
    {
        super();
        Customer customer1 = new Customer("gigiSlay", "gigi", LocalDate.of(2000, 10, 10), Gender.male);
        Customer customer2 = new Customer("swiftie", "taylorSwift", LocalDate.of(1900, 10, 10), Gender.female);
        arrayList.add(customer1);
        arrayList.add(customer2);
    }

    public static CustomerRepository getInstance()
    {
        if (instance == null) instance = new CustomerRepository();
        return instance;
    }

    @Override
    public Boolean usernameInRepo(String username)
    {
        for (Person person : arrayList)
        {
            if (username.equals(person.getUsername())) return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public ArrayList<Customer> searchByPartialUsername(String username)
    {
        ArrayList<Customer> result = new ArrayList<>();
        for (Customer customer : arrayList)
        {
            if (customer.getUsername().contains(username)) result.add(customer);
        }
        return result;
    }

    @Override
    public Customer searchByUsername(String username) {
        for (Customer customer : arrayList)
        {
            if (username.equals(customer.getUsername())) return customer;
        }
        return null;
    }
}
