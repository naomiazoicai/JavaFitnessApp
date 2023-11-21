package repository.databaseRepository;

import dao.ExerciseDao;
import dao.interaces.IExerciseDao;
import domain.gym.EquipmentItem;
import domain.gym.Exercise;
import repository.DatabaseRepository;
import repository.exceptions.ObjectNotContained;
import repository.interfaces.IExerciseRepository;

public class ExerciseDatabaseRepository extends DatabaseRepository<Exercise> implements IExerciseRepository
{
    private static ExerciseDatabaseRepository instance;

    private final IExerciseDao exerciseDao;

    private ExerciseDatabaseRepository()
    {
        super(ExerciseDao.getInstance());
        exerciseDao = ExerciseDao.getInstance();
    }

    @Override
    public void equipmentItemDeleted(EquipmentItem removedEquipmentItem)
    {
        exerciseDao.equipmentItemDeleted(removedEquipmentItem);
    }

    @Override
    public Boolean idInRepo(int id)
    {
        return exerciseDao.idInRepo(id);
    }

    @Override
    public Exercise searchById(int id) throws ObjectNotContained
    {
        return exerciseDao.searchById(id);
    }

    @Override
    public int generateNextId()
    {
        return exerciseDao.generateNextId();
    }
}
