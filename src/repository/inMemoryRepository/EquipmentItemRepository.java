package repository.inMemoryRepository;

import domain.gym.EquipmentItem;
import repository.IRepository;

import java.util.ArrayList;

public class EquipmentItemRepository implements IRepository<EquipmentItem> {
    private final ArrayList<EquipmentItem> equipmentItems;
    private static EquipmentItemRepository instance;

    private EquipmentItemRepository()
    {
        equipmentItems = new ArrayList<>();
        EquipmentItem item1 = new EquipmentItem(1, "Plate");
        EquipmentItem item2 = new EquipmentItem(2, "Dumbbell");
        equipmentItems.add(item1);
        equipmentItems.add(item2);
    }

    public static EquipmentItemRepository getInstance()
    {
        if (instance == null) instance = new EquipmentItemRepository();
        return instance;
    }

    @Override
    public void add(EquipmentItem object)
    {
        equipmentItems.add(object);
    }

    @Override
    public void update(EquipmentItem object) {
        equipmentItems.remove(object);
        equipmentItems.add(object);
    }

    @Override
    public void delete(EquipmentItem object) {
        equipmentItems.remove(object);
    }

    @Override
    public ArrayList<EquipmentItem> getAll() {
        return new ArrayList<>(equipmentItems);
    }
}
