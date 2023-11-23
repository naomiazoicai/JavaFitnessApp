package controller.interfaces;

import domain.gym.Room;
import domain.money.SubscriptionType;
import repository.exceptions.ObjectNotContained;

import java.util.ArrayList;

public interface ISubscriptionTypeController {
    void addRoomToSubscription(String subscriptionTypeName, int roomId) throws ObjectNotContained;

    void removeRoomFromSubscription(String subscriptionTypeName, int roomId) throws ObjectNotContained;

    Boolean roomIdInRepo(int roomId);

    Room searchRoom(int roomId);

    ArrayList<SubscriptionType> searchByPartialUsername(String keyName);

    SubscriptionType searchByUsername(String keyName);

    Boolean usernameInRepo(String keyName);
}
