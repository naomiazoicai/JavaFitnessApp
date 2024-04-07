package map.project.FitnessCenter.service.interfaces;

import map.project.FitnessCenter.data.model.Exercise;

import java.util.List;
import java.util.Optional;

/**
 * An interface defining operations related to the Exercise objects.
 */
public interface IExerciseService {
    /**
     * * Gets an Exercise from the repository identified with given name.
     *
     * @param name The name field of the entity to be searched.
     * @return An optional containing the searched entity or null if it was not found
     */
    Optional<List<Exercise>> getByName(String name);
}
