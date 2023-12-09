package map.project.FitnessCenter.data.repository.intefaces;

import map.project.FitnessCenter.data.model.EquipmentItem;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IEquipmentItemRepository {
    Optional<List<EquipmentItem>> findByName(@Param("name") String name);
}
