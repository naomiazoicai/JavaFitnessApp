package controller.interfaces;

import domain.gym.EquipmentItem;

public interface IEquipmentItemController {
    boolean idInRepo(int id);

    EquipmentItem searchById(int id);
}
