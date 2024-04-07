package map.project.FitnessCenter.data.repository.intefaces;

import map.project.FitnessCenter.data.model.EquipmentItem;

/**
 * Interface for the EquipmentItem repository, extending both the general repository and custom repository interfaces.
 */
public interface IEquipmentItemRepository extends IRepository<EquipmentItem, Long>, ICustomEquipmentItemRepository {
}
