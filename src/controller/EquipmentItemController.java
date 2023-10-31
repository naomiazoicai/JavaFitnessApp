package controller;

import domain.gym.EquipmentItem;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;
import repository.inMemoryRepository.EquipmentItemRepository;

import java.util.ArrayList;

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
    public void add(EquipmentItem object) throws ObjectAlreadyContained {
        repository.add(object);
    }

    @Override
    public void update(EquipmentItem object) throws ObjectNotContained {
        repository.update(object);
    }

    @Override
    public void delete(EquipmentItem object) throws ObjectNotContained {
        repository.delete(object);
    }

    @Override
    public ArrayList<EquipmentItem> getAll() {
        return repository.getAll();
    }
}
