package dao.interaces;

import domain.gym.Room;
import domain.money.SubscriptionType;

import java.util.ArrayList;

public interface ISubscriptionTypeDao {
    Boolean keyNameInRepo(String keyName);

    ArrayList<SubscriptionType> searchByPartialKeyName(String keyName);

    SubscriptionType searchByKeyName(String keyName);

    void addRoomToSubscription(SubscriptionType subscriptionType, Room room);

    void removeRoomFromSubscription(SubscriptionType subscriptionType, Room room);

    void roomDeleted(Room room);
}
