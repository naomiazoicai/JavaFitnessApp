package controller.interfaces;

import domain.gym.EquipmentItem;
import domain.gym.Exercise;

public interface IExerciseController {
    boolean idInRepo(int id);
    Exercise searchById(int id);
    boolean checkEquipmentItemIdInRepo(int id);
    EquipmentItem searchEquipmentItemById(int id);

}
