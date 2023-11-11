package UI.SpecialisedUIs;

import UI.UI;
import controller.TrainerController;
import controller.interfaces.ITrainerController;
import domain.persons.Customer;
import domain.persons.Gender;
import domain.persons.Trainer;
import domain.persons.TrainerSpecialization;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;

import java.time.LocalDate;
import java.util.ArrayList;

public class TrainerUI extends UI<Trainer> {
    private static TrainerUI instance;

    private final ITrainerController trainerController;

    private TrainerUI(TrainerController trainerController)
    {
        super(trainerController);
        this.trainerController = trainerController;
    }

    public static TrainerUI getInstance()
    {
        if (instance == null) instance = new TrainerUI(TrainerController.getInstance());
        return instance;
    }

    @Override
    public void addEntity() {
        String username = terminal.readUsername();
        // Check if username exists
        while (trainerController.keyNameInRepo(username)) {
            terminal.printMessage("Username already in repo! Choose another");
            username = terminal.readUsername();
        }
        // Read other attributes
        String name = terminal.readName();
        LocalDate birthDate = terminal.readBirthDate();
        Gender gender = terminal.readGender();
        TrainerSpecialization trainerSpecialization = terminal.readTrainerSpecialisation();
        // Create and add
        Trainer trainer = new Trainer(username, name, birthDate, gender, trainerSpecialization);
        try {
            controller.add(trainer);
        } catch (ObjectAlreadyContained e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEntity() {
        String username = terminal.readUsername();
        // Check if username exists
        if (trainerController.keyNameInRepo(username)) {
            Trainer trainer = trainerController.searchByKeyName(username);
            try {
                controller.delete(trainer);
                terminal.printMessage("Trainer deleted: " + trainer.toString());
            } catch (ObjectNotContained e) {
                throw new RuntimeException();
            }
        } else terminal.printMessage("Trainer username was not found");
    }

    @Override
    public void updateEntity() {
        //TODO
    }

    public void searchByPartialUsername()
    {
        String username = terminal.readUsername();
        ArrayList<Trainer> trainers = trainerController.searchByPartialKeyName(username);
        terminal.printArrayList(trainers);
    }
}
