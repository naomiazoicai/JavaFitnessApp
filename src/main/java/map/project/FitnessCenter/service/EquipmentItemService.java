package map.project.FitnessCenter.service;

import map.project.FitnessCenter.data.exceptions.ObjectAlreadyContained;
import map.project.FitnessCenter.data.exceptions.ObjectNotContained;
import map.project.FitnessCenter.data.model.EquipmentItem;
import map.project.FitnessCenter.data.repository.EquipmentItemRepository;
import map.project.FitnessCenter.service.interfaces.BaseService;
import map.project.FitnessCenter.service.interfaces.IEquipmentItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EquipmentItemService extends BaseService<EquipmentItem, Long> implements IEquipmentItemService {

    private final EquipmentItemRepository equipmentItemRepository;

    @Autowired
    public EquipmentItemService(EquipmentItemRepository repository) {
        super(repository);
        this.equipmentItemRepository = repository;
    }

    @Override
    public Optional<EquipmentItem> update(Long id, EquipmentItem object) throws ObjectNotContained, ObjectAlreadyContained {
        if (!equipmentItemRepository.existsById(id)) throw new ObjectNotContained();
        if (equipmentItemRepository.exists(Example.of(object))) throw new ObjectAlreadyContained();
        // Save old object
        Optional<EquipmentItem> oldObject = equipmentItemRepository.findById(id).map(EquipmentItem::copy);
        // Update
        object.setId(id);
        equipmentItemRepository.save(object);
        return oldObject;
    }

    @Override
    public Optional<EquipmentItem> delete(Long id) throws ObjectNotContained {
        if (!equipmentItemRepository.existsById(id)) throw new ObjectNotContained();
        Optional<EquipmentItem> oldObject = equipmentItemRepository.findById(id);
        equipmentItemRepository.deleteById(id);
        return oldObject;
    }

    @Override
    public Optional<EquipmentItem> getByName(String name) {
        return equipmentItemRepository.findByName(name);
    }
}
