package repository.inMemoryRepository;

import domain.gym.EquipmentItem;
import repository.IRepository;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;

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
    public void add(EquipmentItem object) throws ObjectAlreadyContained
    {
        if (equipmentItems.contains(object)) throw new ObjectAlreadyContained();
        equipmentItems.add(object);
    }

    @Override
    public void update(EquipmentItem object) throws ObjectNotContained {
        if (!equipmentItems.contains(object)) throw new ObjectNotContained();
        equipmentItems.remove(object);
        equipmentItems.add(object);
    }

    @Override
    public void delete(EquipmentItem object) throws ObjectNotContained {
        if (!equipmentItems.contains(object)) throw new ObjectNotContained();
        equipmentItems.remove(object);
    }

    @Override
    public ArrayList<EquipmentItem> getAll() {
        return new ArrayList<>(equipmentItems);
    }
}
