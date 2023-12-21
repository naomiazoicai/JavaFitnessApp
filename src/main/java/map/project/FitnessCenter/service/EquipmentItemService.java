package map.project.FitnessCenter.service;

import map.project.FitnessCenter.data.exceptions.ObjectNotContained;
import map.project.FitnessCenter.data.model.EquipmentItem;
import map.project.FitnessCenter.data.repository.intefaces.ICustomEquipmentItemRepository;
import map.project.FitnessCenter.proxy.EquipmentItemRepositoryProxy;
import map.project.FitnessCenter.service.interfaces.IEquipmentItemService;
import map.project.FitnessCenter.service.observers.IObserverDeleteEquipmentItem;
import map.project.FitnessCenter.service.subjects.ISubjectDeleteEquipmentItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing the equipment items of the fitness center.
 */
@Service
public class EquipmentItemService extends BaseService<EquipmentItem, Long> implements IEquipmentItemService, ISubjectDeleteEquipmentItem {

    private final ICustomEquipmentItemRepository equipmentItemCustomRepository;
    @Autowired
    public EquipmentItemService(EquipmentItemRepositoryProxy repository, ExerciseService exerciseService) {
        super(repository);
        this.equipmentItemCustomRepository = repository;
        addObserver(exerciseService);
    }

    @Override
    public Optional<EquipmentItem> add(EquipmentItem object){
        repository.save(object);
        return Optional.of(object);
    }

    @Override
    public Optional<EquipmentItem> update(Long id, EquipmentItem object) throws ObjectNotContained {
        if (!repository.existsById(id)) throw new ObjectNotContained();
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
        oldObject.ifPresent(this::notifyEquipmentItemDeleted);
        repository.deleteById(id);
        return oldObject;
    }

    @Override
    public Optional<List<EquipmentItem>> getByName(String name) {
        return equipmentItemCustomRepository.findByName(name);
    }

    @Override
    public void addObserver(IObserverDeleteEquipmentItem observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(IObserverDeleteEquipmentItem observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyEquipmentItemDeleted(EquipmentItem equipmentItem) {
        for (IObserverDeleteEquipmentItem observer : observerList) observer.updateEquipmentItemDeleted(equipmentItem);
    }
}
