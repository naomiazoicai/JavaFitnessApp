//package repository.inMemoryRepository.tests;
//
//public class CustomerRepositoryTest {
//}
package tests.repositoryTest;

import domain.persons.Customer;
import domain.persons.Gender;
import org.junit.jupiter.api.Test;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;
import repository.inMemoryRepository.CustomerInMemoryRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerInMemoryRepositoryTest {
    private final CustomerInMemoryRepository customerRepository = CustomerInMemoryRepository.getInstance();

    @Test
    public void testAdd() throws ObjectAlreadyContained {
        // Successful add
        Customer customer = new Customer("testCustomer1", "Test", LocalDate.of(1990, 5, 5), Gender.male);
        customerRepository.addEntity(customer);
        ArrayList<Customer> customers = customerRepository.getAllEntities();
        assertTrue(customers.contains(customer));
        // Already in repo
        assertThrows(ObjectAlreadyContained.class, () -> {
            customerRepository.addEntity(customer);
        });
        // End
        System.out.println("Test add in CustomerRepo passed, bravo!");
    }

    @Test
    public void testUpdate() throws ObjectAlreadyContained, ObjectNotContained {
        Customer customer = new Customer("testCustomer2", "Test", LocalDate.of(1990, 5, 5), Gender.male);
        customerRepository.addEntity(customer);
        customerRepository.updateEntity(customer);

        ArrayList<Customer> customers = customerRepository.getAllEntities();
        assertTrue(customers.contains(customer));
        System.out.println("Test update in CustomerRepo passed, bravo!");
    }

    @Test
    public void testDelete() throws ObjectAlreadyContained, ObjectNotContained {
        Customer customer = new Customer("testCustomer3", "Test", LocalDate.of(1990, 5, 5), Gender.male);
        customerRepository.addEntity(customer);

        customerRepository.deleteEntity(customer);

        ArrayList<Customer> customers = customerRepository.getAllEntities();
        assertFalse(customers.contains(customer));
        System.out.println("Test delete in CustomerRepo passed, bravo!");
    }

    @Test
    public void testGetAll() {
        ArrayList<Customer> customers = customerRepository.getAllEntities();
        assertNotNull(customers);
        System.out.println("Test getAll in CustomerRepo passed, bravo!");
    }
}
