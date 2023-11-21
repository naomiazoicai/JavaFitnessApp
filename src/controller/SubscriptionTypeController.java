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
import repository.inMemoryRepository.SpecialisedRoomInMemoryRepository;
import repository.interfaces.ISubscriptionTypeRepository;

import java.util.ArrayList;


public class SubscriptionTypeController extends Controller<SubscriptionType> implements ISubscriptionTypeController, IObserverDeletedRoom, ISubjectDeletedSubscriptionType
{
    private static SubscriptionTypeController instance;

    private final ISubscriptionTypeRepository subscriptionTypeRepository;

    private static RepoTypes repoType;

    private SubscriptionTypeController(IRepository<SubscriptionType> iRepository, ISubscriptionTypeRepository iSubscriptionTypeRepository)
    {
        super(iRepository);
        this.subscriptionTypeRepository = iSubscriptionTypeRepository;
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
    public ArrayList<SubscriptionType> searchByPartialKeyName(String keyName)
    {
        return subscriptionTypeRepository.searchByPartialKeyName(keyName);
    }

    @Override
    public SubscriptionType searchByKeyName(String keyName)
    {
        return subscriptionTypeRepository.searchByKeyName(keyName);
    }

    @Override
    public Boolean keyNameInRepo(String keyName) {
        return subscriptionTypeRepository.keyNameInRepo(keyName);
    }

    @Override
    public Boolean roomIdInRepo(int roomId)
    {
        return SpecialisedRoomInMemoryRepository.getInstance().idInRepo(roomId);
    }

    @Override
    public Room searchRoom(int roomId)
    {
        return SpecialisedRoomInMemoryRepository.getInstance().searchById(roomId);
    }

    @Override
    public void addRoomToSubscription(String subscriptionTypeName, int roomId) throws ObjectNotContained
    {
        Room room = searchRoom(roomId);
        SubscriptionType subscriptionType = searchByKeyName(subscriptionTypeName);
        subscriptionTypeRepository.addRoomToSubscription(subscriptionType, room);
    }

    @Override
    public void removeRoomFromSubscription(String subscriptionTypeName, int roomId) throws ObjectNotContained
    {
        Room room = searchRoom(roomId);
        SubscriptionType subscriptionType = searchByKeyName(subscriptionTypeName);
        subscriptionTypeRepository.removeRoomFromSubscription(subscriptionType, room);
    }

    @Override
    public void updateDeletedRoom(Room room) {
        subscriptionTypeRepository.roomDeleted(room);
    }

    @Override
    public void addObserver(IObserverDeletedSubscriptionType observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(IObserverDeletedSubscriptionType observer) {
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
