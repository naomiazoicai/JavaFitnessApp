package map.project.FitnessCenter.data.repository;

import jakarta.transaction.Transactional;
import map.project.FitnessCenter.data.model.EquipmentItem;
import map.project.FitnessCenter.data.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    @Query("SELECT e FROM Exercise e WHERE e.name LIKE %:name%")
    Optional<List<Exercise>> findByName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query("UPDATE Exercise e SET e.equipmentUsed = NULL WHERE e.equipmentUsed = :equipmentItem")
    void updateEquipmentItemDeleted(@Param("equipmentItem") EquipmentItem equipmentItem);

}