package map.project.FitnessCenter.service.subjects;


import map.project.FitnessCenter.data.model.SpecialisedRoom;
import map.project.FitnessCenter.service.observers.IObserverDeleteRoom;

import java.util.ArrayList;

public interface ISubjectDeleteRoom {
    ArrayList<IObserverDeleteRoom> observerList = new ArrayList<>();
    void addObserver(IObserverDeleteRoom observer);

    void removeObserver(IObserverDeleteRoom observer);

    void notifyRoomDeleted(SpecialisedRoom room);
}
