package repository.inMemoryRepository;

import domain.persons.Customer;
import domain.persons.Gender;
import domain.persons.Person;
import repository.Repository;
import repository.interfaces.ICustomerRepository;

import java.time.LocalDate;
import java.util.ArrayList;

public class CustomerRepository extends Repository<Customer> implements ICustomerRepository
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
    public Boolean keyNameInRepo(String keyName)
    {
        for (Person person : arrayList)
        {
            if (keyName.equals(person.getUsername())) return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public ArrayList<Customer> searchByPartialKeyName(String keyName)
    {
        ArrayList<Customer> result = new ArrayList<>();
        for (Customer customer : arrayList)
        {
            if (customer.getUsername().contains(keyName)) result.add(customer.copy());
        }
        return result;
    }

    @Override
    public Customer searchByKeyName(String keyName) {
        for (Customer customer : arrayList)
        {
            if (keyName.equals(customer.getUsername())) return customer.copy();
        }
        return null;
    }
}
