package repository.inMemoryRepository;

import domain.gym.Exercise;
import repository.IRepository;

import java.util.ArrayList;

public class ExerciseRepository implements IRepository<Exercise>
{
    private final ArrayList<Exercise> exercises;

    private static ExerciseRepository instance;

    private ExerciseRepository()
    {
        exercises = new ArrayList<>();
        Exercise exercise1 = new Exercise(1, "Squat", "quads", null, 4, 10);
        Exercise exercise2 = new Exercise(2, "Dead-lift", "hamstrings", null, 4, 10);
        exercises.add(exercise1);
        exercises.add(exercise2);
    }

    public static ExerciseRepository getInstance()
    {
        if (instance == null) instance = new ExerciseRepository();
        return instance;
    }

    @Override
    public void add(Exercise object) {
        exercises.add(object);
    }

    @Override
    public void update(Exercise object) {
        exercises.remove(object);
        exercises.add(object);
    }

    @Override
    public void delete(Exercise object) {
        exercises.remove(object);
    }

    @Override
    public ArrayList<Exercise> getAll() {
        return new ArrayList<>(exercises);
    }
}
