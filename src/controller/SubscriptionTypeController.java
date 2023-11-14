package controller;

import controller.interfaces.IObserverDeletedRoom;
import controller.interfaces.ISubscriptionTypeController;
import domain.gym.Room;
import domain.money.SubscriptionType;
import repository.exceptions.ObjectNotContained;
import repository.inMemoryRepository.SpecialisedRoomRepository;
import repository.inMemoryRepository.SubscriptionTypeRepository;
import repository.interfaces.ISubscriptionTypeRepository;

import java.util.ArrayList;


public class SubscriptionTypeController extends Controller<SubscriptionType> implements ISubscriptionTypeController, IObserverDeletedRoom
{
    private static SubscriptionTypeController instance;

    private final ISubscriptionTypeRepository subscriptionTypeRepository;

    private SubscriptionTypeController(SubscriptionTypeRepository subscriptionTypeRepository)
    {
        super(subscriptionTypeRepository);
        this.subscriptionTypeRepository = subscriptionTypeRepository;
    }

    public static SubscriptionTypeController getInstance()
    {
        if (instance == null) instance = new SubscriptionTypeController(SubscriptionTypeRepository.getInstance());
        return instance;
    }

    @Override
    public ArrayList<SubscriptionType> searchByPartialKeyName(String keyName) {
        return subscriptionTypeRepository.searchByPartialKeyName(keyName);
    }

    @Override
    public SubscriptionType searchByKeyName(String keyName) {
        return subscriptionTypeRepository.searchByKeyName(keyName);
    }

    @Override
    public Boolean keyNameInRepo(String keyName) {
        return subscriptionTypeRepository.keyNameInRepo(keyName);
    }

    @Override
    public Boolean roomIdInRepo(int roomId)
    {
        return SpecialisedRoomRepository.getInstance().idInRepo(roomId);
    }

    @Override
    public Room searchRoom(int roomId) throws ObjectNotContained {
        return SpecialisedRoomRepository.getInstance().searchById(roomId);
    }

    @Override
    public void addRoomToSubscription(String subscriptionTypeName, int roomId) throws ObjectNotContained {
        Room room = searchRoom(roomId);
        SubscriptionType subscriptionType = searchByKeyName(subscriptionTypeName);
        subscriptionTypeRepository.addRoomToSubscription(subscriptionType, room);
    }

    @Override
    public void removeRoomFromSubscription(String subscriptionTypeName, int roomId) throws ObjectNotContained {
        Room room = searchRoom(roomId);
        SubscriptionType subscriptionType = searchByKeyName(subscriptionTypeName);
        subscriptionTypeRepository.removeRoomFromSubscription(subscriptionType, room);
    }

    @Override
    public void updateDeletedRoom(Room room) {
        subscriptionTypeRepository.roomDeleted(room);
    }
}
