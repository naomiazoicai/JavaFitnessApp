package map.project.FitnessCenter.service.observers;

import map.project.FitnessCenter.data.model.Customer;

public interface IObserverDeletedCustomer {
    void customerDeleted(Customer customer);
}
