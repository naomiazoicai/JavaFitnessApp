package map.project.FitnessCenter.service.subjects;

import map.project.FitnessCenter.data.model.EquipmentItem;
import map.project.FitnessCenter.service.observers.IObserverDeleteEquipmentItem;

import java.util.ArrayList;

public interface ISubjectDeleteEquipmentItem {
    ArrayList<IObserverDeleteEquipmentItem> observerList = new ArrayList<>();
    void addObserver(IObserverDeleteEquipmentItem observer);

    void removeObserver(IObserverDeleteEquipmentItem observer);

    void notifyEquipmentItemDeleted(EquipmentItem equipmentItem);
}
