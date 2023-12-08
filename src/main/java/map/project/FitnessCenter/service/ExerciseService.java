package map.project.FitnessCenter.service;

import map.project.FitnessCenter.data.exceptions.ObjectAlreadyContained;
import map.project.FitnessCenter.data.exceptions.ObjectNotContained;
import map.project.FitnessCenter.data.model.EquipmentItem;
import map.project.FitnessCenter.data.model.Exercise;
import map.project.FitnessCenter.data.repository.EquipmentItemRepository;
import map.project.FitnessCenter.data.repository.ExerciseRepository;
import map.project.FitnessCenter.service.interfaces.BaseService;
import map.project.FitnessCenter.service.interfaces.IExerciseService;
import map.project.FitnessCenter.service.observers.IObserverDeleteEquipmentItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseService extends BaseService<Exercise, Long> implements IExerciseService, IObserverDeleteEquipmentItem
{
    private final ExerciseRepository exerciseRepository; //TODO add interface for repo
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
        if (!exerciseRepository.existsById(id)) throw new ObjectNotContained();
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
        if (exerciseRepository.exists(Example.of(object))) throw new ObjectAlreadyContained();
        // Save old object
        Optional<Exercise> oldExercise = exerciseRepository.findById(id).map(Exercise::copy);
        // Update
        object.setId(id);
        exerciseRepository.save(object);
        return oldExercise;
    }

    @Override
    public Optional<Exercise> delete(Long id) throws ObjectNotContained {
        if (!exerciseRepository.existsById(id)) throw new ObjectNotContained();
        Optional<Exercise> oldObject = exerciseRepository.findById(id);
        exerciseRepository.deleteById(id);
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
