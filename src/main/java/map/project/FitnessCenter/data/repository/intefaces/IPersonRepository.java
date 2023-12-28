package map.project.FitnessCenter.data.repository.intefaces;

import map.project.FitnessCenter.data.model.Person;
import org.springframework.data.repository.query.Param;
/**
 * Interface for the Person repository, extending the general repository interface.
 */
public interface IPersonRepository extends IRepository<Person, String>
{
    /**
     * Check if a person with the given username exists.
     *
     * @param username The username to check.
     * @return True if a person with the given username exists; otherwise, false.
     */
    boolean personUsernameExists(@Param("name") String username);
}
