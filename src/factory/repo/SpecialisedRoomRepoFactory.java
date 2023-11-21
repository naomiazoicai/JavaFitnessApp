package factory.repo;

import domain.gym.SpecialisedRoom;
import repository.IRepository;
import repository.RepoTypes;
import repository.databaseRepository.SpecialisedRoomDatabaseRepository;
import repository.inMemoryRepository.SpecialisedRoomInMemoryRepository;
import repository.interfaces.ISpecialisedRoomRepository;

public class SpecialisedRoomRepoFactory
{
    public static IRepository<SpecialisedRoom> buildIRepository(RepoTypes repoType)
    {
        return switch (repoType)
        {
            case inMemory -> SpecialisedRoomInMemoryRepository.getInstance();
            case database -> SpecialisedRoomDatabaseRepository.getInstance();
        };
    }

    public static ISpecialisedRoomRepository buildInterface(RepoTypes repoType)
    {
        return switch (repoType)
        {
            case inMemory -> SpecialisedRoomInMemoryRepository.getInstance();
            case database -> SpecialisedRoomDatabaseRepository.getInstance();
        };
    }
}
