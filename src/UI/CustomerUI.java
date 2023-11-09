package UI;

import controller.Controller;
import controller.CustomerController;
import controller.CustomerControllerInterface;
import domain.persons.Customer;
import domain.persons.Gender;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class CustomerUI extends UI<Customer> {
    private static CustomerUI instance;

    private final CustomerControllerInterface customerControllerInterface;

    private CustomerUI(CustomerController customerController) {
        super(customerController);
        customerControllerInterface = customerController;
    }

    public static CustomerUI getInstance() {
        if (instance == null) instance = new CustomerUI(CustomerController.getInstance());
        return instance;
    }

    @Override
    public void addEntity() {
        String username = terminal.readUsername();
        // Check if username exists
        while (customerControllerInterface.usernameInRepo(username)) {
            terminal.printMessage("Username already in repo! Choose another");
            username = terminal.readUsername();
        }
        // Read other attributes
        String name = terminal.readUsername();
        LocalDate birthDate = terminal.readBirthDate();
        Gender gender = terminal.readGender();
        // Create and add new customer
        Customer customer = new Customer(username, name, birthDate, gender);

    }

    @Override
    public void deleteEntity() {
        String username = terminal.readUsername();
        // Check if username exists
        if (customerControllerInterface.usernameInRepo(username)) {
            Customer toDeleteCustomer = customerControllerInterface.searchByUsername(username);
            try {

                controller.delete(toDeleteCustomer);
                terminal.printMessage("Customer deleted: " + toDeleteCustomer.toString());
            } catch (ObjectNotContained e) {
                terminal.printMessage(e.getMessage());
            }
        } else terminal.printMessage("Customer was not found in repository");
    }

    @Override
    public void updateEntity() {
        //TODO
        terminal.printMessage("NOT IMPLEMENTED YET");
    }

    public void searchByPartialUsername() {
        String username = terminal.readUsername();
        ArrayList<Customer> customers = customerControllerInterface.searchByPartialUsername(username);
        terminal.printArrayList(customers);
    }
}
