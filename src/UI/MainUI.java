package UI;

import UI.SpecialisedUIs.*;
import factory.UiRunnableFactory;

public class MainUI {
    private final UiRunnable budgetUI;
    private final UiRunnable customerUI;
    private final UiRunnable trainerUI;
    private final UiRunnable subscriptionTypeUI;
    private final UiRunnable customerSubscriptionUI;
    private final UiRunnable specialisedRoomUI;
    private final UiRunnable equipmentItemUI;
    private final UiRunnable exerciseUI;

    private static MainUI instance;

    private MainUI()
    {
        budgetUI = UiRunnableFactory.buildUi(UiTypes.budget);
        customerUI = UiRunnableFactory.buildUi(UiTypes.customer);
        trainerUI = UiRunnableFactory.buildUi(UiTypes.trainer);
        subscriptionTypeUI = UiRunnableFactory.buildUi(UiTypes.subscriptionType);
        customerSubscriptionUI = UiRunnableFactory.buildUi(UiTypes.customerSubscription);
        specialisedRoomUI = UiRunnableFactory.buildUi(UiTypes.specialisedRoom);
        equipmentItemUI = UiRunnableFactory.buildUi(UiTypes.equipmentItem);
        exerciseUI = UiRunnableFactory.buildUi(UiTypes.exercise);
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
