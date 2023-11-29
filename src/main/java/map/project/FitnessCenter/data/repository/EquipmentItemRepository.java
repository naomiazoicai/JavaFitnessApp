package map.project.FitnessCenter.data.repository;

import map.project.FitnessCenter.data.model.EquipmentItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EquipmentItemRepository extends JpaRepository<EquipmentItem, Long>{
    @Query("SELECT e FROM EquipmentItem e WHERE e.name = :name")
    Optional<EquipmentItem> findByName(@Param("name") String name);
}
