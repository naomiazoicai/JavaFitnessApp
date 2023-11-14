package repository.inMemoryRepository;

import domain.gym.RoomType;
import domain.gym.SpecialisedRoom;
import repository.Repository;
import repository.exceptions.ObjectNotContained;
import repository.interfaces.ISpecialisedRoomRepository;

public class SpecialisedRoomRepository extends Repository<SpecialisedRoom> implements ISpecialisedRoomRepository
{
    private static SpecialisedRoomRepository instance;

    private int lastId;

    private SpecialisedRoomRepository()
    {
        SpecialisedRoom room1 = new SpecialisedRoom(1, true, RoomType.studio, 10);
        SpecialisedRoom room2 = new SpecialisedRoom(2, true, RoomType.studio, 10);
        arrayList.add(room1);
        arrayList.add(room2);
        lastId = 2;
    }

    public static SpecialisedRoomRepository getInstance()
    {
        if (instance == null) instance = new SpecialisedRoomRepository();
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
    public SpecialisedRoom searchById(int id) throws ObjectNotContained {
        for (SpecialisedRoom specialisedRoom : arrayList)
        {
            if (id == specialisedRoom.getId()) return specialisedRoom;
        }
        return new SpecialisedRoom();
    }

    @Override
    public int generateNextId() {
        lastId += 1;
        return lastId;
    }
}
