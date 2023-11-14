package controller.interfaces;

import domain.gym.Room;
import domain.persons.Trainer;

import java.util.ArrayList;

public interface ISubjectDeletedRoom {
    ArrayList<IObserverDeletedRoom> observerList = new ArrayList<>();

    void addObserver(IObserverDeletedRoom observer);

    void removeObserver(IObserverDeletedRoom observer);

    void notifyRoomDeleted(Room room);
}
