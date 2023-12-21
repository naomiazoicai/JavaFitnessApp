package map.project.FitnessCenter.service.observers;

import map.project.FitnessCenter.data.model.Customer;

/**
 * A subject interface for receiving notification from subjects about the deletion of Customer.
 */
public interface IObserverDeletedCustomer {
    /**
     * Signals that a customer has been deleted from the system.
     *
     * @param customer The Customer object representing the deleted customer.
     */
    void customerDeleted(Customer customer);
}
