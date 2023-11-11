package repository.inMemoryRepository;

import domain.gym.Exercise;
import repository.exceptions.ObjectNotContained;
import repository.interfaces.ExerciseRepositoryInterface;
import repository.Repository;

public class ExerciseRepository extends Repository<Exercise> implements ExerciseRepositoryInterface
{
    private static ExerciseRepository instance;

    private int lastId;

    private ExerciseRepository()
    {
        Exercise exercise1 = new Exercise(1, "Squat", "quads", null, 4, 10);
        Exercise exercise2 = new Exercise(2, "Dead-lift", "hamstrings", null, 4, 10);
        arrayList.add(exercise1);
        arrayList.add(exercise2);
        lastId = 2;
    }

    public static ExerciseRepository getInstance()
    {
        if (instance == null) instance = new ExerciseRepository();
        return instance;
    }

    @Override
    public Boolean idInRepo(int id) {
        for (Exercise exercise : arrayList)
        {
            if (id == exercise.getId()) return true;
        }
        return false;
    }

    @Override
    public Exercise searchById(int id) throws ObjectNotContained {
        for (Exercise exercise : arrayList)
        {
            if (id == exercise.getId()) return exercise;
        }
        throw new ObjectNotContained();
    }

    @Override
    public int generateNextId() {
        lastId += 1;
        return lastId;
    }
}
