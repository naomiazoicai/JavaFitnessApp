package factory.repo;

import domain.persons.Customer;
import repository.IRepository;
import repository.RepoTypes;
import repository.databaseRepository.CustomerDatabaseRepository;
import repository.inMemoryRepository.CustomerInMemoryRepository;
import repository.interfaces.ICustomerRepository;

public class CustomerRepoFactory
{
    public static IRepository<Customer> buildIRepository(RepoTypes repoType)
    {
        return switch (repoType)
        {
            case inMemory -> CustomerInMemoryRepository.getInstance();
            case database -> CustomerDatabaseRepository.getInstance();
        };
    }

    public static ICustomerRepository buildInterface(RepoTypes repoType)
    {
        return switch (repoType)
        {
            case inMemory -> CustomerInMemoryRepository.getInstance();
            case database -> CustomerDatabaseRepository.getInstance();
        };
    }
}
