package map.project.FitnessCenter.data.repository;

import map.project.FitnessCenter.data.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, String> {
}
