package repository.inMemoryRepository;

import java.util.ArrayList;

import domain.gym.Exercise;
import domain.gym.SpecialisedRoom;
import domain.gym.Workout;
import repository.IRepository;

public class WorkoutRepository implements IRepository<Workout>
{
    private final ArrayList<Workout> workouts;

    private static WorkoutRepository instance;

    private WorkoutRepository()
    {
        workouts = new ArrayList<>();
        // Get exercises and rooms
        ExerciseRepository exerciseRepository = ExerciseRepository.getInstance();
        ArrayList<Exercise> exercises = exerciseRepository.getAll();
        SpecialisedRoomRepository specialisedRoomRepository = SpecialisedRoomRepository.getInstance();
        ArrayList<SpecialisedRoom> rooms = specialisedRoomRepository.getAll();
        // Populate repo
        Workout workout1 = new Workout(1, exercises, null);
        Workout workout2 = new Workout(2, exercises, rooms.get(0));
        workouts.add(workout1);
        workouts.add(workout2);
    }

    public static WorkoutRepository getInstance()
    {
        if (instance == null) instance = new WorkoutRepository();
        return instance;
    }

    @Override
    public void add(Workout object) {
        workouts.add(object);
    }

    @Override
    public void update(Workout object) {
        workouts.remove(object);
        workouts.add(object);
    }

    @Override
    public void delete(Workout object) {
        workouts.remove(object);
    }

    @Override
    public ArrayList<Workout> getAll() {
        return new ArrayList<>(workouts);
    }
}
