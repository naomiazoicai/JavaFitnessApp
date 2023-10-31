package repository.inMemoryRepository;

import domain.persons.Gender;
import domain.persons.Trainer;
import repository.IRepository;

import java.time.LocalDate;
import java.util.ArrayList;

public class TrainerRepository implements IRepository<Trainer> {
    private final ArrayList<Trainer> trainers;

    private static TrainerRepository instance;

    private TrainerRepository()
    {
        trainers = new ArrayList<>();
        Trainer trainer1 = new Trainer("bgy99", "BogdanTrainer", LocalDate.of(1995, 1, 1), Gender.male);
        Trainer trainer2 = new Trainer("bgyClone", "BogdanTrainerClone", LocalDate.of(1995, 1, 1), Gender.male);
        trainers.add(trainer1);
        trainers.add(trainer2);
    }

    public TrainerRepository getInstance()
    {
        if (instance == null) instance = new TrainerRepository();
        return instance;
    }

    @Override
    public void add(Trainer object) {
        trainers.add(object);
    }

    @Override
    public void update(Trainer object) {
        trainers.remove(object);
        trainers.add(object);
    }

    @Override
    public void delete(Trainer object) {
        trainers.remove(object);
    }

    @Override
    public ArrayList<Trainer> getAll() {
        return new ArrayList<>(trainers);
    }
}
