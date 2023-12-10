package map.project.FitnessCenter.data.repository.intefaces;

import org.springframework.data.domain.Example;

import java.util.List;
import java.util.Optional;

public interface IRepository<Entity, Id> {
    <E extends Entity> E save(E entity);

    void deleteById(Id id);
    <E extends Entity> boolean exists(Example<E> entity);

    Optional<Entity> findById(Id id);

    List<Entity> findAll();

    boolean existsById(Id id);
}
