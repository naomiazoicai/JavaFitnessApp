package map.project.FitnessCenter.service.interfaces;

import map.project.FitnessCenter.data.model.Trainer;

public interface ITrainerService {
    Trainer getTrainerByUsername(String username);
}
