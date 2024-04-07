package map.project.FitnessCenter.service.observers;

import map.project.FitnessCenter.data.model.Trainer;

/**
 * A subject interface for receiving notification from subjects about the deletion of Trainer.
 */
public interface IObserverDeletedTrainer {
    /**
     * Signals that a Trainer has been deleted from the system.
     *
     * @param trainer The Trainer object representing the deleted Trainer
     */
    void trainerDeleted(Trainer trainer);
}
