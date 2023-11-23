package dao.interaces;

import domain.gym.Room;
import domain.money.SubscriptionType;

import java.util.ArrayList;

public interface ISubscriptionTypeDao
{
    Boolean nameInRepo(String keyName);

    ArrayList<SubscriptionType> searchByPartialName(String keyName);

    SubscriptionType searchByName(String keyName);

    void addRoomToSubscription(SubscriptionType subscriptionType, Room room);

    void removeRoomFromSubscription(SubscriptionType subscriptionType, Room room);

    void roomDeleted(Room room);
}
