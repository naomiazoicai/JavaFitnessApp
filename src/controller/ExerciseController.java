package controller;

import controller.interfaces.IExerciseController;
import controller.interfaces.observers.IObserverDeleteEquipmentItem;
import domain.gym.EquipmentItem;
import domain.gym.Exercise;
import factory.repo.EquipmentItemRepoFactory;
import factory.repo.ExerciseRepoFactory;
import repository.IRepository;
import repository.RepoTypes;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;
import repository.interfaces.IEquipmentItemRepository;
import repository.interfaces.IExerciseRepository;

public class ExerciseController extends Controller<Exercise> implements IExerciseController, IObserverDeleteEquipmentItem
{
    private static ExerciseController instance;

    private final IExerciseRepository iExerciseRepository;

    private final IEquipmentItemRepository iEquipmentItemRepository;

    private static RepoTypes repoType;

    private ExerciseController(IRepository<Exercise> iRepository, IExerciseRepository iExerciseRepository, IEquipmentItemRepository iEquipmentItemRepository)
    {
        super(iRepository);
        this.iExerciseRepository = iExerciseRepository;
        this.iEquipmentItemRepository = iEquipmentItemRepository;
    }

    public static ExerciseController getInstance()
    {
        if (instance == null)
        {
            if (repoType == null) throw new RuntimeException("Repo Type not provided!");
            IRepository<Exercise> iRepository = ExerciseRepoFactory.buildIRepository(repoType);
            IExerciseRepository iExerciseRepository = ExerciseRepoFactory.buildInterface(repoType);
            IEquipmentItemRepository iEquipmentItemRepository = EquipmentItemRepoFactory.buildInterface(repoType);
            instance = new ExerciseController(iRepository, iExerciseRepository, iEquipmentItemRepository);
        }
        return instance;
    }

    @Override
    public boolean idInRepo(int id)
    {
        // Set id
        return iExerciseRepository.idInRepo(id);
    }

    @Override
    public Exercise searchById(int id)
    {
        try {
            return iExerciseRepository.searchById(id);
        } catch (ObjectNotContained e)
        {
            return null;
        }
    }

    @Override
    public void add(Exercise object) throws ObjectAlreadyContained
    {
        // Set it
        object.setId(iExerciseRepository.generateNextId());
        super.add(object);
    }

    @Override
    public boolean checkEquipmentItemIdInRepo(int id) {
        return iEquipmentItemRepository.idInRepo(id);
    }

    @Override
    public EquipmentItem searchEquipmentItemById(int id)
    {
        try {
            return iEquipmentItemRepository.searchById(id);
        } catch (ObjectNotContained e) {
            return new EquipmentItem();
        }
    }

    @Override
    public void updateEquipmentItemDeleted(EquipmentItem equipmentItem)
    {
        iExerciseRepository.equipmentItemDeleted(equipmentItem);
    }

    public static void setRepoType(RepoTypes newRepoType)
    {
        repoType = newRepoType;
    }
}
