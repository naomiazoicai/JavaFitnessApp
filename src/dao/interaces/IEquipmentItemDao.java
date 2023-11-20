package dao.interaces;

import domain.gym.EquipmentItem;
import repository.exceptions.ObjectNotContained;

public interface IEquipmentItemDao {
    Boolean idInRepo(int id);

    EquipmentItem searchById(int id) throws ObjectNotContained;

    int generateNextId();
}
