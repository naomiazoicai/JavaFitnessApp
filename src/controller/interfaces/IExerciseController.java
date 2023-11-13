package controller.interfaces;

import domain.gym.EquipmentItem;
import domain.gym.Exercise;

public interface IExerciseController extends IdIdentifiedEntitiesController<Exercise> {
    boolean checkEquipmentItemIdInRepo(int id);
    EquipmentItem searchEquipmentItemById(int id);
}
