package factory.repo;

import domain.gym.EquipmentItem;
import repository.IRepository;
import repository.RepoTypes;
import repository.databaseRepository.EquipmentItemDatabaseRepository;
import repository.inMemoryRepository.EquipmentItemInMemoryRepository;
import repository.interfaces.IEquipmentItemRepository;

public class EquipmentItemRepoFactory
{
    public static IRepository<EquipmentItem> buildIRepository(RepoTypes repoType)
    {
        return switch (repoType)
        {
            case inMemory -> EquipmentItemInMemoryRepository.getInstance();
            case database -> EquipmentItemDatabaseRepository.getInstance();
        };
    }

    public static IEquipmentItemRepository buildInterface(RepoTypes repoType)
    {
        return switch (repoType)
        {
            case inMemory -> EquipmentItemInMemoryRepository.getInstance();
            case database -> EquipmentItemDatabaseRepository.getInstance();
        };
    }
}
