package repository.interfaces;

import domain.gym.Room;
import domain.money.SubscriptionType;

import java.util.ArrayList;

public interface ISubscriptionTypeRepository {
    void addRoomToSubscription(SubscriptionType subscriptionType, Room room);

    void removeRoomFromSubscription(SubscriptionType subscriptionType, Room room);

    void roomDeleted(Room room);

    Boolean usernameInRepo(String keyName);

    ArrayList<SubscriptionType> searchByPartialKeyName(String keyName);

    SubscriptionType searchByUsername(String keyName);
}
