package map.project.FitnessCenter.proxy;

import map.project.FitnessCenter.data.model.EquipmentItem;
import map.project.FitnessCenter.data.repository.Jpa.EquipmentItemRepository;
import map.project.FitnessCenter.data.repository.inMemory.EquipmentItemInMemoryRepository;
import map.project.FitnessCenter.data.repository.intefaces.IEquipmentItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentItemProxy extends RepoProxy<EquipmentItem, Long> implements IEquipmentItemRepository {
    private final EquipmentItemInMemoryRepository equipmentItemInMemoryRepository;

    @Autowired
    public EquipmentItemProxy(EquipmentItemRepository jpaRepo, EquipmentItemInMemoryRepository equipmentItemInMemoryRepository) {
        super(jpaRepo);
        this.equipmentItemInMemoryRepository = equipmentItemInMemoryRepository;
    }

    @Override
    public void selectInMemory()
    {
        if (inMemoryRepo == null) inMemoryRepo = equipmentItemInMemoryRepository;
        currentRepo = inMemoryRepo;
    }

    @Override
    public Optional<List<EquipmentItem>> findByName(String name) {
        return equipmentItemInMemoryRepository.findByName(name);
    }
}
