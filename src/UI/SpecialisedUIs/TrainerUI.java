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
import java.util.Objects;

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
    public void run()
    {
        terminal.printMessage("Trainer UI is running...");
        String choice = terminal.trainerUiMenu();
        // If choice == 5 -> return to main menu
        while (!Objects.equals(choice, "6"))
        {
            switch (choice)
            {
                case "1": addEntity(); break;
                case "2": updateEntity(); break;
                case "3": deleteEntity(); break;
                case "4": searchByPartialUsername(); break;
                case "5": showAll(); break;
            }
            terminal.pressEnterToContinue();
            choice = terminal.trainerUiMenu();
        }
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
        String username = terminal.readUsername();
        // Check if username exists
        if (trainerController.keyNameInRepo(username)) {
            Trainer existingTrainer = trainerController.searchByKeyName(username);

            // Display existing trainer details
            terminal.printMessage("Existing Trainer Details:\n" + existingTrainer);

            // Prompt user for updated details
            String updatedName = terminal.readName();
            LocalDate updatedBirthDate = terminal.readBirthDate();
            Gender updatedGender = terminal.readGender();
            TrainerSpecialization updatedSpecialization = terminal.readTrainerSpecialisation();

            // Update the trainer details
            existingTrainer.setName(updatedName);
            existingTrainer.setBirthDate(updatedBirthDate);
            existingTrainer.setGender(updatedGender);
            existingTrainer.setSpecialization(updatedSpecialization);

            // Display updated trainer details
            terminal.printMessage("Updated Trainer Details:\n" + existingTrainer);

            // Save the updated trainer to the repository
            try {
                controller.update(existingTrainer);
                terminal.printMessage("Trainer updated successfully!");
            } catch (ObjectNotContained e) {
                terminal.printMessage("Error updating trainer: " + e.getMessage());
            }
        } else {
            terminal.printMessage("Trainer username was not found");
        }
    }


    public void searchByPartialUsername()
    {
        String username = terminal.readUsername();
        ArrayList<Trainer> trainers = trainerController.searchByPartialKeyName(username);
        terminal.printArrayList(trainers);
    }
}
