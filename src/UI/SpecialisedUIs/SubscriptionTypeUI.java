package UI.SpecialisedUIs;

import UI.UI;
import controller.SubscriptionTypeController;
import controller.interfaces.ISubscriptionTypeController;
import domain.money.SubscriptionType;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;

import java.util.ArrayList;
import java.util.Objects;

public class SubscriptionTypeUI extends UI<SubscriptionType> {
    private static SubscriptionTypeUI instance;

    private final ISubscriptionTypeController subscriptionTypeController;

    private SubscriptionTypeUI(SubscriptionTypeController subscriptionTypeController)
    {
        super(subscriptionTypeController);
        this.subscriptionTypeController = subscriptionTypeController;
    }

    public static SubscriptionTypeUI getInstance()
    {
        if (instance == null) instance = new SubscriptionTypeUI(SubscriptionTypeController.getInstance());
        return instance;
    }

    @Override
    public void addEntity() {
        String name = terminal.readSubscriptionTypeName();
        // Check if name exists
        while (subscriptionTypeController.keyNameInRepo(name))
        {
            terminal.printMessage("Subscription Type name already in repo! Choose another");
            name = terminal.readSubscriptionTypeName();
        }
        // Read other attributes
        String description = terminal.readDescription();
        double price = terminal.readPrice();
        // Create and add new subscription type
        SubscriptionType subscriptionType = new SubscriptionType(name, description, price);
        try {
            controller.add(subscriptionType);
        } catch (ObjectAlreadyContained e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEntity() {
        String name = terminal.readSubscriptionTypeName();
        if (subscriptionTypeController.keyNameInRepo(name))
        {
            SubscriptionType subscriptionType = subscriptionTypeController.searchByKeyName(name);
            try {
                controller.delete(subscriptionType);
                terminal.printMessage("Subscription type deleted: " + subscriptionType);
            } catch (ObjectNotContained e)
            {
                throw new RuntimeException();
            }
        } else terminal.printMessage("Subscription type name was not found");
    }

    @Override
    public void run()
    {
        terminal.printMessage("Subscription type UI is running...");
        String choice = terminal.subscriptionTypeUiMenu();
        // If choice == 5 -> return to main menu
        while (!Objects.equals(choice, "6"))
        {
            switch (choice)
            {
                case "1": addEntity(); break;
                case "2": updateEntity(); break;
                case "3": deleteEntity(); break;
                case "4": searchByPartialName(); break;
                case "5": showAll(); break;
            }
            terminal.pressEnterToContinue();
            choice = terminal.subscriptionTypeUiMenu();
        }
    }

    @Override
    public void updateEntity() {
        //TODO
        terminal.printMessage("NOT IMPLEMENTED YET");
    }

    public void searchByPartialName()
    {
        String name = terminal.readSubscriptionTypeName();
        ArrayList<SubscriptionType> subscriptionTypes = subscriptionTypeController.searchByPartialKeyName(name);
        terminal.printArrayList(subscriptionTypes);
    }
}
