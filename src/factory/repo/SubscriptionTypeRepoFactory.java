package factory.repo;

import domain.money.SubscriptionType;
import repository.IRepository;
import repository.RepoTypes;
import repository.databaseRepository.SubscriptionTypeDatabaseRepository;
import repository.inMemoryRepository.SubscriptionTypeInMemoryRepository;
import repository.interfaces.ISubscriptionTypeRepository;

public class SubscriptionTypeRepoFactory
{
    public static IRepository<SubscriptionType> buildIRepository(RepoTypes repoType)
    {
        return switch (repoType)
        {
            case inMemory -> SubscriptionTypeInMemoryRepository.getInstance();
            case database -> SubscriptionTypeDatabaseRepository.getInstance();
        };
    }

    public static ISubscriptionTypeRepository buildInterface(RepoTypes repoType)
    {
        return switch (repoType)
        {
            case inMemory -> SubscriptionTypeInMemoryRepository.getInstance();
            case database -> SubscriptionTypeDatabaseRepository.getInstance();
        };
    }
}
