package map.project.FitnessCenter.service.subjects;

import map.project.FitnessCenter.data.model.SubscriptionType;
import map.project.FitnessCenter.service.observers.IObserverDeletedSubscriptionType;

import java.util.ArrayList;

public interface ISubjectDeletedSubscriptionType {
    ArrayList<IObserverDeletedSubscriptionType> observerList = new ArrayList<>();

    void addObserver(IObserverDeletedSubscriptionType observer);

    void removeObserver(IObserverDeletedSubscriptionType observer);

    void notifySubscriptionTypeDeleted(SubscriptionType subscriptionType);
}
