package map.project.FitnessCenter.service.subjects;

import map.project.FitnessCenter.data.model.SubscriptionType;
import map.project.FitnessCenter.service.observers.IObserverDeletedSubscriptionType;

import java.util.ArrayList;

/**
 * A subject interface for notifying observers about the deletion of SubscriptionTypes.
 */
public interface ISubjectDeletedSubscriptionType {

    /**
     * List to store instances of {@code IObserverDeletedSubscriptionType} for observing SubscriptionType deletions.
     */
    ArrayList<IObserverDeletedSubscriptionType> observerList = new ArrayList<>();

    /**
     * Adds an observer to the list for monitoring SubscriptionType deletions.
     *
     * @param observer The observer to be added.
     */
    void addObserver(IObserverDeletedSubscriptionType observer);

    /**
     * Removes an observer from the list.
     *
     * @param observer The observer to be removed.
     */
    void removeObserver(IObserverDeletedSubscriptionType observer);

    /**
     * Notifies all registered observers that a SubscriptionType has been deleted.
     *
     * @param subscriptionType The SubscriptionType object representing the deleted SubscriptionType.
     */
    void notifySubscriptionTypeDeleted(SubscriptionType subscriptionType);
}
