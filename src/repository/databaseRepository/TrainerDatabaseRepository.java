package repository.databaseRepository;

import dao.TrainerDao;
import dao.interaces.ITrainerDao;
import domain.persons.Trainer;
import repository.DatabaseRepository;
import repository.interfaces.ITrainerRepository;

import java.util.ArrayList;

public class TrainerDatabaseRepository extends DatabaseRepository<Trainer> implements ITrainerRepository
{
    private static TrainerDatabaseRepository instance;

    private final ITrainerDao trainerDao;

    private TrainerDatabaseRepository()
    {
        super(TrainerDao.getInstance());
        trainerDao = TrainerDao.getInstance();
    }

    public static TrainerDatabaseRepository getInstance()
    {
        if (instance == null) instance = new TrainerDatabaseRepository();
        return instance;
    }

    @Override
    public Boolean usernameInRepo(String keyName)
    {
        return trainerDao.keyNameInRepo(keyName);
    }

    @Override
    public ArrayList<Trainer> searchByPartialUsername(String keyName)
    {
        return trainerDao.searchByPartialKeyName(keyName);
    }

    @Override
    public Trainer searchByUsername(String keyName)
    {
        return trainerDao.searchByKeyName(keyName);
    }
}
