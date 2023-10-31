//package UI;
//
//import domain.money.CustomerSubscription;
//import domain.persons.Customer;
//import repository.inMemoryRepository.CustomerRepository;
//import repository.inMemoryRepository.InMemoryRepository;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class SubscriptionUI {
//    private final InMemoryRepository repository;
//    private static SubscriptionUI instance;
//
//    public SubscriptionUI(InMemoryRepository repository) {
//        this.repository = repository;
//    }
//
//    public static SubscriptionUI getInstance(InMemoryRepository repository) {
//        if (instance == null) instance = new SubscriptionUI(repository);
//        return instance;
//
//    }
//
//
//    public void addSubscription() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter customer's username: ");
//        String username = scanner.nextLine();
//        CustomerRepository customerRepository = CustomerRepository.getInstance();
//
//        ArrayList<Customer> customers = customerRepository.getAll();
//        Customer customer = new Customer(username);
//
//
//        if (customer == null) {
//            System.out.println("Customer not found.");
//            return;
//        }
//
//        System.out.println("Enter subscription type: ");
//        String type = scanner.nextLine();
//
//        System.out.println("Enter subscription description: ");
//        String description = scanner.nextLine();
//
//        System.out.println("Enter subscription price: ");
//        double price = scanner.nextDouble();
//        scanner.nextLine();
//
//        CustomerSubscription subscription = new CustomerSubscription(type, description, price, customer, LocalDate.now(), LocalDate.now());
//        CustomerSubscription.add(subscription);
//    }
//
//    public void deleteSubscription() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter customer's username: ");
//        String username = scanner.nextLine();
//
//        Customer customer = repository.getCustomer(username);
//
//        if (customer == null) {
//            System.out.println("Customer not found.");
//            return;
//        }
//
//        System.out.println("Enter subscription type to delete: ");
//        String type = scanner.nextLine();
//
//        ArrayList<CustomerSubscription> subscriptions = repository.getCustomerSubscriptions(customer);
//        CustomerSubscription subscriptionToDelete = null;
//
//        for (CustomerSubscription subscription : subscriptions) {
//            if (subscription.getType().equals(type)) {
//                subscriptionToDelete = subscription;
//                break;
//            }
//        }
//
//        if (subscriptionToDelete == null) {
//            System.out.println("Subscription not found for this customer.");
//            return;
//        }
//
//        repository.deleteCustomerSubscription(subscriptionToDelete);
//    }
//
//    public void runUi() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("1. See all equipment items\n2. See all exercises\n3. See all rooms\n4. See all workouts\n5. See the total budget\n6. See all customers\n7. See all trainers\n8. Add a subscription\n9. Delete a subscription\nPlease enter your choice (1-9):");
//        int input = scanner.nextInt();
//        switch (input) {
//            case 8:
//                addSubscription();
//                runUi();
//                break;
//            case 9:
//                deleteSubscription();
//                runUi();
//                break;
//            default:
//                System.out.println("Invalid option. Please try again.");
//                runUi();
//        }
//        scanner.close();
//    }
//}
