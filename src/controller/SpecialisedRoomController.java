package controller;

import domain.gym.SpecialisedRoom;
import domain.persons.Customer;
import repository.inMemoryRepository.CustomerRepository;
import repository.inMemoryRepository.SpecialisedRoomRepository;

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
    public void add(SpecialisedRoom object)
    {
        repository.add(object);
    }

    @Override
    public void update(SpecialisedRoom object)
    {
        repository.update(object);
    }

    @Override
    public void delete(SpecialisedRoom object)
    {
        repository.delete(object);
    }
}
