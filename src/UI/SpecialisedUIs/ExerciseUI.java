package UI.SpecialisedUIs;

import UI.UI;
import controller.ExerciseController;
import controller.interfaces.IExerciseController;
import domain.gym.EquipmentItem;
import domain.gym.Exercise;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;

import java.util.Objects;

public class ExerciseUI extends UI<Exercise> {
    private static ExerciseUI instance;

    private final IExerciseController exerciseControllerInterface;

    private ExerciseUI(ExerciseController exerciseController) {
        super(exerciseController);
        exerciseControllerInterface = exerciseController;
    }

    public static ExerciseUI getInstance()
    {
        if (instance == null) instance = new ExerciseUI(ExerciseController.getInstance());
        return instance;
    }

    @Override
    public void run()
    {
        terminal.printMessage("Exercise UI is running...");
        String choice = terminal.exerciseUiMenu();
        // If choice == 5 -> return to main menu
        while (!Objects.equals(choice, "6"))
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
            choice = terminal.exerciseUiMenu();
        }
    }

    @Override
    public void addEntity() {
        // ID is automatically generated in controller
        String name = terminal.readName();
        // Search for equipment item
        EquipmentItem equipmentItem;
        terminal.printMessage("Enter exercise id (or 0 if not required)");
        int eiID = terminal.readId();
        while (eiID != 0 && !exerciseControllerInterface.checkEquipmentItemIdInRepo(eiID))
        {
            terminal.printMessage("Enter an existing exercise id (or 0 if not required)");
            eiID = terminal.readId();
        }
        if (eiID == 0) equipmentItem = new EquipmentItem();
        else equipmentItem = exerciseControllerInterface.searchEquipmentItemById(eiID);
        // Read rest
        String muscleTrained = terminal.muscleTrained();
        int sets = terminal.readSets();
        int reps = terminal.readReps();
        // Add EquipmentItem
        Exercise exercise = new Exercise(name, muscleTrained, equipmentItem, sets, reps);
        try {
            controller.add(exercise);
        } catch (ObjectAlreadyContained e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEntity() {
        int id = terminal.readId();
        // Check if id exists
        if (exerciseControllerInterface.checkEquipmentItemIdInRepo(id))
        {
            Exercise exercise = exerciseControllerInterface.searchById(id);
            try {
                controller.delete(exercise);
                terminal.printMessage("Exercise deleted: " + exercise);
            } catch (ObjectNotContained e) {
                terminal.printMessage(e.getMessage());
            }
        } else terminal.printMessage("Exercise id was not found");
    }

    @Override
    public void updateEntity() {
        //TODO
        terminal.printMessage("NOT IMPLEMENTED YET");
    }

    public void searchById()
    {
        int id = terminal.readId();
        Exercise exercise = exerciseControllerInterface.searchById(id);
        if (exercise == null) terminal.printMessage("Exercise was not found");
        else terminal.printMessage(exercise.toString());
    }
}
