package controller;

import domain.persons.Trainer;
import repository.inMemoryRepository.TrainerRepository;

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
    public void add(Trainer object)
    {
        repository.add(object);
    }

    @Override
    public void update(Trainer object)
    {
        repository.update(object);
    }

    @Override
    public void delete(Trainer object)
    {
        repository.delete(object);
    }
}
