package map.project.FitnessCenter.service.observers;

import map.project.FitnessCenter.data.model.SubscriptionType;

public interface IObserverDeletedSubscriptionType {
    void subscriptionTypeDeleted(SubscriptionType subscriptionType);
}
