package tests.domainTest;

import domain.money.CustomerSubscription;
import domain.money.SubscriptionType;
import domain.persons.Customer;
import domain.persons.Gender;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerSubscriptionTest
{
    @Test
    void testCheckValidity()
    {
        Customer customer = new Customer("test", "test", LocalDate.of(2000, 1, 10), Gender.notSpecifying);
        SubscriptionType subscriptionType = new SubscriptionType("Basic", "basic", 10);
        LocalDate validFrom = LocalDate.of(2023, 1, 1);
        LocalDate validTo1 = LocalDate.now().plusDays(1);
        LocalDate validTo2 = LocalDate.now();
        LocalDate validTo3 = LocalDate.now().minusDays(1);
        CustomerSubscription customerSubscription1 = new CustomerSubscription(customer, subscriptionType, validFrom, validTo1);
        CustomerSubscription customerSubscription2 = new CustomerSubscription(customer, subscriptionType, validFrom, validTo2);
        CustomerSubscription customerSubscription3 = new CustomerSubscription(customer, subscriptionType, validFrom, validTo3);
        // Check valid
        assertTrue(customerSubscription1.checkValidity());
        assertTrue(customerSubscription2.checkValidity());
        assertFalse(customerSubscription3.checkValidity());
    }
}
