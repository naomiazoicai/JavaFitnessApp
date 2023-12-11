package map.project.FitnessCenter.data.repository.Jpa;

import map.project.FitnessCenter.data.model.SubscriptionType;
import map.project.FitnessCenter.data.repository.intefaces.ISubscriptionTypeRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionTypeRepository extends JpaRepository<SubscriptionType, String>,
        ISubscriptionTypeRepository {
}
