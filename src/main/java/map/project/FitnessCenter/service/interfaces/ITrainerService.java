package map.project.FitnessCenter.service.interfaces;

import map.project.FitnessCenter.data.model.Trainer;

/**
 * An interface defining operations related to the Trainer objects.
 */
public interface ITrainerService {

    /**
     * Retrieves a Trainer object based on the provided username.
     *
     * @param username The username associated with the Trainer to be retrieved.
     * @return The Trainer object corresponding to the given username, or null if not found.
     */
    Trainer getTrainerByUsername(String username);
}
