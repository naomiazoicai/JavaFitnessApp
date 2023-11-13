package UI.SpecialisedUIs;

import UI.UI;
import controller.CustomerSubscriptionController;
import controller.interfaces.ICustomerSubscriptionController;
import domain.money.CustomerSubscription;
import domain.money.SubscriptionType;
import domain.persons.Customer;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class CustomerSubscriptionUI extends UI<CustomerSubscription> {
    private static CustomerSubscriptionUI instance;

    private final ICustomerSubscriptionController customerSubscriptionController;

    private CustomerSubscriptionUI(CustomerSubscriptionController customerSubscriptionController)
    {
        super(customerSubscriptionController);
        this.customerSubscriptionController = customerSubscriptionController;
    }

    public static CustomerSubscriptionUI getInstance()
    {
        if (instance == null) instance = new CustomerSubscriptionUI(CustomerSubscriptionController.getInstance());
        return instance;
    }

    @Override
    public void run()
    {
        terminal.printMessage("Customer subscription UI is running...");
        String choice = terminal.customerSubscriptionUiMenu();
        // If choice == 7 -> return to main menu
        while (!Objects.equals(choice, "7"))
        {
            switch (choice)
            {
                case "1": addEntity(); break;
                case "2": updateEntity(); break;
                case "3": deleteEntity(); break;
                case "4": searchSubscriptionsOfUser(); break;
                case "5": searchSubscriptionByType(); break;
                case "6": showAll(); break;
            }
            terminal.pressEnterToContinue();
            choice = terminal.customerSubscriptionUiMenu();
        }
    }

    @Override
    public void addEntity() {
        // Customer
        String username = terminal.readUsername();
        while (!customerSubscriptionController.customerInRepo(username)) {
            terminal.printMessage("Username not in repo! Choose a valid customer");
            username = terminal.readUsername();
        }
        Customer customer = customerSubscriptionController.searchCustomerInRepo(username);
        // Subscription Type
        String name = terminal.readSubscriptionTypeName();
        while (!customerSubscriptionController.subscriptionTypeInRepo(name)) {
            terminal.printMessage("Subscription type not in repo! Choose a valid subscription type");
            name = terminal.readSubscriptionTypeName();
        }
        SubscriptionType subscriptionType = customerSubscriptionController.searchSubscriptionType(name);
        // Add subscription
        LocalDate validFrom = terminal.readValidFromDate();
        LocalDate validTo = terminal.readValidToDate(validFrom);
        // Add subscription
        CustomerSubscription customerSubscription = new CustomerSubscription(customer, subscriptionType, validFrom, validTo);
        try {
            controller.add(customerSubscription);
        } catch (ObjectAlreadyContained e) {
            terminal.printMessage("Same subscription already exists!");
        }
    }

    @Override
    public void deleteEntity() {
        // Customer
        String username = terminal.readUsername();
        while (!customerSubscriptionController.customerInRepo(username)) {
            terminal.printMessage("Username not in repo! Choose a valid customer");
            username = terminal.readUsername();
        }
        Customer customer = customerSubscriptionController.searchCustomerInRepo(username);
        // Subscription Type
        String name = terminal.readSubscriptionTypeName();
        while (!customerSubscriptionController.subscriptionTypeInRepo(name)) {
            terminal.printMessage("Subscription type not in repo! Choose a valid subscription type");
            name = terminal.readSubscriptionTypeName();
        }
        SubscriptionType subscriptionType = customerSubscriptionController.searchSubscriptionType(name);
        // Add subscription
        LocalDate validFrom = terminal.readValidFromDate();
        LocalDate validTo = terminal.readValidToDate(validFrom);
        // Add subscription
        CustomerSubscription customerSubscription = new CustomerSubscription(customer, subscriptionType, validFrom, validTo);
        try {
            controller.delete(customerSubscription);
        } catch (ObjectNotContained e) {
            terminal.printMessage("Customer subscription not found!");
        }
    }

    @Override
    public void updateEntity() {
        //TODO
        terminal.printMessage("NOT IMPLEMENTED YET");
    }

    public void searchSubscriptionsOfUser()
    {
        ArrayList<CustomerSubscription> result;
        // Customer
        String username = terminal.readUsername();
        while (!customerSubscriptionController.customerInRepo(username)) {
            terminal.printMessage("Username not in repo! Choose a valid customer");
            username = terminal.readUsername();
        }
        result = customerSubscriptionController.searchSubscriptionsOfUser(username);
        terminal.printArrayList(result);
    }

    public void searchSubscriptionByType()
    {
        ArrayList<CustomerSubscription> result;
        // Subscription Type
        String name = terminal.readSubscriptionTypeName();
        while (!customerSubscriptionController.subscriptionTypeInRepo(name)) {
            terminal.printMessage("Subscription type not in repo! Choose a valid subscription type");
            name = terminal.readSubscriptionTypeName();
        }
        SubscriptionType subscriptionType = customerSubscriptionController.searchSubscriptionType(name);
        result = customerSubscriptionController.searchSubscriptionByType(subscriptionType);
        terminal.printArrayList(result);
    }


}
