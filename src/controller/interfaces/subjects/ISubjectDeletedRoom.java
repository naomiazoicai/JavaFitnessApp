package controller.interfaces.subjects;

import controller.interfaces.observers.IObserverDeletedRoom;
import domain.gym.Room;

import java.util.ArrayList;

public interface ISubjectDeletedRoom {
    ArrayList<IObserverDeletedRoom> observerList = new ArrayList<>();

    void addObserver(IObserverDeletedRoom observer);

    void removeObserver(IObserverDeletedRoom observer);

    void notifyRoomDeleted(Room room);
}
