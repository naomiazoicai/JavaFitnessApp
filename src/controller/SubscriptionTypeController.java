package controller;

import controller.interfaces.observers.IObserverDeletedRoom;
import controller.interfaces.observers.IObserverDeletedSubscriptionType;
import controller.interfaces.subjects.ISubjectDeletedSubscriptionType;
import controller.interfaces.ISubscriptionTypeController;
import domain.gym.Room;
import domain.money.SubscriptionType;
import factory.repo.SubscriptionTypeRepoFactory;
import repository.IRepository;
import repository.RepoTypes;
import repository.exceptions.ObjectNotContained;
import repository.interfaces.ISubscriptionTypeRepository;

import java.util.ArrayList;


public class SubscriptionTypeController extends Controller<SubscriptionType> implements ISubscriptionTypeController, IObserverDeletedRoom, ISubjectDeletedSubscriptionType
{
    private static SubscriptionTypeController instance;
    private static RepoTypes repoType; // Must be set before getInstance()
    private final ISubscriptionTypeRepository iSubscriptionTypeRepository;

    private SubscriptionTypeController(IRepository<SubscriptionType> iRepository, ISubscriptionTypeRepository iSubscriptionTypeRepository)
    {
        super(iRepository);
        this.iSubscriptionTypeRepository = iSubscriptionTypeRepository;
        addObserver(CustomerSubscriptionController.getInstance());
    }

    public static SubscriptionTypeController getInstance()
    {
        if (instance == null)
        {
            if (repoType == null) throw new RuntimeException("Repo Type not provided!");
            IRepository<SubscriptionType> iRepository = SubscriptionTypeRepoFactory.buildIRepository(repoType);
            ISubscriptionTypeRepository iSubscriptionTypeRepository = SubscriptionTypeRepoFactory.buildInterface(repoType);
            instance = new SubscriptionTypeController(iRepository, iSubscriptionTypeRepository);
        }
        return instance;
    }

    @Override
    public void delete(SubscriptionType object) throws ObjectNotContained
    {
        notifySubscriptionTypeDeleted(object);
        super.delete(object);
    }

    @Override
    public ArrayList<SubscriptionType> searchByPartialUsername(String username)
    {
        return iSubscriptionTypeRepository.searchByPartialKeyName(username);
    }

    @Override
    public SubscriptionType searchByUsername(String username)
    {
        return iSubscriptionTypeRepository.searchByUsername(username);
    }

    @Override
    public Boolean usernameInRepo(String username)
    {
        return iSubscriptionTypeRepository.usernameInRepo(username);
    }

    @Override
    public Boolean roomIdInRepo(int roomId)
    {
        return SpecialisedRoomController.getInstance().idInRepo(roomId);
    }

    @Override
    public Room searchRoom(int roomId)
    {
        return SpecialisedRoomController.getInstance().searchById(roomId);
    }

    @Override
    public void addRoomToSubscription(String subscriptionTypeName, int roomId)
    {
        Room room = searchRoom(roomId);
        SubscriptionType subscriptionType = searchByUsername(subscriptionTypeName);
        iSubscriptionTypeRepository.addRoomToSubscription(subscriptionType, room);
    }

    @Override
    public void removeRoomFromSubscription(String subscriptionTypeName, int roomId)
    {
        Room room = searchRoom(roomId);
        SubscriptionType subscriptionType = searchByUsername(subscriptionTypeName);
        iSubscriptionTypeRepository.removeRoomFromSubscription(subscriptionType, room);
    }

    @Override
    public void updateDeletedRoom(Room room)
    {
        iSubscriptionTypeRepository.roomDeleted(room);
    }

    @Override
    public void addObserver(IObserverDeletedSubscriptionType observer)
    {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(IObserverDeletedSubscriptionType observer)
    {
        observerList.remove(observer);
    }

    @Override
    public void notifySubscriptionTypeDeleted(SubscriptionType subscriptionType)
    {
        for (IObserverDeletedSubscriptionType observer : observerList) observer.updateDeletedSubscriptionType(subscriptionType);
    }

    public static void setRepoType(RepoTypes newRepoType)
    {
        repoType = newRepoType;
    }
}
