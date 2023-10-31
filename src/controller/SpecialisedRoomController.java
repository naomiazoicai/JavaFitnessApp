package controller;

import domain.gym.SpecialisedRoom;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;
import repository.inMemoryRepository.SpecialisedRoomRepository;

import java.util.ArrayList;

public class SpecialisedRoomController implements IController<SpecialisedRoom>
{
    private final SpecialisedRoomRepository repository;
    private static SpecialisedRoomController instance;

    private SpecialisedRoomController(SpecialisedRoomRepository repository)
    {
        this.repository = repository;
    }

    public static SpecialisedRoomController getInstance(SpecialisedRoomRepository repository)
    {
        if (instance == null) instance = new SpecialisedRoomController(repository);
        return instance;
    }

    public static SpecialisedRoomController getInstance()
    {
        if (instance == null) throw new Error("Repository was never provided");
        return instance;
    }

    @Override
    public void add(SpecialisedRoom object) throws ObjectAlreadyContained {
        repository.add(object);
    }

    @Override
    public void update(SpecialisedRoom object) throws ObjectNotContained {
        repository.update(object);
    }

    @Override
    public void delete(SpecialisedRoom object)
    {
        repository.delete(object);
    }

    @Override
    public ArrayList<SpecialisedRoom> getAll() {
        return repository.getAll();
    }
}
