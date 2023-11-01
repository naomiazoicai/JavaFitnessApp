package tests.repositoryTest;

import domain.gym.EquipmentItem;
import org.junit.jupiter.api.Test;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;
import repository.inMemoryRepository.EquipmentItemRepository;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class EquipmentItemRepositoryTest {
    private final EquipmentItemRepository equipmentItemRepository = EquipmentItemRepository.getInstance();

    @Test
    public void testAdd() throws ObjectAlreadyContained {
        // Successful add
        EquipmentItem equipmentItem = new EquipmentItem(3, "Kettlebell");
        equipmentItemRepository.add(equipmentItem);
        ArrayList<EquipmentItem> equipmentItems = equipmentItemRepository.getAll();
        assertTrue(equipmentItems.contains(equipmentItem));
        // Already in repo
        assertThrows(ObjectAlreadyContained.class, () -> equipmentItemRepository.add(equipmentItem));
        // End
        System.out.println("Test add in EquipmentItemRepo passed, bravo!");
    }

    @Test
    public void testUpdate() throws ObjectAlreadyContained, ObjectNotContained {
        EquipmentItem equipmentItem = new EquipmentItem(4, "Barbell");
        equipmentItemRepository.add(equipmentItem);

        equipmentItemRepository.update(equipmentItem);

        ArrayList<EquipmentItem> equipmentItems = equipmentItemRepository.getAll();
        assertTrue(equipmentItems.contains(equipmentItem));
        System.out.println("Test update in EquipmentItemRepo passed, bravo!");
    }

    @Test
    public void testDelete() throws ObjectAlreadyContained, ObjectNotContained {
        EquipmentItem equipmentItem = new EquipmentItem(5, "Bench");
        equipmentItemRepository.add(equipmentItem);

        equipmentItemRepository.delete(equipmentItem);

        ArrayList<EquipmentItem> equipmentItems = equipmentItemRepository.getAll();
        assertFalse(equipmentItems.contains(equipmentItem));
        System.out.println("Test delete in EquipmentItemRepo passed, bravo!");
    }

    @Test
    public void testGetAll() {
        ArrayList<EquipmentItem> equipmentItems = equipmentItemRepository.getAll();
        assertNotNull(equipmentItems);
        System.out.println("Test getAll in EquipmentItemRepo passed, bravo!");
    }
}
