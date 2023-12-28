package map.project.FitnessCenter.data.repository.Jpa;

import map.project.FitnessCenter.data.model.Person;
import map.project.FitnessCenter.data.repository.intefaces.IPersonRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
/**
 * JPA repository for the Person entity.
 */
public interface PersonRepository extends JpaRepository<Person, String>, IPersonRepository {
    @Override
    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM Person p WHERE p.name = :username")
    boolean personUsernameExists(String username);
}
