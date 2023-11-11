package repository.interfaces;

import domain.gym.EquipmentItem;
import domain.gym.Exercise;

public interface ExerciseRepositoryInterface extends IdIdentifiedEntitiesRepository<Exercise>{
    void equipmentItemDeleted(EquipmentItem removedEquipmentItem);
}
