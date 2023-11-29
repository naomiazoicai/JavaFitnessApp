package map.project.FitnessCenter.service;

import map.project.FitnessCenter.data.exceptions.ObjectAlreadyContained;
import map.project.FitnessCenter.data.exceptions.ObjectNotContained;
import map.project.FitnessCenter.data.model.EquipmentItem;
import map.project.FitnessCenter.data.repository.EquipmentItemRepository;
import map.project.FitnessCenter.service.interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentItemService implements IService<EquipmentItem> {

    @Autowired
    private EquipmentItemRepository repository;

    @Override
    public Optional<EquipmentItem> add(EquipmentItem object) throws ObjectAlreadyContained {
        if (repository.exists(Example.of(object))) throw new ObjectAlreadyContained();
        repository.save(object);
        Long id = object.getId();
        return repository.findById(id);
    }

    @Override
    public Optional<EquipmentItem> update(Long id, EquipmentItem object) throws ObjectNotContained, ObjectAlreadyContained {
        if (!repository.existsById(id)) throw new ObjectNotContained();
        if (repository.exists(Example.of(object))) throw new ObjectAlreadyContained();
        // Save old object
        Optional<EquipmentItem> oldObject = repository.findById(id).map(EquipmentItem::copy);
        // Update
        object.setId(id);
        repository.save(object);
        return oldObject;
    }

    @Override
    public Optional<EquipmentItem> delete(Long id) throws ObjectNotContained {
        if (!repository.existsById(id)) throw new ObjectNotContained();
        Optional<EquipmentItem> oldObject = repository.findById(id);
        repository.deleteById(id);
        return oldObject;
    }

    @Override
    public Optional<List<EquipmentItem>> getAll() {
        List<EquipmentItem> list = repository.findAll();
        if (list.isEmpty()) return Optional.empty();
        return Optional.of(list);
    }

    @Override
    public Optional<EquipmentItem> getEntityById(Long id) {
        return repository.findById(id);
    }
}
