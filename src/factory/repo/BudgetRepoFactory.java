package factory.repo;

import repository.RepoTypes;
import repository.databaseRepository.BudgetDatabaseRepository;
import repository.inMemoryRepository.BudgetInMemoryRepository;
import repository.interfaces.IBudgetRepo;

public class BudgetRepoFactory
{
    public static IBudgetRepo buildInterface(RepoTypes repoType)
    {
        return switch (repoType)
        {
            case inMemory -> BudgetInMemoryRepository.getInstance();
            case database -> BudgetDatabaseRepository.getInstance();
        };
    }
}
