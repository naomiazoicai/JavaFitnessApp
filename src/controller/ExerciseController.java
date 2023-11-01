package controller;

import domain.gym.Exercise;
import repository.inMemoryRepository.ExerciseRepository;

public class ExerciseController extends Controller<Exercise>
{
    private static ExerciseController instance;

    private ExerciseController()
    {
        super(ExerciseRepository.getInstance());
    }

    public static ExerciseController getInstance()
    {
        if (instance == null) instance = new ExerciseController();
        return instance;
    }
}
