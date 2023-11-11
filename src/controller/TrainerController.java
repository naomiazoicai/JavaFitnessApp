package controller;

import controller.interfaces.ITrainerController;
import domain.persons.Trainer;
import repository.inMemoryRepository.TrainerRepository;
import repository.interfaces.ITrainerRepository;

import java.util.ArrayList;


public class TrainerController extends Controller<Trainer> implements ITrainerController,IObserverNewCostumer

{
    private static TrainerController instance;
    private final ITrainerRepository trainerRepository;

    private TrainerController(TrainerRepository trainerRepository)
    {
        super(trainerRepository);
        this.trainerRepository = trainerRepository;
    }

    public static TrainerController getInstance()
    {
        if (instance == null) instance = new TrainerController(TrainerRepository.getInstance());
        return instance;
    }

    @Override
    public void updateNewCustomerAdded() {

    }

    @Override
    public ArrayList<Trainer> searchByPartialKeyName(String keyName) {
        return trainerRepository.searchByPartialKeyName(keyName);
    }

    @Override
    public Trainer searchByKeyName(String keyName) {
        return trainerRepository.searchByKeyName(keyName);
    }

    @Override
    public Boolean keyNameInRepo(String keyName) {
        return trainerRepository.keyNameInRepo(keyName);
    }
}
