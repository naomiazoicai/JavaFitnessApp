package repository.inMemoryRepository;

import domain.persons.Customer;
import domain.persons.Gender;
import domain.persons.Person;
import domain.persons.Trainer;
import repository.InMemoryRepository;
import repository.exceptions.ObjectNotContained;
import repository.interfaces.ICustomerRepository;

import java.time.LocalDate;
import java.util.ArrayList;

public class CustomerInMemoryRepository extends InMemoryRepository<Customer> implements ICustomerRepository
{
    private static CustomerInMemoryRepository instance;

    private CustomerInMemoryRepository()
    {
        super();
        Customer customer1 = new Customer("gigiSlay", "gigi", LocalDate.of(2000, 10, 10), Gender.male);
        Customer customer2 = new Customer("swiftie", "taylorSwift", LocalDate.of(1900, 10, 10), Gender.female);
        arrayList.add(customer1);
        arrayList.add(customer2);
    }

    public static CustomerInMemoryRepository getInstance()
    {
        if (instance == null) instance = new CustomerInMemoryRepository();
        return instance;
    }

    @Override
    public boolean usernameInRepo(String keyName)
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
    public Customer searchByUsername(String keyName) {
        for (Customer customer : arrayList)
        {
            if (keyName.equals(customer.getUsername())) return customer.copy();
        }
        return null;
    }

    @Override
    public Trainer changeAssignedTrainerOfCustomer(Customer customer, Trainer trainer) throws ObjectNotContained {
        for (Customer existingCustomer: arrayList)
        {
            if (existingCustomer.getUsername().equals(customer.getUsername()))
            {
                Trainer previousTrainer = existingCustomer.getAssignedTrainer();
                existingCustomer.setAssignedTrainer(trainer);
                return previousTrainer;
            }
        }
        throw new ObjectNotContained();
    }

    @Override
    public void trainerDeleted(Trainer trainer) {
        for (Customer customer : arrayList)
        {
            if (customer.getAssignedTrainer().equals(trainer)) customer.setAssignedTrainer(new Trainer());
        }
    }
}
