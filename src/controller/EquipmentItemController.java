package controller;

import domain.gym.EquipmentItem;
import repository.interfaces.EquipmentItemRepositoryInterface;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;
import repository.inMemoryRepository.EquipmentItemRepository;


public class EquipmentItemController extends Controller<EquipmentItem> implements EquipmentItemControllerInterface
{
    private static EquipmentItemController instance;

    private final EquipmentItemRepositoryInterface equipmentItemRepositoryInterface;

    private EquipmentItemController(EquipmentItemRepository equipmentItemRepository)
    {
        super(equipmentItemRepository);
        equipmentItemRepositoryInterface = equipmentItemRepository;
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
}
