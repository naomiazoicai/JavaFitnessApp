package controller;

public interface ISubjectNewCustomer {
    void registerObserver(IObserverNewCostumer observer);
    boolean removeObserver(IObserverNewCostumer observer);
    void notifyNewCustomerAdded();
}
