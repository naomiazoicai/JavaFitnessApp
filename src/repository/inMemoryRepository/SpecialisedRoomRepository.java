package repository.inMemoryRepository;

import domain.gym.SpecialisedRoom;
import repository.IRepository;

import java.util.ArrayList;

public class SpecialisedRoomRepository implements IRepository<SpecialisedRoom>
{
    private final ArrayList<SpecialisedRoom> specialisedRooms;

    private static SpecialisedRoomRepository instance;

    private SpecialisedRoomRepository()
    {
        specialisedRooms = new ArrayList<>();
        SpecialisedRoom room1 = new SpecialisedRoom(1, true, false, "Studio", 10);
        SpecialisedRoom room2 = new SpecialisedRoom(2, true, false, "Studio", 10);
        specialisedRooms.add(room1);
        specialisedRooms.add(room2);
    }

    public static SpecialisedRoomRepository getInstance()
    {
        if (instance == null) instance = new SpecialisedRoomRepository();
        return instance;
    }

    @Override
    public void add(SpecialisedRoom object) {
        specialisedRooms.add(object);
    }

    @Override
    public void update(SpecialisedRoom object) {
        specialisedRooms.remove(object);
        specialisedRooms.add(object);
    }

    @Override
    public void delete(SpecialisedRoom object) {
        specialisedRooms.remove(object);
    }

    @Override
    public ArrayList<SpecialisedRoom> getAll() {
        return new ArrayList<>(specialisedRooms);
    }
}
