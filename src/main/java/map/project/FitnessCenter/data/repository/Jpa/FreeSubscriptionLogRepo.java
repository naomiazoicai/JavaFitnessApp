package map.project.FitnessCenter.data.repository.Jpa;

import map.project.FitnessCenter.data.model.FreeSubscriptionsLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreeSubscriptionLogRepo extends JpaRepository<FreeSubscriptionsLog, Long> {
}
