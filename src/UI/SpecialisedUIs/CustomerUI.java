package UI.SpecialisedUIs;

import UI.UI;
import controller.CustomerController;
import controller.interfaces.ICustomerController;
import domain.persons.Customer;
import domain.persons.Gender;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class CustomerUI extends UI<Customer> {
    private static CustomerUI instance;

    private final ICustomerController ICustomerController;

    private CustomerUI(CustomerController customerController) {
        super(customerController);
        ICustomerController = customerController;
    }

    public static CustomerUI getInstance() {
        if (instance == null) instance = new CustomerUI(CustomerController.getInstance());
        return instance;
    }

    @Override
    public void run()
    {
        terminal.printMessage("Customer UI is running...");
        String choice = terminal.customerUiMenu();
        // If choice == 5 -> return to main menu
        while (!Objects.equals(choice, "6"))
        {
            switch (choice)
            {
                case "1": addEntity(); break;
                case "2": updateEntity(); break;
                case "3": deleteEntity(); break;
                case "4": searchByPartialUsername(); break;
                case "5": showAll(); break;
            }
            terminal.pressEnterToContinue();
            choice = terminal.customerUiMenu();
        }
    }

    @Override
    public void addEntity() {
        String username = terminal.readUsername();
        // Check if username exists
        while (ICustomerController.keyNameInRepo(username)) {
            terminal.printMessage("Username already in repo! Choose another");
            username = terminal.readUsername();
        }
        // Read other attributes
        String name = terminal.readName();
        LocalDate birthDate = terminal.readBirthDate();
        Gender gender = terminal.readGender();
        // Create and add new customer
        Customer customer = new Customer(username, name, birthDate, gender);
        try {
            controller.add(customer);
        } catch (ObjectAlreadyContained e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEntity() {
        String username = terminal.readUsername();
        // Check if username exists
        if (ICustomerController.keyNameInRepo(username)) {
            Customer toDeleteCustomer = ICustomerController.searchByKeyName(username);
            try {
                controller.delete(toDeleteCustomer);
                terminal.printMessage("Customer deleted: " + toDeleteCustomer.toString());
            } catch (ObjectNotContained e) {
                throw new RuntimeException();
            }
        } else terminal.printMessage("Customer username was not found");
    }

    @Override
    public void updateEntity() {
        String username = terminal.readUsername();
        // Check if username exists
        if (ICustomerController.keyNameInRepo(username)) {
            Customer existingCustomer = ICustomerController.searchByKeyName(username);

            // Display existing customer details
            terminal.printMessage("Existing Customer Details:\n" + existingCustomer);

            // Prompt user for updated details
            String updatedName = terminal.readName();
            LocalDate updatedBirthDate = terminal.readBirthDate();
            Gender updatedGender = terminal.readGender();

            // Update the customer details
            existingCustomer.setName(updatedName);
            existingCustomer.setBirthDate(updatedBirthDate);
            existingCustomer.setGender(updatedGender);

            // Display updated customer details
            terminal.printMessage("Updated Customer Details:\n" + existingCustomer);

            // Save the updated customer to the repository
            try {
                controller.update(existingCustomer);
            } catch (ObjectNotContained e) {
                terminal.printMessage("Error updating customer: " + e.getMessage());
            }
        } else {
            terminal.printMessage("Customer username was not found");
        }
    }


    private void searchByPartialUsername() {
        String username = terminal.readUsername();
        ArrayList<Customer> customers = ICustomerController.searchByPartialKeyName(username);
        terminal.printArrayList(customers);
    }
}
