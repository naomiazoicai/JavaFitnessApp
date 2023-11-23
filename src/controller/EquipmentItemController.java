package controller;

import controller.interfaces.IEquipmentItemController;
import controller.interfaces.observers.IObserverDeleteEquipmentItem;
import controller.interfaces.subjects.ISubjectDeleteEquipmentItem;
import domain.gym.EquipmentItem;
import factory.repo.EquipmentItemRepoFactory;
import repository.IRepository;
import repository.RepoTypes;
import repository.interfaces.IEquipmentItemRepository;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;


public class EquipmentItemController extends Controller<EquipmentItem> implements IEquipmentItemController, ISubjectDeleteEquipmentItem
{
    private static EquipmentItemController instance;
    private static RepoTypes repoType; // Must be set before getInstance()
    private final IEquipmentItemRepository iEquipmentItemRepository;

    private EquipmentItemController(IRepository<EquipmentItem> iRepository, IEquipmentItemRepository iEquipmentItemRepository)
    {
        super(iRepository);
        this.iEquipmentItemRepository = iEquipmentItemRepository;
        addObserver(ExerciseController.getInstance());
    }

    public static EquipmentItemController getInstance()
    {
        if (instance == null)
        {
            if (repoType == null) throw new RuntimeException("Repo Type not provided!");
            IRepository<EquipmentItem> iRepository = EquipmentItemRepoFactory.buildIRepository(repoType);
            IEquipmentItemRepository iEquipmentItemRepository = EquipmentItemRepoFactory.buildInterface(repoType);
            instance = new EquipmentItemController(iRepository, iEquipmentItemRepository);
        }
        return instance;
    }

    @Override
    public boolean idInRepo(int id)
    {
        return iEquipmentItemRepository.idInRepo(id);
    }

    @Override
    public EquipmentItem searchById(int id)
    {
        return iEquipmentItemRepository.searchById(id);
    }

    @Override
    public void add(EquipmentItem object) throws ObjectAlreadyContained
    {
        // Set id
        object.setID(iEquipmentItemRepository.generateNextId());
        super.add(object);
    }

    @Override
    public void delete(EquipmentItem object) throws ObjectNotContained
    {
        notifyEquipmentItemDeleted(object);
        super.delete(object);
    }

    @Override
    public void addObserver(IObserverDeleteEquipmentItem observer)
    {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(IObserverDeleteEquipmentItem observer)
    {
        observerList.remove(observer);
    }

    @Override
    public void notifyEquipmentItemDeleted(EquipmentItem equipmentItem)
    {
        for (IObserverDeleteEquipmentItem observer : observerList) observer.updateEquipmentItemDeleted(equipmentItem);
    }

    public static void setRepoType(RepoTypes newRepoType)
    {
        repoType = newRepoType;
    }
}
