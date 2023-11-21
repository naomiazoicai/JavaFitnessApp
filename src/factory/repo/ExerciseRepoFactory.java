package factory.repo;

import domain.gym.Exercise;
import repository.IRepository;
import repository.RepoTypes;
import repository.databaseRepository.ExerciseDatabaseRepository;
import repository.inMemoryRepository.ExerciseInMemoryRepository;
import repository.interfaces.IExerciseRepository;

public class ExerciseRepoFactory
{
    public static IRepository<Exercise> buildIRepository(RepoTypes repoType)
    {
        return switch (repoType)
        {
            case inMemory -> ExerciseInMemoryRepository.getInstance();
            case database -> ExerciseDatabaseRepository.getInstance();
        };
    }

    public static IExerciseRepository buildInterface(RepoTypes repoType)
    {
        return switch (repoType)
        {
            case inMemory -> ExerciseInMemoryRepository.getInstance();
            case database -> ExerciseDatabaseRepository.getInstance();
        };
    }
}
