package repository.inMemoryRepository;

import domain.gym.SpecialisedRoom;
import repository.Repository;

public class SpecialisedRoomRepository extends Repository<SpecialisedRoom>
{

    private static SpecialisedRoomRepository instance;

    private SpecialisedRoomRepository()
    {
        SpecialisedRoom room1 = new SpecialisedRoom(1, true, false, "Studio", 10);
        SpecialisedRoom room2 = new SpecialisedRoom(2, true, false, "Studio", 10);
        arrayList.add(room1);
        arrayList.add(room2);
    }

    public static SpecialisedRoomRepository getInstance()
    {
        if (instance == null) instance = new SpecialisedRoomRepository();
        return instance;
    }
}
