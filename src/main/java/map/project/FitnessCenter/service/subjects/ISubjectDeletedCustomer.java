package map.project.FitnessCenter.service.subjects;

import map.project.FitnessCenter.data.model.Customer;
import map.project.FitnessCenter.service.observers.IObserverDeletedCustomer;


import java.util.ArrayList;

public interface ISubjectDeletedCustomer {
    ArrayList<IObserverDeletedCustomer> observerList = new ArrayList<>();

    void addObserver(IObserverDeletedCustomer observer);

    void removeObserver(IObserverDeletedCustomer observer);

    void notifyCustomerDeleted(Customer customer);
}
