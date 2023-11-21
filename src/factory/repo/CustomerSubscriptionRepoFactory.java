package factory.repo;

import domain.money.CustomerSubscription;
import repository.IRepository;
import repository.RepoTypes;
import repository.databaseRepository.CustomerSubscriptionDatabaseRepository;
import repository.inMemoryRepository.CustomerSubscriptionInMemoryRepository;
import repository.interfaces.ICustomerSubscriptionRepository;

public class CustomerSubscriptionRepoFactory
{
    public static IRepository<CustomerSubscription> buildIRepository(RepoTypes repoType)
    {
        return switch (repoType)
        {
            case inMemory -> CustomerSubscriptionInMemoryRepository.getInstance();
            case database -> CustomerSubscriptionDatabaseRepository.getInstance();
        };
    }

    public static ICustomerSubscriptionRepository buildInterface(RepoTypes repoType)
    {
        return switch (repoType)
        {
            case inMemory -> CustomerSubscriptionInMemoryRepository.getInstance();
            case database -> CustomerSubscriptionDatabaseRepository.getInstance();
        };
    }
}
