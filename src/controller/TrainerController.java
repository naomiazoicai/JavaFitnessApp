package controller;

import domain.persons.Trainer;
import repository.inMemoryRepository.TrainerRepository;


public class TrainerController extends Controller<Trainer> implements IObserverNewCostumer

{
    private static TrainerController instance;

    private TrainerController()
    {
        super(TrainerRepository.getInstance());
    }

    public static TrainerController getInstance()
    {
        if (instance == null) instance = new TrainerController();
        return instance;
    }

    @Override
    public void updateNewCustomerAdded() {

    }
}
