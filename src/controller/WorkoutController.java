package controller;

import domain.gym.Workout;
import repository.inMemoryRepository.WorkoutRepository;

public class WorkoutController extends Controller<Workout>
{
    private static WorkoutController instance;

    private WorkoutController()
    {
        super(WorkoutRepository.getInstance());
    }

    public static WorkoutController getInstance()
    {
        if (instance == null) instance = new WorkoutController();
        return instance;
    }
}
