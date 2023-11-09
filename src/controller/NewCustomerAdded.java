package controller;

import java.util.ArrayList;

public class NewCustomerAdded implements ISubjectNewCustomer{

    ArrayList<IObserverNewCostumer> observerList;

    public NewCustomerAdded() {
        observerList = new ArrayList<IObserverNewCostumer>();
    }

    @Override
    public void registerObserver(IObserverNewCostumer observer) {
        observerList.add(observer);
    }

    @Override
    public boolean removeObserver(IObserverNewCostumer observer) {
        return observerList.remove(observer);
    }

    @Override
    public void notifyNewCustomerAdded() {

    }
}
