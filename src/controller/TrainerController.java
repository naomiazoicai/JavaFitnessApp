package controller;

import domain.persons.Trainer;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;
import repository.inMemoryRepository.TrainerRepository;

import java.util.ArrayList;

public class TrainerController implements IController<Trainer>
{
    private final TrainerRepository repository;
    private static TrainerController instance;

    private TrainerController(TrainerRepository repository)
    {
        this.repository = repository;
    }

    public static TrainerController getInstance(TrainerRepository repository)
    {
        if (instance == null) instance = new TrainerController(repository);
        return instance;
    }

    public static TrainerController getInstance()
    {
        if (instance == null) throw new Error("Repository was never provided");
        return instance;
    }

    @Override
    public void add(Trainer object) throws ObjectAlreadyContained {
        repository.add(object);
    }

    @Override
    public void update(Trainer object) throws ObjectNotContained {
        repository.update(object);
    }

    @Override
    public void delete(Trainer object) throws ObjectNotContained {
        repository.delete(object);
    }

    @Override
    public ArrayList<Trainer> getAll() {
        return repository.getAll();
    }
}
