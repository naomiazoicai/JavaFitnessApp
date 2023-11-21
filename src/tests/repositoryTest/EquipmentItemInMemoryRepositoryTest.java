package tests.repositoryTest;

import domain.gym.EquipmentItem;
import org.junit.jupiter.api.Test;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;
import repository.inMemoryRepository.EquipmentItemInMemoryRepository;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class EquipmentItemInMemoryRepositoryTest {
    private final EquipmentItemInMemoryRepository equipmentItemRepository = EquipmentItemInMemoryRepository.getInstance();

    @Test
    public void testAdd() throws ObjectAlreadyContained {
        // Successful add
        EquipmentItem equipmentItem = new EquipmentItem(3, "Kettlebell");
        equipmentItemRepository.addEntity(equipmentItem);
        ArrayList<EquipmentItem> equipmentItems = equipmentItemRepository.getAllEntities();
        assertTrue(equipmentItems.contains(equipmentItem));
        // Already in repo
        assertThrows(ObjectAlreadyContained.class, () -> equipmentItemRepository.addEntity(equipmentItem));
        // End
        System.out.println("Test add in EquipmentItemRepo passed, bravo!");
    }

    @Test
    public void testUpdate() throws ObjectAlreadyContained, ObjectNotContained {
        EquipmentItem equipmentItem = new EquipmentItem(4, "Barbell");
        equipmentItemRepository.addEntity(equipmentItem);

        equipmentItemRepository.updateEntity(equipmentItem);

        ArrayList<EquipmentItem> equipmentItems = equipmentItemRepository.getAllEntities();
        assertTrue(equipmentItems.contains(equipmentItem));
        System.out.println("Test update in EquipmentItemRepo passed, bravo!");
    }

    @Test
    public void testDelete() throws ObjectAlreadyContained, ObjectNotContained {
        EquipmentItem equipmentItem = new EquipmentItem(5, "Bench");
        equipmentItemRepository.addEntity(equipmentItem);

        equipmentItemRepository.deleteEntity(equipmentItem);

        ArrayList<EquipmentItem> equipmentItems = equipmentItemRepository.getAllEntities();
        assertFalse(equipmentItems.contains(equipmentItem));
        System.out.println("Test delete in EquipmentItemRepo passed, bravo!");
    }

    @Test
    public void testGetAll() {
        ArrayList<EquipmentItem> equipmentItems = equipmentItemRepository.getAllEntities();
        assertNotNull(equipmentItems);
        System.out.println("Test getAll in EquipmentItemRepo passed, bravo!");
    }
}
