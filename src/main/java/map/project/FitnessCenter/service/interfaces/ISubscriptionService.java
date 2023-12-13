package map.project.FitnessCenter.service.interfaces;

import map.project.FitnessCenter.data.model.Subscription;

public interface ISubscriptionService extends IService<Subscription, Long> {
    void setSubscriptionType(Subscription object);
}
