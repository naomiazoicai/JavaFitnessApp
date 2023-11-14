package controller.interfaces;

import domain.gym.Room;
import domain.money.SubscriptionType;
import repository.exceptions.ObjectNotContained;

public interface ISubscriptionTypeController extends NameIdentifiedEntitiesController<SubscriptionType> {
    void addRoomToSubscription(String subscriptionTypeName, int roomId) throws ObjectNotContained;

    void removeRoomFromSubscription(String subscriptionTypeName, int roomId) throws ObjectNotContained;

    Boolean roomIdInRepo(int roomId);

    Room searchRoom(int roomId) throws ObjectNotContained;
}
