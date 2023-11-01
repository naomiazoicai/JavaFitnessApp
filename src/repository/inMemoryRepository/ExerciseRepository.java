package repository.inMemoryRepository;

import domain.gym.Exercise;
import repository.Repository;

public class ExerciseRepository extends Repository<Exercise>
{
    private static ExerciseRepository instance;

    private ExerciseRepository()
    {
        Exercise exercise1 = new Exercise(1, "Squat", "quads", null, 4, 10);
        Exercise exercise2 = new Exercise(2, "Dead-lift", "hamstrings", null, 4, 10);
        arrayList.add(exercise1);
        arrayList.add(exercise2);
    }

    public static ExerciseRepository getInstance()
    {
        if (instance == null) instance = new ExerciseRepository();
        return instance;
    }
}
