package map.project.FitnessCenter;

import map.project.FitnessCenter.data.model.EquipmentItem;
import map.project.FitnessCenter.data.model.enums.Condition;
import map.project.FitnessCenter.data.repository.inMemory.EquipmentItemInMemoryRepository;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

public class EquipmentItemInMemoryRepositoryTest {

    @Test
    public void testSave()
    {
        EquipmentItemInMemoryRepository repository = EquipmentItemInMemoryRepository.createInstance();

        EquipmentItem newItem = new EquipmentItem(null, "Treadmill", Condition.NEW);
        EquipmentItem savedItem = repository.save(newItem);

        assertNotNull(savedItem.getId());
        assertEquals(newItem.getName(), savedItem.getName());
        assertEquals(newItem.getCondition(), savedItem.getCondition());

        // Check if the saved item is in the list of all items
        List<EquipmentItem> allItems = repository.getAllEquipmentItems();
        assertTrue(allItems.contains(savedItem));
    }

    @Test
    public void testFindByName()
    {
        EquipmentItemInMemoryRepository repository = EquipmentItemInMemoryRepository.createInstance();

        Optional<List<EquipmentItem>> result = repository.findByName("Plate");

        assertTrue(result.isPresent());
        List<EquipmentItem> items = result.get();
        assertEquals(1, items.size());
        assertEquals("Plate", items.get(0).getName());

        // Check if the found item is in the list of all items
        List<EquipmentItem> allItems = repository.getAllEquipmentItems();
        assertTrue(allItems.containsAll(items));
    }
}
