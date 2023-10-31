package controller;

import domain.gym.Workout;
import domain.persons.Customer;
import repository.inMemoryRepository.CustomerRepository;
import repository.inMemoryRepository.WorkoutRepository;

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
    public void add(Workout object)
    {
        repository.add(object);
    }

    @Override
    public void update(Workout object)
    {
        repository.update(object);
    }

    @Override
    public void delete(Workout object)
    {
        repository.delete(object);
    }
}
