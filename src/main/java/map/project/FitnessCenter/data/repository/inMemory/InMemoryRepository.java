package map.project.FitnessCenter.data.repository.inMemory;

import map.project.FitnessCenter.data.repository.intefaces.IRepository;
import org.springframework.data.domain.Example;

import java.util.*;

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

        return Optional.of(map.get(id));
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
