package map.project.FitnessCenter.data.repository;

import map.project.FitnessCenter.data.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, String> {
}
