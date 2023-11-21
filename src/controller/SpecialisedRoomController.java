package controller;

import controller.interfaces.observers.IObserverDeletedRoom;
import controller.interfaces.ISpecialisedRoomController;
import controller.interfaces.subjects.ISubjectDeletedRoom;
import domain.gym.Room;
import domain.gym.SpecialisedRoom;
import factory.repo.SpecialisedRoomRepoFactory;
import repository.IRepository;
import repository.RepoTypes;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;
import repository.interfaces.ISpecialisedRoomRepository;


public class SpecialisedRoomController extends Controller<SpecialisedRoom> implements ISpecialisedRoomController, ISubjectDeletedRoom
{
    private static SpecialisedRoomController instance;

    private final ISpecialisedRoomRepository iSpecialisedRoomRepository;

    private static RepoTypes repoType;

    private SpecialisedRoomController(IRepository<SpecialisedRoom> iRepository, ISpecialisedRoomRepository iSpecialisedRoomRepository)
    {
        super(iRepository);
        this.iSpecialisedRoomRepository = iSpecialisedRoomRepository;
        addObserver(SubscriptionTypeController.getInstance());
    }

    public static SpecialisedRoomController getInstance()
    {
        if (instance == null)
        {
            if (repoType == null) throw new RuntimeException("Repo Type not provided!");
            IRepository<SpecialisedRoom> iRepository = SpecialisedRoomRepoFactory.buildIRepository(repoType);
            ISpecialisedRoomRepository iSpecialisedRoomRepository = SpecialisedRoomRepoFactory.buildInterface(repoType);
            instance = new SpecialisedRoomController(iRepository, iSpecialisedRoomRepository);
        }
        return instance;
    }

    @Override
    public boolean idInRepo(int id) {
        return iSpecialisedRoomRepository.idInRepo(id);
    }

    @Override
    public SpecialisedRoom searchById(int id)
    {
        try {
            return iSpecialisedRoomRepository.searchById(id).copy();
        } catch (ObjectNotContained e) {
            return new SpecialisedRoom();
        }
    }

    @Override
    public void add(SpecialisedRoom object) throws ObjectAlreadyContained
    {
        object.setId(iSpecialisedRoomRepository.generateNextId());
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

    public static void setRepoType(RepoTypes newRepoType)
    {
        repoType = newRepoType;
    }
}
