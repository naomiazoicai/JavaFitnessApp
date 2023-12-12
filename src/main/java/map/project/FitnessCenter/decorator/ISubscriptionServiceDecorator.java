package map.project.FitnessCenter.decorator;

import map.project.FitnessCenter.data.model.Subscription;
import map.project.FitnessCenter.service.interfaces.ISubscriptionService;

public interface ISubscriptionServiceDecorator extends ISubscriptionService {
    void subscriptionSold(Subscription subscription);
}
