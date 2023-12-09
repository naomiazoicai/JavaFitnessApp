package map.project.FitnessCenter.data.repository;

import map.project.FitnessCenter.data.model.EquipmentItem;
import map.project.FitnessCenter.data.repository.intefaces.IEquipmentItemRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EquipmentItemRepository extends JpaRepository<EquipmentItem, Long>, IEquipmentItemRepository {
    @Override
    @Query("SELECT e FROM EquipmentItem e WHERE e.name LIKE %:name%")
    Optional<List<EquipmentItem>> findByName(@Param("name") String name);
}
