package controller;

import domain.gym.Workout;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;
import repository.inMemoryRepository.WorkoutRepository;

import java.util.ArrayList;

public class WorkoutController implements IController<Workout>
{
    private final WorkoutRepository repository;
    private static WorkoutController instance;

    private WorkoutController(WorkoutRepository repository)
    {
        this.repository = repository;
    }

    public static WorkoutController getInstance(WorkoutRepository repository)
    {
        if (instance == null) instance = new WorkoutController(repository);
        return instance;
    }

    public static WorkoutController getInstance()
    {
        if (instance == null) throw new Error("Repository was never provided");
        return instance;
    }

    @Override
    public void add(Workout object) throws ObjectAlreadyContained {
        repository.add(object);
    }

    @Override
    public void update(Workout object) throws ObjectNotContained {
        repository.update(object);
    }

    @Override
    public void delete(Workout object) throws ObjectNotContained {
        repository.delete(object);
    }

    @Override
    public ArrayList<Workout> getAll() {
        return repository.getAll();
    }
}
