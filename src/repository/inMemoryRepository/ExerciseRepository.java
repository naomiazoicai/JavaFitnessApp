package repository.inMemoryRepository;

import domain.gym.EquipmentItem;
import domain.gym.Exercise;
import repository.exceptions.ObjectNotContained;
import repository.interfaces.ExerciseRepositoryInterface;
import repository.Repository;

public class ExerciseRepository extends Repository<Exercise> implements ExerciseRepositoryInterface
{
    private static ExerciseRepository instance;

    private int lastId;

    private ExerciseRepository()
    {
        Exercise exercise1 = new Exercise(1, "Squat", "quads", new EquipmentItem(), 4, 10);
        Exercise exercise2 = new Exercise(2, "Dead-lift", "hamstrings", new EquipmentItem(), 4, 10);
        Exercise exercise3 = new Exercise(3, "Dumbbell Squat", "Quadriceps", new EquipmentItem(2, "Dumbbell"), 4, 10);
        arrayList.add(exercise3);
        arrayList.add(exercise2);
        arrayList.add(exercise1);
        lastId = 3;
    }

    public static ExerciseRepository getInstance()
    {
        if (instance == null) instance = new ExerciseRepository();
        return instance;
    }

    @Override
    public Boolean idInRepo(int id) {
        for (Exercise exercise : arrayList)
        {
            if (id == exercise.getId()) return true;
        }
        return false;
    }

    @Override
    public Exercise searchById(int id) throws ObjectNotContained {
        for (Exercise exercise : arrayList)
        {
            if (id == exercise.getId()) return exercise;
        }
        throw new ObjectNotContained();
    }

    @Override
    public int generateNextId() {
        lastId += 1;
        return lastId;
    }

    @Override
    public void equipmentItemDeleted(EquipmentItem removedEquipmentItem) {
        for (Exercise exercise : arrayList)
        {
            if (exercise.getEquipmentUsed().equals(removedEquipmentItem))
            {
                // Set null
                exercise.setEquipmentUsed(new EquipmentItem());
//                try {
//                    update(exercise);
//                } catch (ObjectNotContained e) {
//                    throw new RuntimeException(e);
//                }
            }
        }
    }
}
