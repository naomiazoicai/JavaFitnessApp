package map.project.FitnessCenter.data.repository.inMemory;

import map.project.FitnessCenter.data.repository.intefaces.IRepository;
import org.springframework.data.domain.Example;

import java.util.*;
/**
 * Abstract in-memory repository providing basic CRUD operations.
 *
 * @param <Entity> The type of the entity.
 * @param <Id>     The type of the entity's ID.
 */
public abstract class InMemoryRepository<Entity, Id> implements IRepository<Entity, Id>
{
    protected final HashMap<Id, Entity> map = new HashMap<>();

    @Override
    public void deleteById(Id id) {
        map.remove(id);
    }

    @Override
    public <E extends Entity> boolean exists(Example<E> entity) {
        return map.containsValue(entity.getProbe());
    }

    @Override
    public Optional<Entity> findById(Id id) {
        Entity entity = map.get(id);
        if (entity == null) return Optional.empty();
        return Optional.of(entity);
    }

    @Override
    public List<Entity> findAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public boolean existsById(Id id)
    {
        return map.containsKey(id);
    }
}
