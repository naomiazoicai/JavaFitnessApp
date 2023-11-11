package UI.SpecialisedUIs;

import UI.UI;
import controller.EquipmentItemController;
import controller.EquipmentItemControllerInterface;
import domain.gym.EquipmentItem;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;

public class EquipmentItemUI extends UI<EquipmentItem> {
    private static EquipmentItemUI instance;

    private final EquipmentItemControllerInterface equipmentItemControllerInterface;

    public EquipmentItemUI(EquipmentItemController equipmentItemController) {
        super(equipmentItemController);
        this.equipmentItemControllerInterface = equipmentItemController;
    }

    public static EquipmentItemUI getInstance()
    {
        if (instance == null) instance = new EquipmentItemUI(EquipmentItemController.getInstance());
        return instance;
    }

    @Override
    public void addEntity() {
        String name = terminal.readName();
        // ID is automatically generated in controller
        EquipmentItem equipmentItem = new EquipmentItem(name);
        try {
            controller.add(equipmentItem);
        } catch (ObjectAlreadyContained e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEntity() {
        int id = terminal.readId();
        // Check if id exists
        if (equipmentItemControllerInterface.idInRepo(id))
        {
            EquipmentItem equipmentItem = equipmentItemControllerInterface.searchById(id);
            try {
                controller.delete(equipmentItem);
                terminal.printMessage("EquipmentItem deleted: " + equipmentItem);
            } catch (ObjectNotContained e) {
                terminal.printMessage(e.getMessage());
            }
        } else terminal.printMessage("Equipment id item was not found");
    }

    @Override
    public void updateEntity() {

    }

    public void searchById()
    {
        int id = terminal.readId();
        EquipmentItem equipmentItem = equipmentItemControllerInterface.searchById(id);
        if (equipmentItem.getID() == 0) terminal.printMessage("Equipment id item was not found");
        else terminal.printMessage(equipmentItem.toString());
    }
}
