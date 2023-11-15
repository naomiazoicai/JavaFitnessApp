package UI.SpecialisedUIs;

import UI.UI;
import controller.EquipmentItemController;
import controller.interfaces.IEquipmentItemController;
import domain.gym.EquipmentItem;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;

import java.util.Objects;

public class EquipmentItemUI extends UI<EquipmentItem> {
    private static EquipmentItemUI instance;

    private final IEquipmentItemController equipmentItemControllerInterface;

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
    public void run()
    {
        terminal.printMessage("Equipment item UI is running...");
        String choice = terminal.equipmentItemUiMenu();
        // If choice == X -> return to main menu
        while (!Objects.equals(choice, "x") && !Objects.equals(choice, "X"))
        {
            switch (choice)
            {
                case "1": addEntity(); break;
                case "2": updateEntity(); break;
                case "3": deleteEntity(); break;
                case "4": searchById(); break;
                case "5": showAll(); break;
            }
            terminal.pressEnterToContinue();
            choice = terminal.equipmentItemUiMenu();
        }
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
        int id = terminal.readId();
        // Check if id exists
        if (equipmentItemControllerInterface.idInRepo(id)) {
            EquipmentItem existingEquipmentItem = equipmentItemControllerInterface.searchById(id);

            // Display existing equipment item details
            terminal.printMessage("Existing Equipment Item Details:\n" + existingEquipmentItem);

            // Prompt user for updated details
            String updatedName = terminal.readName();

            // Update the equipment item details
            existingEquipmentItem.setName(updatedName);

            // Display updated equipment item details
            terminal.printMessage("Updated Equipment Item Details:\n" + existingEquipmentItem);

            // Save the updated equipment item to the repository
            try {
                controller.update(existingEquipmentItem);
            } catch (ObjectNotContained e) {
                terminal.printMessage("Error updating equipment item: " + e.getMessage());
            }
        } else {
            terminal.printMessage("Equipment item ID was not found");
        }
    }


    public void searchById()
    {
        int id = terminal.readId();
        EquipmentItem equipmentItem = equipmentItemControllerInterface.searchById(id);
        if (equipmentItem.getID() == 0) terminal.printMessage("Equipment id item was not found");
        else terminal.printMessage(equipmentItem.toString());
    }
}
