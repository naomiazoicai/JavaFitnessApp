package map.project.FitnessCenter.proxy;

import map.project.FitnessCenter.data.repository.intefaces.IRepository;
import org.springframework.data.domain.Example;

import java.util.List;
import java.util.Optional;
/**
 * Abstract base class for repository proxies, implementing the IRepository interface.
 *
 * @param <Entity> the type of the entity
 * @param <Id>     the type of the entity's identifier
 */
public abstract class RepoProxy<Entity, Id> implements IRepository<Entity, Id>
{
    protected IRepository<Entity, Id> currentRepo;

    public abstract void selectInMemory();

    @Override
    public <E extends Entity> E save(E entity) {
        return currentRepo.save(entity);
    }

    @Override
    public void deleteById(Id id) {
        currentRepo.deleteById(id);
    }

    @Override
    public <E extends Entity> boolean exists(Example<E> entity) {
        return currentRepo.exists(entity);
    }

    @Override
    public Optional<Entity> findById(Id id) {
        return currentRepo.findById(id);
    }

    @Override
    public List<Entity> findAll() {
        return currentRepo.findAll();
    }

    @Override
    public boolean existsById(Id id) {
        return currentRepo.existsById(id);
    }
}
