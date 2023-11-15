package controller.interfaces;

import domain.money.SubscriptionType;

import java.util.ArrayList;

public interface ISubjectDeletedSubscriptionType {
    ArrayList<IObserverDeletedSubscriptionType> observerList = new ArrayList<>();

    void addObserver(IObserverDeletedSubscriptionType observer);

    void removeObserver(IObserverDeletedSubscriptionType observer);

    void notifySubscriptionTypeDeleted(SubscriptionType subscriptionType);
}
