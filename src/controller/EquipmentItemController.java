package controller;

import controller.interfaces.IEquipmentItemController;
import controller.interfaces.observers.IObserverDeleteEquipmentItem;
import controller.interfaces.subjects.ISubjectDeleteEquipmentItem;
import domain.gym.EquipmentItem;
import repository.interfaces.IEquipmentItemRepository;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;
import repository.inMemoryRepository.EquipmentItemRepository;


public class EquipmentItemController extends Controller<EquipmentItem> implements IEquipmentItemController, ISubjectDeleteEquipmentItem
{
    private static EquipmentItemController instance;

    private final IEquipmentItemRepository equipmentItemRepositoryInterface;

    private EquipmentItemController(EquipmentItemRepository equipmentItemRepository)
    {
        super(equipmentItemRepository);
        equipmentItemRepositoryInterface = equipmentItemRepository;
        addObserver(ExerciseController.getInstance());
    }

    public static EquipmentItemController getInstance()
    {
        if (instance == null) instance = new EquipmentItemController(EquipmentItemRepository.getInstance());
        return instance;
    }

    @Override
    public boolean idInRepo(int id) {
        return equipmentItemRepositoryInterface.idInRepo(id);
    }

    @Override
    public EquipmentItem searchById(int id)
    {
        try {
            return equipmentItemRepositoryInterface.searchById(id);
        } catch (ObjectNotContained e) {
            return new EquipmentItem();
        }
    }

    @Override
    public void add(EquipmentItem object) throws ObjectAlreadyContained {
        // Set id
        object.setID(equipmentItemRepositoryInterface.generateNextId());
        super.add(object);
    }

    @Override
    public void delete(EquipmentItem object) throws ObjectNotContained {
        super.delete(object);
        notifyEquipmentItemDeleted(object);
    }

    @Override
    public void addObserver(IObserverDeleteEquipmentItem observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(IObserverDeleteEquipmentItem observer) {
        observerList.add(observer);
    }

    @Override
    public void notifyEquipmentItemDeleted(EquipmentItem equipmentItem) {
        for (IObserverDeleteEquipmentItem observer : observerList) observer.updateEquipmentItemDeleted(equipmentItem);
    }
}
