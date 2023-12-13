package map.project.FitnessCenter.service.interfaces;

import map.project.FitnessCenter.data.exceptions.ObjectAlreadyContained;
import map.project.FitnessCenter.data.exceptions.ObjectNotContained;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IService<Entity, IdType>
{
    Optional<Entity> add(Entity object) throws ObjectAlreadyContained;

    Optional<Entity> update(IdType id, Entity object) throws ObjectNotContained, ObjectAlreadyContained;

    Optional<Entity> delete(IdType id) throws ObjectNotContained;

    Optional<List<Entity>> getAll();

    Optional<Entity> getEntityByKey(IdType id);
}
