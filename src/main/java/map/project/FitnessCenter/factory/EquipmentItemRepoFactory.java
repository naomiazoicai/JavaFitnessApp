package map.project.FitnessCenter.factory;

import map.project.FitnessCenter.data.model.EquipmentItem;
import map.project.FitnessCenter.data.repository.Jpa.EquipmentItemRepository;
import map.project.FitnessCenter.data.repository.inMemory.EquipmentItemInMemoryRepository;
import map.project.FitnessCenter.data.repository.intefaces.ICustomEquipmentItemRepository;
import map.project.FitnessCenter.data.repository.intefaces.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
/**
 * Factory class for creating EquipmentItem repositories based on the specified repository type.
 */
@Service
public class EquipmentItemRepoFactory implements IRepoFactory<EquipmentItem, Long>{
    private final ApplicationContext applicationContext;

    @Autowired
    public EquipmentItemRepoFactory(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public IRepository<EquipmentItem, Long> buildIRepository(RepoTypes type)
    {
        return switch (type)
        {
            case jpa -> getJpa();
            case inMemory -> getInMemory();
        };
    }

    public ICustomEquipmentItemRepository buildCustom(RepoTypes type)
    {
        return switch (type)
        {
            case jpa -> getJpa();
            case inMemory -> getInMemory();
        };
    }

    private EquipmentItemRepository getJpa()
    {
        return applicationContext.getBean(EquipmentItemRepository.class);
    }

    private EquipmentItemInMemoryRepository getInMemory()
    {
        return applicationContext.getBean(EquipmentItemInMemoryRepository.class);
    }

}
