package map.project.FitnessCenter.service;

import map.project.FitnessCenter.data.exceptions.ObjectAlreadyContained;
import map.project.FitnessCenter.data.repository.intefaces.IRepository;
import map.project.FitnessCenter.service.interfaces.IService;
import org.springframework.data.domain.Example;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Generic service class for managing the given generic entity of the fitness center.
 */
@Service
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public abstract class BaseService<Entity, IdType> implements IService<Entity, IdType> {
    protected final IRepository<Entity, IdType> repository;

    public BaseService(IRepository<Entity, IdType> repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Entity> add(Entity object) throws ObjectAlreadyContained {
        if (repository.exists(Example.of(object))) throw new ObjectAlreadyContained();
        return Optional.of(repository.save(object));
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
