package repository.inMemoryRepository;

import domain.gym.EquipmentItem;
import repository.EquipmentItemRepositoryInterface;
import repository.Repository;
import repository.exceptions.ObjectNotContained;

public class EquipmentItemRepository extends Repository<EquipmentItem> implements EquipmentItemRepositoryInterface {
    private static EquipmentItemRepository instance;

    private int lastId;

    private EquipmentItemRepository()
    {
        EquipmentItem item1 = new EquipmentItem(1, "Plate");
        EquipmentItem item2 = new EquipmentItem(2, "Dumbbell");
        arrayList.add(item1);
        arrayList.add(item2);
        lastId = 2;
    }

    public static EquipmentItemRepository getInstance()
    {
        if (instance == null) instance = new EquipmentItemRepository();
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
    public EquipmentItem searchById(int id) throws ObjectNotContained {
        for (EquipmentItem equipmentItem : arrayList)
        {
            if (id == equipmentItem.getID()) return equipmentItem;
        }
        throw new ObjectNotContained();
    }
}
