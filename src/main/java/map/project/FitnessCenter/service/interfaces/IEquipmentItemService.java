package map.project.FitnessCenter.service.interfaces;

import map.project.FitnessCenter.data.model.EquipmentItem;

import java.util.List;
import java.util.Optional;

/**
 * An interface defining operations related to the EquipmentItem objects.
 */
public interface IEquipmentItemService {
    /**
     * * Gets an Equipment Item from the repository identified with given name.
     * @param name The name field of the entity to be searched.
     * @return An optional containing the searched entity or null if it was not found
     */
    Optional<List<EquipmentItem>> getByName(String name);
}
