package map.project.FitnessCenter.data.repository.Jpa;

import map.project.FitnessCenter.data.model.Trainer;
import map.project.FitnessCenter.data.repository.intefaces.ITrainerRepository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA repository for the Trainer entity.
 */
public interface TrainerRepository extends JpaRepository<Trainer, String>, ITrainerRepository {
}
