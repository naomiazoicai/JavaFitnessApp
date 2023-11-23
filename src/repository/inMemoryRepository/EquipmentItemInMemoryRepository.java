package repository.inMemoryRepository;

import domain.gym.EquipmentItem;
import repository.interfaces.IEquipmentItemRepository;
import repository.InMemoryRepository;

public class EquipmentItemInMemoryRepository extends InMemoryRepository<EquipmentItem> implements IEquipmentItemRepository {
    private static EquipmentItemInMemoryRepository instance;

    private int lastId;

    private EquipmentItemInMemoryRepository()
    {
        EquipmentItem item1 = new EquipmentItem(1, "Plate");
        EquipmentItem item2 = new EquipmentItem(2, "Dumbbell");
        arrayList.add(item1);
        arrayList.add(item2);
        lastId = 2;
    }

    public static EquipmentItemInMemoryRepository getInstance()
    {
        if (instance == null) instance = new EquipmentItemInMemoryRepository();
        return instance;
    }

    @Override
    public Boolean idInRepo(int id) {
        for (EquipmentItem equipmentItem : arrayList)
        {
            if (id == equipmentItem.getID()) return true;
        }
        return false;
    }

    @Override
    public int generateNextId() {
        lastId += 1;
        return lastId;
    }

    @Override
    public EquipmentItem searchById(int id){
        for (EquipmentItem equipmentItem : arrayList)
        {
            if (id == equipmentItem.getID()) return equipmentItem.copy();
        }
        return EquipmentItem.getNullEquipmentItem();
    }
}
