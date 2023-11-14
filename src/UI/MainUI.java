package UI;

import UI.SpecialisedUIs.*;
import factory.UiRunnableFactory;
import proxy.UiProxy;

import java.lang.reflect.Type;
import java.util.Objects;

public class MainUI {
    private final UiProxy budgetUI;
    private final UiProxy customerUI;
    private final UiProxy trainerUI;
    private final UiProxy subscriptionTypeUI;
    private final UiProxy customerSubscriptionUI;
    private final UiProxy specialisedRoomUI;
    private final UiProxy equipmentItemUI;
    private final UiProxy exerciseUI;

    private static MainUI instance;

    private final Terminal terminal = Terminal.getInstance();

    private MainUI()
    {
        budgetUI = new UiProxy(UiTypes.budget);
        customerUI = new UiProxy(UiTypes.customer);
        trainerUI = new UiProxy(UiTypes.trainer);
        subscriptionTypeUI = new UiProxy(UiTypes.subscriptionType);
        customerSubscriptionUI = new UiProxy(UiTypes.customerSubscription);
        specialisedRoomUI = new UiProxy(UiTypes.specialisedRoom);
        equipmentItemUI = new UiProxy(UiTypes.equipmentItem);
        exerciseUI = new UiProxy(UiTypes.exercise);
    }

    public static MainUI getInstance()
    {
        if (instance == null) instance = new MainUI();
        return instance;
    }
    public void runUi()
    {
        System.out.println("Main UI is running...");
        String choice = terminal.mainUiMenu();
        while (!Objects.equals(choice, "x"))
        {
            switch (choice)
            {
                case "1": budgetUI.run(); break;
                case "2": customerSubscriptionUI.run(); break;
                case "3": customerUI.run(); break;
                case "4": equipmentItemUI.run(); break;
                case "5": exerciseUI.run(); break;
                case "6": specialisedRoomUI.run(); break;
                case "7": subscriptionTypeUI.run(); break;
                case "8": trainerUI.run(); break;
            }
            terminal.pressEnterToContinue();
            choice = terminal.mainUiMenu();
        }
        System.out.println("App is closing..");
    }
}
