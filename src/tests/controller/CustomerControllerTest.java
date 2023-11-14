package tests.controller;

import controller.CustomerController;
import domain.money.Budget;
import domain.persons.Customer;
import domain.persons.Gender;
import org.junit.jupiter.api.Test;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomerControllerTest {
    CustomerController customerController = CustomerController.getInstance();
    @Test
    void testAdd()
    {

        Customer newCustomer = new Customer("gigiSlay", "andrei", LocalDate.of(20220, 10, 10), Gender.female);
        // Add customer with existing username
        assertThrows(Exception.class, () -> {
            customerController.add(newCustomer);
        });
        // Add customer with ok username
        Customer anotherNewCustomer = new Customer("gigel", "andrei", LocalDate.of(20220, 10, 10), Gender.female);
        try {
            customerController.add(anotherNewCustomer);
        } catch (ObjectAlreadyContained e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testDelete()
    {
        Customer oldCustomer = new Customer("gigiSlay", "andrei", LocalDate.of(20220, 10, 10), Gender.female);
        Customer notExisingCustomer = new Customer("gigelean", "andrei", LocalDate.of(20220, 10, 10), Gender.female);
        // Add customer with existing username
        assertThrows(Exception.class, () -> {
            customerController.delete(notExisingCustomer);
        });
        // Add customer with ok username
        try {
            customerController.delete(oldCustomer);
        } catch (ObjectNotContained e) {
            throw new RuntimeException(e);
        }
    }
}
