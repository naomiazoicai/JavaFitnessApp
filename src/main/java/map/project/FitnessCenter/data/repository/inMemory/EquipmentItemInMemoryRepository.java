package map.project.FitnessCenter.data.repository.inMemory;

import map.project.FitnessCenter.data.model.EquipmentItem;
import map.project.FitnessCenter.data.model.enums.Condition;

public class EquipmentItemInMemoryRepository extends InMemoryRepository<EquipmentItem, Long> {
    private static EquipmentItemInMemoryRepository instance;
    private Long lastId;

    private EquipmentItemInMemoryRepository()
    {
        EquipmentItem item1 = new EquipmentItem(1L, "Plate", Condition.NEW);
        EquipmentItem item2 = new EquipmentItem(2L, "Dumbbell", Condition.WORN);
        save(item1);
        save(item2);
        lastId = 2L;
    }

    public static EquipmentItemInMemoryRepository getInstance()
    {
        if (instance == null) instance = new EquipmentItemInMemoryRepository();
        return instance;
    }

    @Override
    public EquipmentItem save(EquipmentItem equipmentItem) {
        Long id = lastId;
        lastId++;
        equipmentItem.setId(id);
        return map.put(id, equipmentItem);
    }
}
