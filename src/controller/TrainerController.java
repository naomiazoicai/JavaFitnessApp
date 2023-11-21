package controller;

import controller.interfaces.observers.IObserverDeletedTrainer;
import controller.interfaces.subjects.ISubjectDeletedTrainer;
import controller.interfaces.ITrainerController;
import domain.persons.Trainer;
import factory.repo.TrainerRepoFactory;
import repository.IRepository;
import repository.RepoTypes;
import repository.exceptions.ObjectNotContained;
import repository.interfaces.ITrainerRepository;

import java.util.ArrayList;


public class TrainerController extends Controller<Trainer> implements ITrainerController, ISubjectDeletedTrainer

{
    private static TrainerController instance;
    private final ITrainerRepository iTrainerRepository;

    private static RepoTypes repoType;

    private TrainerController(IRepository<Trainer> iRepository, ITrainerRepository iTrainerRepository)
    {
        super(iRepository);
        this.iTrainerRepository = iTrainerRepository;
        addObserver(CustomerController.getInstance());
    }

    public static TrainerController getInstance()
    {
        if (instance == null)
        {
            if (repoType == null) throw new RuntimeException("Repo Type not provided!");
            IRepository<Trainer> iRepository = TrainerRepoFactory.buildIRepository(repoType);
            ITrainerRepository iTrainerRepository = TrainerRepoFactory.buildInterface(repoType);
            instance = new TrainerController(iRepository, iTrainerRepository);
        }
        return instance;
    }

    @Override
    public ArrayList<Trainer> searchByPartialKeyName(String keyName)
    {
        return iTrainerRepository.searchByPartialKeyName(keyName);
    }

    @Override
    public Trainer searchByKeyName(String keyName) {
        return iTrainerRepository.searchByKeyName(keyName);
    }

    @Override
    public Boolean keyNameInRepo(String keyName) {
        return iTrainerRepository.keyNameInRepo(keyName);
    }

    @Override
    public void delete(Trainer object) throws ObjectNotContained
    {
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
    public void notifyTrainerDeleted(Trainer trainer)
    {
        for (IObserverDeletedTrainer observer : observerList) observer.updatedTrainerDeleted(trainer);
    }

    public static void setRepoType(RepoTypes newRepoType)
    {
        repoType = newRepoType;
    }
}

