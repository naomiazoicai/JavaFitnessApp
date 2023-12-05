package map.project.FitnessCenter.service.interfaces;

import map.project.FitnessCenter.data.exceptions.ObjectAlreadyContained;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") 
public abstract class BaseService<Entity, IdType> implements IService<Entity, IdType>
{
    private final JpaRepository<Entity, IdType> repository;
    public BaseService(JpaRepository<Entity, IdType> repository)
    {
        this.repository = repository;
    }

    @Override
    public Optional<Entity> add(Entity object) throws ObjectAlreadyContained {
        if (repository.exists(Example.of(object))) throw new ObjectAlreadyContained();
        repository.save(object);
        return Optional.of(object);
    }

    @Override
    public Optional<List<Entity>> getAll() {
        List<Entity> list = repository.findAll();
        if (list.isEmpty()) return Optional.empty();
        return Optional.of(list);
    }

    @Override
    public Optional<Entity> getEntityByKey(IdType id) {
        return repository.findById(id);
    }
}
