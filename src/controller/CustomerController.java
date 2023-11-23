package controller;

import controller.interfaces.ICustomerController;
import controller.interfaces.ICustomerSubscriptionController;
import controller.interfaces.observers.IObserverDeletedTrainer;
import domain.persons.Customer;
import domain.persons.Trainer;
import factory.repo.CustomerRepoFactory;
import repository.IRepository;
import repository.RepoTypes;
import repository.exceptions.ObjectNotContained;
import repository.interfaces.ICustomerRepository;

import java.util.ArrayList;


public class CustomerController extends Controller<Customer> implements ICustomerController, IObserverDeletedTrainer
{
    private static CustomerController instance;
    private static RepoTypes repoType; // Must be set before getInstance()
    private final ICustomerRepository iCustomerRepository;

    private CustomerController(IRepository<Customer> iRepository, ICustomerRepository iCustomerRepository)
    {
        super(iRepository);
        this.iCustomerRepository = iCustomerRepository;
    }

    public static CustomerController getInstance()
    {
        if (instance == null)
        {
            if (repoType == null) throw new RuntimeException("Repo Type not provided!");
            IRepository<Customer> iRepository = CustomerRepoFactory.buildIRepository(repoType);
            ICustomerRepository iCustomerRepository = CustomerRepoFactory.buildInterface(repoType);
            instance = new CustomerController(iRepository, iCustomerRepository);
        }
        return instance;
    }

    @Override
    public ArrayList<Customer> searchByPartialKeyName(String keyName)
    {
        return iCustomerRepository.searchByPartialUsername(keyName);
    }

    @Override
    public Boolean keyNameInRepo(String username)
    {
        return iCustomerRepository.usernameInRepo(username);
    }

    @Override
    public Boolean trainerUsernameInRepo(String username)
    {
        return TrainerController.getInstance().usernameInRepo(username);
    }

    @Override
    public Customer searchByKeyName(String keyName) {
        return iCustomerRepository.searchByUsername(keyName);
    }

    @Override
    public Trainer changeAssignedTrainerOfCustomer(Customer customer, Trainer trainer) throws ObjectNotContained
    {
        return iCustomerRepository.changeAssignedTrainerOfCustomer(customer, trainer);
    }

    @Override
    public Trainer getTrainerByUsername(String username)
    {
        return TrainerController.getInstance().searchByUsername(username);
    }

    @Override
    public void updatedTrainerDeleted(Trainer trainer) {
        iCustomerRepository.trainerDeleted(trainer);
    }

    @Override
    public boolean hasValidSubscription(String username)
    {
        ICustomerSubscriptionController customerSubscriptionController = CustomerSubscriptionController.getInstance();
        Customer customer = iCustomerRepository.searchByUsername(username);
        return customerSubscriptionController.hasValidSubscription(customer);
    }

    public static void setRepoType(RepoTypes newRepoType)
    {
        repoType = newRepoType;
    }
}
