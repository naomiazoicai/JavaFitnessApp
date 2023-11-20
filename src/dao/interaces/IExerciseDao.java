package dao.interaces;

import domain.gym.EquipmentItem;
import domain.gym.Exercise;
import repository.exceptions.ObjectNotContained;

public interface IExerciseDao {
    Boolean idInRepo(int id);

    Exercise searchById(int id) throws ObjectNotContained;

    int generateNextId();

    void equipmentItemDeleted(EquipmentItem removedEquipmentItem);
}
