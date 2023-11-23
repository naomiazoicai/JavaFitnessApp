package factory;

import UI.SpecialisedUIs.*;
import UI.UiRun;

public class UiRunFactory {
    public static UiRun buildUi(UiTypes uiType)
    {
        return switch (uiType)
        {
            case budget -> BudgetUI.getInstance();
            case customerSubscription -> CustomerSubscriptionUI.getInstance();
            case customer -> CustomerUI.getInstance();
            case equipmentItem -> EquipmentItemUI.getInstance();
            case  exercise -> ExerciseUI.getInstance();
            case specialisedRoom -> SpecialisedRoomUI.getInstance();
            case subscriptionType -> SubscriptionTypeUI.getInstance();
            case trainer -> TrainerUI.getInstance();
        };
    }
}
