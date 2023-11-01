package UI;

import controller.CustomerController;
import domain.persons.Customer;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;

import java.util.Objects;
import java.util.Scanner;

public class CustomerUI {
    final CustomerController controller = CustomerController.getInstance();
    private static CustomerUI instance;

    private CustomerUI(){}

    public static CustomerUI getInstance()
    {
        if (instance == null) instance = new CustomerUI();
        return instance;
    }

    public void addCustomer() throws ObjectAlreadyContained {
        Scanner scanner = new Scanner(System.in);
        // Enter new username
        System.out.println("Enter customer's username: ");
        String username = scanner.nextLine();
        if (Objects.equals(username, "")) {
            System.out.println("Customer not found.");
            return;
        }
        // Create customer
        Customer customer = new Customer(username);
        try {
            controller.add(customer);
            System.out.println("Customer added, bravo!.");
        }catch (ObjectAlreadyContained exception){
            System.out.print(exception.toString());
        }
    }
    public void deleteCustomer() throws ObjectNotContained {
        Scanner scanner = new Scanner(System.in);
        // Enter username
        System.out.println("Enter customer's username: ");
        String username = scanner.nextLine();
        if (Objects.equals(username, "")) {
            System.out.println("Customer username not valid.");
            return;
        }
        // Delete customer
        Customer customer = new Customer(username);
        try {
            controller.delete(customer);
            System.out.println("Customer deleted, bravo!.");
        }catch (ObjectNotContained exception){
            System.out.print(exception.toString());
        }
    }


}
