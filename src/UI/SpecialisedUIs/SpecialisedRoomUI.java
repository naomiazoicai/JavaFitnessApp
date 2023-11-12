package UI.SpecialisedUIs;

import UI.UI;
import controller.interfaces.ISpecialisedRoomController;
import controller.SpecialisedRoomController;
import domain.gym.RoomType;
import domain.gym.SpecialisedRoom;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;

import java.util.Objects;

public class SpecialisedRoomUI extends UI<SpecialisedRoom> {
    private static SpecialisedRoomUI instance;

    private final ISpecialisedRoomController specialisedRoomController;

    private SpecialisedRoomUI(SpecialisedRoomController specialisedRoomController)
    {
        super(specialisedRoomController);
        this.specialisedRoomController = specialisedRoomController;
    }

    public static SpecialisedRoomUI getInstance()
    {
        if (instance == null) instance = new SpecialisedRoomUI(SpecialisedRoomController.getInstance());
        return instance;
    }

    @Override
    public void run()
    {
        terminal.printMessage("Specialised room is running...");
        String choice = terminal.specialisedRoomUiMenu();
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
            choice = terminal.specialisedRoomUiMenu();
        }
    }

    @Override
    public void addEntity() {
        // ID is automatically generated in controller
        boolean occupied = terminal.occupied();
        RoomType roomType = terminal.readRoomType();
        int personCapacity = terminal.readPersonCapacity();
        // Add specialised room
        SpecialisedRoom specialisedRoom = new SpecialisedRoom(occupied, roomType, personCapacity);
        try {
            controller.add(specialisedRoom);
        } catch (ObjectAlreadyContained e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEntity() {
        int id = terminal.readId();
        // Check if id exists
        if (specialisedRoomController.idInRepo(id))
        {
            SpecialisedRoom specialisedRoom = specialisedRoomController.searchById(id);
            try {
                controller.delete(specialisedRoom);
                terminal.printMessage("Room deleted: " + specialisedRoom);
            } catch (ObjectNotContained e) {
                terminal.printMessage(e.getMessage());
            }
        } else terminal.printMessage("Room id was not found");
    }

    @Override
    public void updateEntity() {
        //TODO
        terminal.printMessage("NOT IMPLEMENTED YET");
    }

    public void searchById()
    {
        int id = terminal.readId();
        SpecialisedRoom specialisedRoom = specialisedRoomController.searchById(id);
        if (specialisedRoom == null) terminal.printMessage("Room was not found");
        else terminal.printMessage(specialisedRoom.toString());
    }
}
