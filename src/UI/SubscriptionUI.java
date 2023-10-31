//package UI;
//
//public class SubscriptionUI {
//}
package UI;

import domain.gym.*;
import domain.money.Budget;
import domain.money.CustomerSubscription;
import domain.persons.Customer;
import domain.persons.Trainer;
import repository.inMemoryRepository.CustomerRepository;
import repository.inMemoryRepository.InMemoryRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class UI implements IUi, ISubject {
    private final InMemoryRepository repository;
    private static UI instance;

    private UI(InMemoryRepository repository) {
        this.repository = repository;
    }

    public static UI getInstance(InMemoryRepository repository) {
        if (instance == null) instance = new UI(repository);
        return instance;

    }

    // ... (other methods)

    public void addSubscription() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter customer's username: ");
        String username = scanner.nextLine();
        CustomerRepository customerRepository = CustomerRepository.getInstance();

        ArrayList<Customer> customers = customerRepository.getAll();



        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.println("Enter subscription type: ");
        String type = scanner.nextLine();

        System.out.println("Enter subscription description: ");
        String description = scanner.nextLine();

        System.out.println("Enter subscription price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // clear the buffer

        CustomerSubscription subscription = new CustomerSubscription(type, description, price, customer, LocalDate.now(), LocalDate.now());
        CustomerSubscription.add(subscription);
    }

    public void deleteSubscription() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter customer's username: ");
        String username = scanner.nextLine();

        Customer customer = repository.getCustomerByUsername(username);

        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.println("Enter subscription type to delete: ");
        String type = scanner.nextLine();

        ArrayList<CustomerSubscription> subscriptions = repository.getCustomerSubscriptions(customer);
        CustomerSubscription subscriptionToDelete = null;

        for (CustomerSubscription subscription : subscriptions) {
            if (subscription.getType().equals(type)) {
                subscriptionToDelete = subscription;
                break;
            }
        }

        if (subscriptionToDelete == null) {
            System.out.println("Subscription not found for this customer.");
            return;
        }

        repository.deleteCustomerSubscription(subscriptionToDelete);
    }

    public void runUi() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. See all equipment items\n2. See all exercises\n3. See all rooms\n4. See all workouts\n5. See the total budget\n6. See all customers\n7. See all trainers\n8. Add a subscription\n9. Delete a subscription\nPlease enter your choice (1-9):");
        int input = scanner.nextInt();
        switch (input) {
            // ... (cases for existing functionalities)
            case 8:
                addSubscription();
                runUi();
                break;
            case 9:
                deleteSubscription();
                runUi();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                runUi();
        }
        scanner.close();
    }
}
