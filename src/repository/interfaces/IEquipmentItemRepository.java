package repository.interfaces;
import domain.gym.EquipmentItem;

public interface IEquipmentItemRepository {
    Boolean idInRepo(int id);

    EquipmentItem searchById(int id);

    int generateNextId();
}
