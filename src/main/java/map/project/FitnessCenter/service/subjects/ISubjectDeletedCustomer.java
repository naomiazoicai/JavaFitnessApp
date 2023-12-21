package map.project.FitnessCenter.service.subjects;

import map.project.FitnessCenter.data.model.Customer;
import map.project.FitnessCenter.service.observers.IObserverDeletedCustomer;


import java.util.ArrayList;

/**
 * A subject interface for notifying observers about the deletion of Customer.
 */
public interface ISubjectDeletedCustomer {
    /**
     * A list to store instances of {@code IObserverDeletedCustomer} for observing customer deletions.
     */
    ArrayList<IObserverDeletedCustomer> observerList = new ArrayList<>();

    /**
     * Adds an observer to the list for monitoring customer deletions.
     *
     * @param observer The observer to be added.
     */
    void addObserver(IObserverDeletedCustomer observer);

    /**
     * Removes an observer from the list.
     *
     * @param observer The observer to be removed.
     */
    void removeObserver(IObserverDeletedCustomer observer);

    /**
     * Notifies all registered observers that a customer has been deleted.
     *
     * @param customer The Customer object representing the deleted customer.
     */
    void notifyCustomerDeleted(Customer customer);

}
