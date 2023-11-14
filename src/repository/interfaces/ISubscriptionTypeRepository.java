package repository.interfaces;

import domain.gym.Room;
import domain.money.SubscriptionType;

public interface ISubscriptionTypeRepository extends NameIdentifiedEntitiesRepository<SubscriptionType> {
    void addRoomToSubscription(SubscriptionType subscriptionType, Room room);

    void removeRoomFromSubscription(SubscriptionType subscriptionType, Room room);

    void roomDeleted(Room room);
}
