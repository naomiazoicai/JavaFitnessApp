package map.project.FitnessCenter.service.subjects;

import map.project.FitnessCenter.data.model.SpecialisedRoom;
import map.project.FitnessCenter.service.observers.IObserverDeleteRoom;

import java.util.ArrayList;

/**
 * A subject interface for notifying observers about the deletion of SpecialisedRooms.
 */
public interface ISubjectDeleteRoom {

    /**
     * List to store instances of {@code IObserverDeleteRoom} for observing SpecialisedRoom deletions.
     */
    ArrayList<IObserverDeleteRoom> observerList = new ArrayList<>();

    /**
     * Adds an observer to the list for monitoring SpecialisedRoom deletions.
     *
     * @param observer The observer to be added.
     */
    void addObserver(IObserverDeleteRoom observer);

    /**
     * Removes an observer from the list.
     *
     * @param observer The observer to be removed.
     */
    void removeObserver(IObserverDeleteRoom observer);

    /**
     * Notifies all registered observers that a SpecialisedRoom has been deleted.
     *
     * @param room The SpecialisedRoom object representing the deleted SpecialisedRoom.
     */
    void notifyRoomDeleted(SpecialisedRoom room);
}
