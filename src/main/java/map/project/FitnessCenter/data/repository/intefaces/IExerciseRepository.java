package map.project.FitnessCenter.data.repository.intefaces;

import map.project.FitnessCenter.data.model.EquipmentItem;
import map.project.FitnessCenter.data.model.Exercise;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IExerciseRepository {
    Optional<List<Exercise>> findByName(@Param("name") String name);

    void updateEquipmentItemDeleted(@Param("equipmentItem") EquipmentItem equipmentItem);

}
