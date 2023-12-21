package map.project.FitnessCenter.service.observers;

import map.project.FitnessCenter.data.model.SubscriptionType;

/**
 * A subject interface for receiving notification from subjects about the deletion of SubscriptionType.
 */
public interface IObserverDeletedSubscriptionType {
    /**
     * Signals that a SubscriptionType has been deleted from the system.
     * @param subscriptionType The SubscriptionType object representing the deleted SubscriptionType
     */
    void subscriptionTypeDeleted(SubscriptionType subscriptionType);
}
