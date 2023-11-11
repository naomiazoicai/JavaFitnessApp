package controller;

import controller.interfaces.ExerciseControllerInterface;
import controller.interfaces.IObserverDeleteEquipmentItem;
import domain.gym.EquipmentItem;
import domain.gym.Exercise;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;
import repository.inMemoryRepository.EquipmentItemRepository;
import repository.inMemoryRepository.ExerciseRepository;
import repository.interfaces.IEquipmentItemRepository;
import repository.interfaces.IExerciseRepository;

public class ExerciseController extends Controller<Exercise> implements ExerciseControllerInterface, IObserverDeleteEquipmentItem
{
    private static ExerciseController instance;

    private final IExerciseRepository exerciseRepositoryInterface;

    private final IEquipmentItemRepository equipmentItemRepositoryInterface;

    private ExerciseController(ExerciseRepository exerciseRepository)
    {
        super(exerciseRepository);
        exerciseRepositoryInterface = exerciseRepository;
        equipmentItemRepositoryInterface = EquipmentItemRepository.getInstance();
    }

    public static ExerciseController getInstance()
    {
        if (instance == null) instance = new ExerciseController(ExerciseRepository.getInstance());
        return instance;
    }

    @Override
    public boolean idInRepo(int id) {
        // Set id
        return exerciseRepositoryInterface.idInRepo(id);
    }

    @Override
    public Exercise searchById(int id) {
        try {
            return exerciseRepositoryInterface.searchById(id);
        } catch (ObjectNotContained e)
        {
            return null;
        }
    }

    @Override
    public void add(Exercise object) throws ObjectAlreadyContained {
        // Set it
        object.setId(exerciseRepositoryInterface.generateNextId());
        super.add(object);
    }

    @Override
    public boolean checkEquipmentItemIdInRepo(int id) {
        return equipmentItemRepositoryInterface.idInRepo(id);
    }

    @Override
    public EquipmentItem searchEquipmentItemById(int id) {
        try {
            return equipmentItemRepositoryInterface.searchById(id);
        } catch (ObjectNotContained e) {
            return new EquipmentItem();
        }
    }

    @Override
    public void updateEquipmentItemDeleted(EquipmentItem equipmentItem) {
        exerciseRepositoryInterface.equipmentItemDeleted(equipmentItem);
    }
}
