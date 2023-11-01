package repository.inMemoryRepository;

import domain.gym.EquipmentItem;
import repository.IRepository;
import repository.Repository;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;

import java.util.ArrayList;

public class EquipmentItemRepository extends Repository<EquipmentItem> {
    private static EquipmentItemRepository instance;

    private EquipmentItemRepository()
    {
        EquipmentItem item1 = new EquipmentItem(1, "Plate");
        EquipmentItem item2 = new EquipmentItem(2, "Dumbbell");
        arrayList.add(item1);
        arrayList.add(item2);
    }

    public static EquipmentItemRepository getInstance()
    {
        if (instance == null) instance = new EquipmentItemRepository();
        return instance;
    }
}
