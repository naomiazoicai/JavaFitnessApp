package map.project.FitnessCenter.service.observers;

import map.project.FitnessCenter.data.model.EquipmentItem;

/**
 * A subject interface for receiving notification from subjects about the deletion of EquipmentItem.
 */
public interface IObserverDeleteEquipmentItem
{
    /**
     * Signals that an EquipmentItem has been deleted from the system.
     * @param equipmentItem The EquipmentItem object representing the deleted EquipmentItem.
     */
    void updateEquipmentItemDeleted(EquipmentItem equipmentItem);
}
