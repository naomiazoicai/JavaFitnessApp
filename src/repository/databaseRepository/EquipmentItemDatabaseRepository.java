package repository.databaseRepository;

import dao.EquipmentItemDao;
import dao.interaces.IEquipmentItemDao;
import domain.gym.EquipmentItem;
import repository.DatabaseRepository;
import repository.interfaces.IEquipmentItemRepository;

public class EquipmentItemDatabaseRepository extends DatabaseRepository<EquipmentItem> implements IEquipmentItemRepository
{
    private static EquipmentItemDatabaseRepository instance;

    private final IEquipmentItemDao equipmentItemDao;

    private EquipmentItemDatabaseRepository()
    {
        super(EquipmentItemDao.getInstance());
        equipmentItemDao = EquipmentItemDao.getInstance();
    }

    public static EquipmentItemDatabaseRepository getInstance()
    {
        if (instance == null) instance = new EquipmentItemDatabaseRepository();
        return instance;
    }

    @Override
    public Boolean idInRepo(int id) {
        return equipmentItemDao.idInRepo(id);
    }

    @Override
    public EquipmentItem searchById(int id){
        return equipmentItemDao.searchById(id);
    }

    @Override
    public int generateNextId() {
        return equipmentItemDao.generateNextId();
    }
}
