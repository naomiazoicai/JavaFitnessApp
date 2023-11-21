package controller;

import controller.interfaces.observers.IObserverDeletedRoom;
import controller.interfaces.ISpecialisedRoomController;
import controller.interfaces.subjects.ISubjectDeletedRoom;
import domain.gym.Room;
import domain.gym.SpecialisedRoom;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;
import repository.inMemoryRepository.SpecialisedRoomInMemoryRepository;
import repository.interfaces.ISpecialisedRoomRepository;


public class SpecialisedRoomController extends Controller<SpecialisedRoom> implements ISpecialisedRoomController, ISubjectDeletedRoom
{
    private static SpecialisedRoomController instance;

    private final ISpecialisedRoomRepository specialisedRoomRepository;

    private SpecialisedRoomController(SpecialisedRoomInMemoryRepository specialisedRoomRepository)
    {
        super(specialisedRoomRepository);
        this.specialisedRoomRepository = specialisedRoomRepository;
        addObserver(SubscriptionTypeController.getInstance());
    }

    public static SpecialisedRoomController getInstance()
    {
        if (instance == null) instance = new SpecialisedRoomController(SpecialisedRoomInMemoryRepository.getInstance());
        return instance;
    }

    @Override
    public boolean idInRepo(int id) {
        return specialisedRoomRepository.idInRepo(id);
    }

    @Override
    public SpecialisedRoom searchById(int id)
    {
        try {
            return specialisedRoomRepository.searchById(id).copy();
        } catch (ObjectNotContained e) {
            return new SpecialisedRoom();
        }
    }

    @Override
    public void add(SpecialisedRoom object) throws ObjectAlreadyContained
    {
        object.setId(specialisedRoomRepository.generateNextId());
        super.add(object);
    }

    @Override
    public void delete(SpecialisedRoom object) throws ObjectNotContained
    {
        notifyRoomDeleted(object);
        super.delete(object);
    }

    @Override
    public void addObserver(IObserverDeletedRoom observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(IObserverDeletedRoom observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyRoomDeleted(Room room)
    {
        for (IObserverDeletedRoom observer : observerList) observer.updateDeletedRoom(room);
    }
}
