package controller;

import domain.gym.EquipmentItem;
import repository.inMemoryRepository.EquipmentItemRepository;

public class EquipmentItemController implements IController<EquipmentItem>
{
    private final EquipmentItemRepository repository;
    private static EquipmentItemController instance;

    private EquipmentItemController(EquipmentItemRepository repository)
    {
        this.repository = repository;
    }

    public static EquipmentItemController getInstance(EquipmentItemRepository repository)
    {
        if (instance == null) instance = new EquipmentItemController(repository);
        return instance;
    }

    public static EquipmentItemController getInstance()
    {
        if (instance == null) throw new Error("Repository was never provided");
        return instance;
    }

    @Override
    public void add(EquipmentItem object) {
        repository.add(object);
    }

    @Override
    public void update(EquipmentItem object) {
        repository.update(object);
    }

    @Override
    public void delete(EquipmentItem object) {
        repository.delete(object);
    }
}
