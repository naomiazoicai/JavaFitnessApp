package controller;

import domain.gym.EquipmentItem;

public interface EquipmentItemControllerInterface {
    boolean idInRepo(int id);

    EquipmentItem searchById(int id);
}
