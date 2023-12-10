package map.project.FitnessCenter.service.subjects;

import map.project.FitnessCenter.data.model.Trainer;
import map.project.FitnessCenter.service.observers.IObserverDeletedTrainer;

import java.util.ArrayList;

public interface ISubjectDeletedTrainer {
    ArrayList<IObserverDeletedTrainer> observerList = new ArrayList<>();
    void addObserver(IObserverDeletedTrainer observer);

    void removeObserver(IObserverDeletedTrainer observer);

    void notifyTrainerDeleted(Trainer trainer);
}
