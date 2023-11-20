package controller;

import controller.interfaces.observers.IObserverDeletedTrainer;
import controller.interfaces.subjects.ISubjectDeletedTrainer;
import controller.interfaces.ITrainerController;
import domain.persons.Trainer;
import repository.exceptions.ObjectNotContained;
import repository.inMemoryRepository.TrainerRepository;
import repository.interfaces.ITrainerRepository;

import java.util.ArrayList;


public class TrainerController extends Controller<Trainer> implements ITrainerController, ISubjectDeletedTrainer

{
    private static TrainerController instance;
    private final ITrainerRepository trainerRepository;

    private TrainerController(TrainerRepository trainerRepository)
    {
        super(trainerRepository);
        this.trainerRepository = trainerRepository;
        addObserver(CustomerController.getInstance());
    }

    public static TrainerController getInstance()
    {
        if (instance == null) instance = new TrainerController(TrainerRepository.getInstance());
        return instance;
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

    @Override
    public void delete(Trainer object) throws ObjectNotContained {
        notifyTrainerDeleted(object);
        super.delete(object);
    }

    @Override
    public void addObserver(IObserverDeletedTrainer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(IObserverDeletedTrainer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyTrainerDeleted(Trainer trainer) {
        for (IObserverDeletedTrainer observer : observerList) observer.updatedTrainerDeleted(trainer);
    }
}

