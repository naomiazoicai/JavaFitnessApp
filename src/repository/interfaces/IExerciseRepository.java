package repository.interfaces;

import domain.gym.EquipmentItem;
import domain.gym.Exercise;
import repository.exceptions.ObjectNotContained;

public interface IExerciseRepository {
    void equipmentItemDeleted(EquipmentItem removedEquipmentItem);

    Boolean idInRepo(int id);

    Exercise searchById(int id) throws ObjectNotContained;

    int generateNextId();
}
