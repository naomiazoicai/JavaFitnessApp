package map.project.FitnessCenter.data.repository.intefaces;

import map.project.FitnessCenter.data.model.Subscription;

/**
 * Repository interface for the Subscription entity.
 */
public interface ISubscriptionRepository extends IRepository<Subscription, Long>,
        ICustomSubscriptionRepository {
}
