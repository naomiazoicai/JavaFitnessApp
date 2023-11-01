package repository.inMemoryRepository;

import java.util.ArrayList;

import domain.gym.Exercise;
import domain.gym.SpecialisedRoom;
import domain.gym.Workout;
import repository.IRepository;
import repository.Repository;

public class WorkoutRepository extends Repository<Workout>
{
    private static WorkoutRepository instance;

    private WorkoutRepository()
    {
        // Get exercises and rooms
        ExerciseRepository exerciseRepository = ExerciseRepository.getInstance();
        ArrayList<Exercise> exercises = exerciseRepository.getAll();
        SpecialisedRoomRepository specialisedRoomRepository = SpecialisedRoomRepository.getInstance();
        ArrayList<SpecialisedRoom> rooms = specialisedRoomRepository.getAll();
        // Populate repo
        Workout workout1 = new Workout(1, exercises, null);
        Workout workout2 = new Workout(2, exercises, rooms.get(0));
        arrayList.add(workout1);
        arrayList.add(workout2);
    }

    public static WorkoutRepository getInstance()
    {
        if (instance == null) instance = new WorkoutRepository();
        return instance;
    }
}
