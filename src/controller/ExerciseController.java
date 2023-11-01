package controller;

import domain.gym.Exercise;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;
import repository.inMemoryRepository.ExerciseRepository;

import java.util.ArrayList;

public class ExerciseController implements IController<Exercise>
{
    private final ExerciseRepository repository;
    private static ExerciseController instance;

    private ExerciseController(ExerciseRepository repository)
    {
        this.repository = repository;
    }

    public static ExerciseController getInstance(ExerciseRepository repository)
    {
        if (instance == null) instance = new ExerciseController(repository);
        return instance;
    }

    public static ExerciseController getInstance()
    {
        if (instance == null) throw new Error("Repository was never provided");
        return instance;
    }

    @Override
    public void add(Exercise object) throws ObjectAlreadyContained {
        repository.add(object);
    }

    @Override
    public void update(Exercise object) throws ObjectNotContained {
        repository.update(object);
    }

    @Override
    public void delete(Exercise object) throws ObjectNotContained {
        repository.delete(object);
    }

    @Override
    public ArrayList<Exercise> getAll() {
        return repository.getAll();
    }
}
