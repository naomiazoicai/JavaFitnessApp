package UI.SpecialisedUIs;

import UI.UI;
import controller.ExerciseController;
import controller.interfaces.ExerciseControllerInterface;
import domain.gym.EquipmentItem;
import domain.gym.Exercise;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;

public class ExerciseUI extends UI<Exercise> {
    private static ExerciseUI instance;

    private final ExerciseControllerInterface exerciseControllerInterface;

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
    }

    public void searchById()
    {
        int id = terminal.readId();
        Exercise exercise = exerciseControllerInterface.searchById(id);
        if (exercise == null) terminal.printMessage("Exercise was not found");
        else terminal.printMessage(exercise.toString());
    }
}
