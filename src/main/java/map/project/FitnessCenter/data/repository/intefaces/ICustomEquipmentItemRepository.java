package map.project.FitnessCenter.data.repository.intefaces;

import map.project.FitnessCenter.data.model.EquipmentItem;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
/**
 * Custom repository interface for EquipmentItem, providing additional query methods.
 */
public interface ICustomEquipmentItemRepository {
    /**
     * Find equipment items by name.
     *
     * @param name The name to search for.
     * @return Optional list of equipment items matching the name.
     */
    Optional<List<EquipmentItem>> findByName(@Param("name") String name);
}
