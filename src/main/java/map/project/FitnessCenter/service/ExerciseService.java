package map.project.FitnessCenter.service;

import map.project.FitnessCenter.data.exceptions.ObjectAlreadyContained;
import map.project.FitnessCenter.data.exceptions.ObjectNotContained;
import map.project.FitnessCenter.data.model.EquipmentItem;
import map.project.FitnessCenter.data.model.Exercise;
import map.project.FitnessCenter.data.repository.EquipmentItemRepository;
import map.project.FitnessCenter.data.repository.ExerciseRepository;
import map.project.FitnessCenter.data.repository.intefaces.IExerciseRepository;
import map.project.FitnessCenter.service.interfaces.IExerciseService;
import map.project.FitnessCenter.service.observers.IObserverDeleteEquipmentItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseService extends BaseService<Exercise, Long>
        implements IExerciseService, IObserverDeleteEquipmentItem
{
    private final IExerciseRepository exerciseRepository;
    private final EquipmentItemRepository equipmentItemRepository;

    @Autowired
    public ExerciseService(ExerciseRepository repository, EquipmentItemRepository equipmentItemRepository) {
        super(repository);
        this.exerciseRepository = repository;
        this.equipmentItemRepository = equipmentItemRepository;
    }

    @Override
    public Optional<Exercise> add(Exercise object) throws ObjectAlreadyContained
    {
        if (object.getEquipmentUsed() != null)
        {
            Optional<EquipmentItem> equipmentItem = equipmentItemRepository.findById(object.getEquipmentUsed().getId());
            if (equipmentItem.isPresent())
            {
                object.setEquipmentUsed(equipmentItem.get());
            }
            else object.setEquipmentUsed(null);
        }
        return super.add(object);
    }

    @Override
    public Optional<Exercise> update(Long id, Exercise object) throws ObjectNotContained, ObjectAlreadyContained {
        if (!repository.existsById(id)) throw new ObjectNotContained();
        // Set Equipment Item Used
        if (object.getEquipmentUsed() != null)
        {
            Optional<EquipmentItem> equipmentItem = equipmentItemRepository.findById(object.getEquipmentUsed().getId());
            if (equipmentItem.isPresent())
            {
                object.setEquipmentUsed(equipmentItem.get());
            }
            else object.setEquipmentUsed(null);
        }
        // Check if same exercise exists
        if (repository.exists(Example.of(object))) throw new ObjectAlreadyContained();
        // Save old object
        Optional<Exercise> oldExercise = repository.findById(id).map(Exercise::copy);
        // Update
        object.setId(id);
        repository.save(object);
        return oldExercise;
    }

    @Override
    public Optional<Exercise> delete(Long id) throws ObjectNotContained {
        if (!repository.existsById(id)) throw new ObjectNotContained();
        Optional<Exercise> oldObject = repository.findById(id);
        repository.deleteById(id);
        return oldObject;
    }

    @Override
    public Optional<List<Exercise>> getByName(String name) {
        return exerciseRepository.findByName(name);
    }

    @Override
    public void updateEquipmentItemDeleted(EquipmentItem equipmentItem) {
        exerciseRepository.updateEquipmentItemDeleted(equipmentItem);
    }
}
