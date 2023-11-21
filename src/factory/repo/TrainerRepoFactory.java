package factory.repo;

import domain.persons.Trainer;
import repository.IRepository;
import repository.RepoTypes;
import repository.databaseRepository.TrainerDatabaseRepository;
import repository.inMemoryRepository.TrainerInMemoryRepository;
import repository.interfaces.ITrainerRepository;

public class TrainerRepoFactory
{
    public static IRepository<Trainer> buildIRepository(RepoTypes repoType)
    {
        return switch (repoType)
        {
            case inMemory -> TrainerInMemoryRepository.getInstance();
            case database -> TrainerDatabaseRepository.getInstance();
        };
    }

    public static ITrainerRepository buildInterface(RepoTypes repoType)
    {
        return switch (repoType)
        {
            case inMemory -> TrainerInMemoryRepository.getInstance();
            case database -> TrainerDatabaseRepository.getInstance();
        };
    }
}
