package controller;

import java.util.ArrayList;

public interface ISubjectNewCustomer {
    ArrayList<IObserverNewCostumer> observerList = new ArrayList<>();
    void registerObserver(IObserverNewCostumer observer);
    boolean removeObserver(IObserverNewCostumer observer);
    void notifyNewCustomerAdded();
}
