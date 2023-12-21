package map.project.FitnessCenter.service.observers;
import map.project.FitnessCenter.data.model.SpecialisedRoom;

/**
 * A subject interface for receiving notification from subjects about the deletion of Room.
 */
public interface IObserverDeleteRoom {
    /**
     * Signals that an SpecialisedRoom has been deleted from the system.
     * @param room The SpecialisedRoom object representing the deleted SpecialisedRoom.
     */
    void updateRoomDeleted(SpecialisedRoom room);
}
