package controller;

import domain.gym.SpecialisedRoom;
import repository.inMemoryRepository.SpecialisedRoomRepository;


public class SpecialisedRoomController extends Controller<SpecialisedRoom>
{
    private static SpecialisedRoomController instance;

    private SpecialisedRoomController()
    {
        super(SpecialisedRoomRepository.getInstance());
    }

    public static SpecialisedRoomController getInstance()
    {
        if (instance == null) instance = new SpecialisedRoomController();
        return instance;
    }
}
