package controller.interfaces.subjects;

import controller.interfaces.observers.IObserverDeletedTrainer;
import domain.persons.Trainer;

import java.util.ArrayList;

public interface ISubjectDeletedTrainer {
    ArrayList<IObserverDeletedTrainer> observerList = new ArrayList<>();

    void addObserver(IObserverDeletedTrainer observer);

    void removeObserver(IObserverDeletedTrainer observer);

    void notifyTrainerDeleted(Trainer trainer);
}
