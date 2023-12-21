package map.project.FitnessCenter.service.subjects;

import map.project.FitnessCenter.data.model.Trainer;
import map.project.FitnessCenter.service.observers.IObserverDeletedTrainer;

import java.util.ArrayList;

/**
 * A subject interface for notifying observers about the deletion of Trainers.
 */
public interface ISubjectDeletedTrainer {

    /**
     * List to store instances of {@code IObserverDeletedTrainer} for observing Trainer deletions.
     */
    ArrayList<IObserverDeletedTrainer> observerList = new ArrayList<>();

    /**
     * Adds an observer to the list for monitoring Trainer deletions.
     *
     * @param observer The observer to be added.
     */
    void addObserver(IObserverDeletedTrainer observer);

    /**
     * Removes an observer from the list.
     *
     * @param observer The observer to be removed.
     */
    void removeObserver(IObserverDeletedTrainer observer);

    /**
     * Notifies all registered observers that a Trainer has been deleted.
     *
     * @param trainer The Trainer object representing the deleted Trainer.
     */
    void notifyTrainerDeleted(Trainer trainer);
}
