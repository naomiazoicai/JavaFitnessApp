package map.project.FitnessCenter.service.interfaces;

import map.project.FitnessCenter.data.model.Subscription;

/**
 * An interface defining operations related to the Service objects.
 */
public interface ISubscriptionService extends IService<Subscription, Long> {
    /**
     * Sets the Subscription Type for a Subscription in the repository
     *
     * @param object The Subscription object representing the updated subscription.
     */
    void setSubscriptionType(Subscription object);
}
