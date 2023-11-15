package controller.interfaces.subjects;

import controller.interfaces.observers.IObserverCustomerSubscriptionAdded;
import domain.money.CustomerSubscription;

import java.util.ArrayList;

public interface ISubjectCustomerSubscriptionAdded {
    ArrayList<IObserverCustomerSubscriptionAdded> observerList = new ArrayList<>();

    void addObserver(IObserverCustomerSubscriptionAdded observer);

    void removeObserver(IObserverCustomerSubscriptionAdded observer);

    void notifyAddedCustomerSubscription(CustomerSubscription customerSubscription);

}
