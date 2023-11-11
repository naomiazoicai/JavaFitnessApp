package repository;
import domain.gym.EquipmentItem;
import repository.exceptions.ObjectNotContained;

public interface EquipmentItemRepositoryInterface {
    Boolean idInRepo(int id);

    EquipmentItem searchById(int id) throws ObjectNotContained;

    int generateNextId();
}
