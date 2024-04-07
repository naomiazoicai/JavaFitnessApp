package map.project.FitnessCenter.data.repository.intefaces;

import map.project.FitnessCenter.data.model.Customer;
import map.project.FitnessCenter.data.model.SubscriptionType;

/**
 * Custom repository interface for Subscription, providing additional update methods.
 */
public interface ICustomSubscriptionRepository {
    /**
     * Update method to handle the deletion of a customer.
     *
     * @param customer The customer to be updated.
     */
    void updateCustomerDeleted(Customer customer);

    /**
     * Update method to handle the deletion of a subscription type.
     *
     * @param subscriptionType The subscription type to be updated.
     */
    void updateSubscriptionTypeDeleted(SubscriptionType subscriptionType);
}
