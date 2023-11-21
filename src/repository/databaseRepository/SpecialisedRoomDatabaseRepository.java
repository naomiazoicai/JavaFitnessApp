package repository.databaseRepository;

import dao.SpecialisedRoomDao;
import dao.interaces.ISpecialisedRoomDao;
import domain.gym.RoomType;
import domain.gym.SpecialisedRoom;
import repository.DatabaseRepository;
import repository.exceptions.ObjectNotContained;
import repository.inMemoryRepository.SpecialisedRoomInMemoryRepository;
import repository.interfaces.ISpecialisedRoomRepository;

public class SpecialisedRoomDatabaseRepository extends DatabaseRepository<SpecialisedRoom> implements ISpecialisedRoomRepository
{
    private static SpecialisedRoomDatabaseRepository instance;

    private final ISpecialisedRoomDao specialisedRoomDao;

    private SpecialisedRoomDatabaseRepository()
    {
        super(SpecialisedRoomDao.getInstance());
        specialisedRoomDao = SpecialisedRoomDao.getInstance();
    }

    public static SpecialisedRoomDatabaseRepository getInstance()
    {
        if (instance == null) instance = new SpecialisedRoomDatabaseRepository();
        return instance;
    }

    @Override
    public Boolean idInRepo(int id) {
        return specialisedRoomDao.idInRepo(id);
    }

    @Override
    public SpecialisedRoom searchById(int id) throws ObjectNotContained {
        return specialisedRoomDao.searchById(id);
    }

    @Override
    public int generateNextId() {
        return specialisedRoomDao.generateNextId();
    }
}
