package repository.inMemoryRepository;

import domain.gym.RoomType;
import domain.gym.SpecialisedRoom;
import repository.InMemoryRepository;
import repository.interfaces.ISpecialisedRoomRepository;

public class SpecialisedRoomInMemoryRepository extends InMemoryRepository<SpecialisedRoom> implements ISpecialisedRoomRepository
{
    private static SpecialisedRoomInMemoryRepository instance;

    private int lastId;

    private SpecialisedRoomInMemoryRepository()
    {
        SpecialisedRoom room1 = new SpecialisedRoom(1, true, RoomType.studio, 10);
        SpecialisedRoom room2 = new SpecialisedRoom(2, true, RoomType.studio, 10);
        arrayList.add(room1);
        arrayList.add(room2);
        lastId = 2;
    }

    public static SpecialisedRoomInMemoryRepository getInstance()
    {
        if (instance == null) instance = new SpecialisedRoomInMemoryRepository();
        return instance;
    }

    @Override
    public Boolean idInRepo(int id) {
        for (SpecialisedRoom specialisedRoom : arrayList)
        {
            if (id == specialisedRoom.getId()) return true;
        }
        return false;
    }

    @Override
    public SpecialisedRoom searchById(int id)
    {
        for (SpecialisedRoom specialisedRoom : arrayList)
        {
            if (id == specialisedRoom.getId()) return specialisedRoom.copy();
        }
        return SpecialisedRoom.getNullSpecialisedRoom();
    }

    @Override
    public int generateNextId() {
        lastId += 1;
        return lastId;
    }
}
