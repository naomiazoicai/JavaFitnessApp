package map.project.FitnessCenter.data.repository.intefaces;

import org.springframework.data.repository.query.Param;

public interface IPersonRepository
{
    boolean personUsernameExists(@Param("name") String username);
}
