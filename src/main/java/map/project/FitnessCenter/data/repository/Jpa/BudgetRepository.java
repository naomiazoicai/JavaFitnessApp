package map.project.FitnessCenter.data.repository.Jpa;

import map.project.FitnessCenter.data.model.Budget;
import map.project.FitnessCenter.data.repository.intefaces.IBudgetRepository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA repository for the Budget entity.
 */
public interface BudgetRepository extends JpaRepository<Budget, Integer>, IBudgetRepository {
}
