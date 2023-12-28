package map.project.FitnessCenter.proxy;

import map.project.FitnessCenter.data.model.EquipmentItem;
import map.project.FitnessCenter.data.repository.intefaces.ICustomEquipmentItemRepository;
import map.project.FitnessCenter.data.repository.intefaces.IEquipmentItemRepository;
import map.project.FitnessCenter.factory.EquipmentItemRepoFactory;
import map.project.FitnessCenter.factory.RepoTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
/**
 * Proxy class for the EquipmentItem repository, implementing both IEquipmentItemRepository
 * and ICustomEquipmentItemRepository interfaces.
 */
@Component
public class EquipmentItemRepositoryProxy extends RepoProxy<EquipmentItem, Long> implements IEquipmentItemRepository {
    private ICustomEquipmentItemRepository customRepo;
    private final EquipmentItemRepoFactory factory;

    @Autowired
    public EquipmentItemRepositoryProxy(ApplicationContext applicationContext) {
        factory = applicationContext.getBean(EquipmentItemRepoFactory.class);
        selectJpa();
    }

    public void selectJpa() {
        currentRepo = factory.buildIRepository(RepoTypes.jpa);
        customRepo = factory.buildCustom(RepoTypes.jpa);
    }

    @Override
    public void selectInMemory()
    {
        currentRepo = factory.buildIRepository(RepoTypes.inMemory);
        customRepo = factory.buildCustom(RepoTypes.inMemory);
    }

    @Override
    public Optional<List<EquipmentItem>> findByName(String name) {
        return customRepo.findByName(name);
    }
}
