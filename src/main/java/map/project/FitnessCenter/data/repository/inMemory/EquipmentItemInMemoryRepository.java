package map.project.FitnessCenter.data.repository.inMemory;

import map.project.FitnessCenter.data.model.EquipmentItem;
import map.project.FitnessCenter.data.model.enums.Condition;
import map.project.FitnessCenter.data.repository.intefaces.IEquipmentItemRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * In-memory repository implementation for EquipmentItem entities.
 */
@Component
public class EquipmentItemInMemoryRepository extends InMemoryRepository<EquipmentItem, Long>
        implements IEquipmentItemRepository {
    private Long lastId = 1L;

    private EquipmentItemInMemoryRepository() {
        EquipmentItem item1 = new EquipmentItem(1L, "Plate", Condition.NEW);
        EquipmentItem item2 = new EquipmentItem(2L, "Dumbbell", Condition.WORN);
        save(item1);
        save(item2);
        lastId = 2L;
    }

    public static EquipmentItemInMemoryRepository createInstance() {
        return new EquipmentItemInMemoryRepository();
    }

    public List<EquipmentItem> getAllEquipmentItems() {
        return new ArrayList<>(map.values());
    }

    @Override
    public synchronized <E extends EquipmentItem> E save(E entity) {
        if (entity.getId() != null && map.containsKey(entity.getId())) map.put(entity.getId(), entity);
        Long id = lastId;
        lastId += 1L;
        entity.setId(id);
        map.put(id, entity);
        return entity;
    }

    @Override
    public Optional<List<EquipmentItem>> findByName(String name) {
        ArrayList<EquipmentItem> result = new ArrayList<>();
        for (EquipmentItem item : map.values()) {
            if (item.getName().contains(name)) result.add(item);
        }
        return Optional.of(result);
    }
}
