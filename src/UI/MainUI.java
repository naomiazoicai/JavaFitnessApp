package UI;

import UI.SpecialisedUIs.*;
import factory.UiRunnableFactory;
import proxy.UiProxy;

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
        //TODO
        budgetUI.run();
    }
}
