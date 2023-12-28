package map.project.FitnessCenter.decorator;

import map.project.FitnessCenter.data.exceptions.ObjectAlreadyContained;
import map.project.FitnessCenter.data.exceptions.ObjectNotContained;
import map.project.FitnessCenter.data.model.Subscription;
import map.project.FitnessCenter.service.interfaces.ISubscriptionService;
import map.project.FitnessCenter.service.SubscriptionService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
/**
 * A decorator base class that enhances the functionality of SubscriptionService implementations.
 */
@Component
public abstract class SubscriptionServiceDecorator implements ISubscriptionServiceDecorator {

    protected final ISubscriptionService subscriptionService;

    public SubscriptionServiceDecorator(SubscriptionService subscriptionService)
    {
        this.subscriptionService = subscriptionService;
    }

    @Override
    public Optional<Subscription> add(Subscription object) throws ObjectAlreadyContained {
        Optional<Subscription> subscription = subscriptionService.add(object);
        subscriptionSold(object);
        return subscription;
    }

    @Override
    public Optional<Subscription> update(Long id, Subscription object) throws ObjectNotContained, ObjectAlreadyContained {
        return subscriptionService.update(id, object);
    }

    @Override
    public Optional<Subscription> delete(Long id) throws ObjectNotContained {
        return subscriptionService.delete(id);
    }

    @Override
    public Optional<List<Subscription>> getAll() {
        return subscriptionService.getAll();
    }

    @Override
    public Optional<Subscription> getEntityByKey(Long id) {
        return subscriptionService.getEntityByKey(id);
    }
}
