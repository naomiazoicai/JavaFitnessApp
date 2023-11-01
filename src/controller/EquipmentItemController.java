package controller;

import domain.gym.EquipmentItem;
import repository.inMemoryRepository.EquipmentItemRepository;


public class EquipmentItemController extends Controller<EquipmentItem>
{
    private static EquipmentItemController instance;

    private EquipmentItemController()
    {
        super(EquipmentItemRepository.getInstance());
    }

    public static EquipmentItemController getInstance()
    {
        if (instance == null) instance = new EquipmentItemController();
        return instance;
    }

}
