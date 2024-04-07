package map.project.FitnessCenter.data.repository.intefaces;

import map.project.FitnessCenter.data.model.EquipmentItem;
import map.project.FitnessCenter.data.model.Exercise;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Interface for the Exercise repository, extending the general repository interface.
 */
public interface IExerciseRepository extends IRepository<Exercise, Long> {
    /**
     * Find exercises by name.
     *
     * @param name The name to search for.
     * @return Optional list of exercises with the specified name.
     */
    Optional<List<Exercise>> findByName(@Param("name") String name);

    /**
     * Update method to handle the deletion of an equipment item.
     *
     * @param equipmentItem The equipment item to be updated.
     */
    void updateEquipmentItemDeleted(@Param("equipmentItem") EquipmentItem equipmentItem);

}
