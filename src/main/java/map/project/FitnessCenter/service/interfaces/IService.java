package map.project.FitnessCenter.service.interfaces;

import map.project.FitnessCenter.data.exceptions.ObjectAlreadyContained;
import map.project.FitnessCenter.data.exceptions.ObjectNotContained;

import java.util.List;
import java.util.Optional;

public interface IService<Type>
{
    Optional<Type> add(Type object) throws ObjectAlreadyContained;

    Optional<Type> update(Long id, Type object) throws ObjectNotContained;

    Optional<Type> delete(Long id) throws ObjectNotContained;

    Optional<List<Type>> getAll();

    Optional<Type> getEntityById(Long id);
}
