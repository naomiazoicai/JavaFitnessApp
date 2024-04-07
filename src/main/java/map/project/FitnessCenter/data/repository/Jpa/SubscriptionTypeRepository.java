package map.project.FitnessCenter.data.repository.Jpa;

import map.project.FitnessCenter.data.model.SubscriptionType;
import map.project.FitnessCenter.data.repository.intefaces.ISubscriptionTypeRepository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA repository for the SubscriptionType entity.
 */
public interface SubscriptionTypeRepository extends JpaRepository<SubscriptionType, String>,
        ISubscriptionTypeRepository {
}
