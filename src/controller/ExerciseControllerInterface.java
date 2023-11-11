package controller;

import controller.interfaces.IdIdentifiedEntitiesController;
import domain.gym.EquipmentItem;
import domain.gym.Exercise;

public interface ExerciseControllerInterface extends IdIdentifiedEntitiesController<Exercise> {
    boolean checkEquipmentItemIdInRepo(int id);
    EquipmentItem searchEquipmentItemById(int id);
}
