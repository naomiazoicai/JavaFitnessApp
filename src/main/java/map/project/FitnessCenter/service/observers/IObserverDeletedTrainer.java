package map.project.FitnessCenter.service.observers;

import map.project.FitnessCenter.data.model.Trainer;

public interface IObserverDeletedTrainer {
    void trainerDeleted(Trainer trainer);
}
