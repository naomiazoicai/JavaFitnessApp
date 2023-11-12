package UI;

import UI.SpecialisedUIs.*;

public class MainUI {
    private final BudgetUI budgetUI;
    private final CustomerUI customerUI;
    private final TrainerUI trainerUI;
    private final SubscriptionTypeUI subscriptionTypeUI;
    private final CustomerSubscriptionUI customerSubscriptionUI;
    private final SpecialisedRoomUI specialisedRoomUI;
    private final EquipmentItemUI equipmentItemUI;
    private final ExerciseUI exerciseUI;

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
    }
}
