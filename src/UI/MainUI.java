package UI;

import UI.SpecialisedUIs.*;

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
        budgetUI = BudgetUI.getInstance();
        customerUI = CustomerUI.getInstance();
        trainerUI = TrainerUI.getInstance();
        subscriptionTypeUI = SubscriptionTypeUI.getInstance();
        customerSubscriptionUI = CustomerSubscriptionUI.getInstance();
        specialisedRoomUI = SpecialisedRoomUI.getInstance();
        equipmentItemUI = EquipmentItemUI.getInstance();
        exerciseUI = ExerciseUI.getInstance();
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
