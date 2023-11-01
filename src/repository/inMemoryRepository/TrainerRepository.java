package repository.inMemoryRepository;

import domain.persons.Gender;
import domain.persons.Trainer;
import repository.Repository;

import java.time.LocalDate;

public class TrainerRepository extends Repository<Trainer>
{
    private static TrainerRepository instance;

    private TrainerRepository()
    {
        Trainer trainer1 = new Trainer("bgy99", "BogdanTrainer", LocalDate.of(1995, 1, 1), Gender.male);
        Trainer trainer2 = new Trainer("bgyClone", "BogdanTrainerClone", LocalDate.of(1995, 1, 1), Gender.male);
        arrayList.add(trainer1);
        arrayList.add(trainer2);
    }

    public static TrainerRepository getInstance()
    {
        if (instance == null) instance = new TrainerRepository();
        return instance;
    }
}
