package controller;

import domain.gym.SpecialisedRoom;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;
import repository.inMemoryRepository.SpecialisedRoomRepository;
import repository.interfaces.ISpecialisedRoomRepository;


public class SpecialisedRoomController extends Controller<SpecialisedRoom> implements ISpecialisedRoomController
{
    private static SpecialisedRoomController instance;

    private final ISpecialisedRoomRepository specialisedRoomRepository;

    private SpecialisedRoomController(SpecialisedRoomRepository specialisedRoomRepository)
    {
        super(specialisedRoomRepository);
        this.specialisedRoomRepository = specialisedRoomRepository;
    }

    public static SpecialisedRoomController getInstance()
    {
        if (instance == null) instance = new SpecialisedRoomController(SpecialisedRoomRepository.getInstance());
        return instance;
    }

    @Override
    public boolean idInRepo(int id) {
        return specialisedRoomRepository.idInRepo(id);
    }

    @Override
    public SpecialisedRoom searchById(int id) {
        try {
            return specialisedRoomRepository.searchById(id).copy();
        } catch (ObjectNotContained e) {
            return new SpecialisedRoom();
        }
    }

    @Override
    public void add(SpecialisedRoom object) throws ObjectAlreadyContained {
        object.setId(specialisedRoomRepository.generateNextId());
        super.add(object);
    }
}
