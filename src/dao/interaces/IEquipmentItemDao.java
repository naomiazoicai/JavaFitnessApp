package dao.interaces;

import domain.gym.EquipmentItem;

public interface IEquipmentItemDao
{
    Boolean idInRepo(int id);

    EquipmentItem searchById(int id);

    int generateNextId();
}
