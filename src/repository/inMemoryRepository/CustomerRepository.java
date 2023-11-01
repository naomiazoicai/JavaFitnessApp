package repository.inMemoryRepository;

import domain.persons.Customer;
import domain.persons.Gender;
import repository.IRepository;
import repository.Repository;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class CustomerRepository extends Repository<Customer>
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
}
