package map.project.FitnessCenter.data.repository.intefaces;

import map.project.FitnessCenter.data.model.Customer;
import map.project.FitnessCenter.data.model.SubscriptionType;

public interface ICustomSubscriptionRepository {
    void updateCustomerDeleted(Customer customer);
    void updateSubscriptionTypeDeleted(SubscriptionType subscriptionType);
}
