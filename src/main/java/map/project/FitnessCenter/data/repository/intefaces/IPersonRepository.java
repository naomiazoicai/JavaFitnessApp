package map.project.FitnessCenter.data.repository.intefaces;

import map.project.FitnessCenter.data.model.Person;
import org.springframework.data.repository.query.Param;

public interface IPersonRepository extends IRepository<Person, String>
{
    boolean personUsernameExists(@Param("name") String username);
}
