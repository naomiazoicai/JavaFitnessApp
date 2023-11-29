package map.project.FitnessCenter.service.interfaces;

import map.project.FitnessCenter.data.exceptions.ObjectAlreadyContained;
import map.project.FitnessCenter.data.exceptions.ObjectNotContained;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IService<Type>
{
    Optional<Type> add(Type object) throws ObjectAlreadyContained;

    Optional<Type> update(Long id, Type object) throws ObjectNotContained, ObjectAlreadyContained;

    Optional<Type> delete(Long id) throws ObjectNotContained;

    Optional<List<Type>> getAll();

    Optional<Type> getEntityById(Long id);
}
