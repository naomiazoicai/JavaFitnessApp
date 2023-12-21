package map.project.FitnessCenter.service.subjects;

import map.project.FitnessCenter.data.model.EquipmentItem;
import map.project.FitnessCenter.service.observers.IObserverDeleteEquipmentItem;

import java.util.ArrayList;

/**
 * A subject interface for notifying observers about the deletion of EquipmentItems.
 */
public interface ISubjectDeleteEquipmentItem {

    /**
     * List to store instances of {@code IObserverDeleteEquipmentItem} for observing EquipmentItem deletions.
     */
    ArrayList<IObserverDeleteEquipmentItem> observerList = new ArrayList<>();

    /**
     * Adds an observer to the list for monitoring EquipmentItem deletions.
     *
     * @param observer The observer to be added.
     */
    void addObserver(IObserverDeleteEquipmentItem observer);

    /**
     * Removes an observer from the list.
     *
     * @param observer The observer to be removed.
     */
    void removeObserver(IObserverDeleteEquipmentItem observer);

    /**
     * Notifies all registered observers that an EquipmentItem has been deleted.
     *
     * @param equipmentItem The EquipmentItem object representing the deleted EquipmentItem.
     */
    void notifyEquipmentItemDeleted(EquipmentItem equipmentItem);
}
