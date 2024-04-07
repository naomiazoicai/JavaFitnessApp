package map.project.FitnessCenter.data.repository.Jpa;

import map.project.FitnessCenter.data.model.FreeSubscriptionsLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA repository for the FreeSubscriptionsLog entity.
 */
public interface FreeSubscriptionLogRepo extends JpaRepository<FreeSubscriptionsLog, Long> {
}
