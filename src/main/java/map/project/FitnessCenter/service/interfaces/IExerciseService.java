package map.project.FitnessCenter.service.interfaces;

import map.project.FitnessCenter.data.model.Exercise;

import java.util.List;
import java.util.Optional;

public interface IExerciseService {
    Optional<List<Exercise>> getByName(String name);
}
