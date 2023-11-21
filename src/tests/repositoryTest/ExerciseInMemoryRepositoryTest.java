package tests.repositoryTest;

import domain.gym.Exercise;
import org.junit.jupiter.api.Test;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;
import repository.inMemoryRepository.ExerciseInMemoryRepository;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ExerciseInMemoryRepositoryTest {
    private final ExerciseInMemoryRepository exerciseRepository = ExerciseInMemoryRepository.getInstance();

    @Test
    public void testAdd() throws ObjectAlreadyContained {
        // Successful add
        Exercise exercise = new Exercise(3, "Bench Press", "Chest", null, 4, 10);
        exerciseRepository.addEntity(exercise);
        ArrayList<Exercise> exercises = exerciseRepository.getAllEntities();
        assertTrue(exercises.contains(exercise));
        // Already in repo
        assertThrows(ObjectAlreadyContained.class, () -> exerciseRepository.addEntity(exercise));
        // End
        System.out.println("Test add in ExerciseRepo passed, bravo!");
    }

    @Test
    public void testUpdate() throws ObjectAlreadyContained, ObjectNotContained {
        Exercise exercise = new Exercise(4, "Pull-up", "Back", null, 4, 10);
        exerciseRepository.addEntity(exercise);

        exerciseRepository.updateEntity(exercise);

        ArrayList<Exercise> exercises = exerciseRepository.getAllEntities();
        assertTrue(exercises.contains(exercise));
        System.out.println("Test update in ExerciseRepo passed, bravo!");
    }

    @Test
    public void testDelete() throws ObjectAlreadyContained, ObjectNotContained {
        Exercise exercise = new Exercise(5, "Shoulder Press", "Shoulders", null, 4, 10);
        exerciseRepository.addEntity(exercise);

        exerciseRepository.deleteEntity(exercise);

        ArrayList<Exercise> exercises = exerciseRepository.getAllEntities();
        assertFalse(exercises.contains(exercise));
        System.out.println("Test delete in ExerciseRepo passed, bravo!");
    }

    @Test
    public void testGetAll() {
        ArrayList<Exercise> exercises = exerciseRepository.getAllEntities();
        assertNotNull(exercises);
        System.out.println("Test getAll in ExerciseRepo passed, bravo!");
    }
}
