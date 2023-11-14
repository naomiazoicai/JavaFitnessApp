package controller.interfaces;

import domain.gym.EquipmentItem;

import java.util.ArrayList;

public interface ISubjectDeleteEquipmentItem {
    ArrayList<IObserverDeleteEquipmentItem> observerList = new ArrayList<>();
    void addObserver(IObserverDeleteEquipmentItem observer);

    void removeObserver(IObserverDeleteEquipmentItem observer);

    void notifyEquipmentItemDeleted(EquipmentItem equipmentItem);
}
