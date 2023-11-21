package tests.repositoryTest;

import domain.money.CustomerSubscription;
import domain.money.SubscriptionType;
import domain.persons.Customer;
import domain.persons.Gender;
import org.junit.jupiter.api.Test;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;
import repository.inMemoryRepository.CustomerSubscriptionInMemoryRepository;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerSubscriptionInMemoryRepositoryTest {
    private final CustomerSubscriptionInMemoryRepository customerSubscriptionRepository = CustomerSubscriptionInMemoryRepository.getInstance();
    @Test
    public void testAdd() throws ObjectAlreadyContained {
        // Successful add
        Customer customer = new Customer("testCustomer1", "Test", LocalDate.of(1990, 5, 5), Gender.male);
        SubscriptionType subscriptionType1 = new SubscriptionType("Silver", "Basic plan", 100);
        CustomerSubscription subscription = new CustomerSubscription(customer, subscriptionType1, LocalDate.now(), LocalDate.now());
        customerSubscriptionRepository.addEntity(subscription);
        ArrayList<CustomerSubscription> subscriptions = customerSubscriptionRepository.getAllEntities();
        assertTrue(subscriptions.contains(subscription));
        // Already in repo
        assertThrows(ObjectAlreadyContained.class, () -> customerSubscriptionRepository.addEntity(subscription));
        // End
        System.out.println("Test add in CustomerSubscriptionRepo passed, bravo!");
    }

    @Test
    public void testUpdate() throws ObjectAlreadyContained, ObjectNotContained {
        Customer customer = new Customer("testCustomer2", "Test", LocalDate.of(1990, 5, 5), Gender.male);
        SubscriptionType subscriptionType2 = new SubscriptionType("Silver", "Basic plan", 100);
        CustomerSubscription subscription = new CustomerSubscription(customer, subscriptionType2, LocalDate.now(), LocalDate.now());
        customerSubscriptionRepository.addEntity(subscription);

        customerSubscriptionRepository.updateEntity(subscription);

        ArrayList<CustomerSubscription> subscriptions = customerSubscriptionRepository.getAllEntities();
        assertTrue(subscriptions.contains(subscription));
        System.out.println("Test update in CustomerSubscriptionRepo passed, bravo!");
    }

    @Test
    public void testDelete() throws ObjectAlreadyContained, ObjectNotContained {
        Customer customer3 = new Customer("testCustomer2", "Test",
                LocalDate.of(1990, 5, 5), Gender.male);
        SubscriptionType subscriptionType3 = new SubscriptionType("Silver", "Basic plan", 100);
        CustomerSubscription subscription = new CustomerSubscription(customer3, subscriptionType3, LocalDate.now(), LocalDate.now());
        customerSubscriptionRepository.addEntity(subscription);

        customerSubscriptionRepository.deleteEntity(subscription);

        ArrayList<CustomerSubscription> subscriptions = customerSubscriptionRepository.getAllEntities();
        assertFalse(subscriptions.contains(subscription));
        System.out.println("Test delete in CustomerSubscriptionRepo passed, bravo!");
    }

    @Test
    public void testGetAll() {
        ArrayList<CustomerSubscription> subscriptions = customerSubscriptionRepository.getAllEntities();
        assertNotNull(subscriptions);
        System.out.println("Test getAll in CustomerSubscriptionRepo passed, bravo!");
    }
}