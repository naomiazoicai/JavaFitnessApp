package controller;

import controller.interfaces.ICustomerController;
import controller.interfaces.ICustomerSubscriptionController;
import controller.interfaces.IObserverDeletedTrainer;
import controller.interfaces.ISubjectDeletedTrainer;
import domain.persons.Customer;
import domain.persons.Person;
import domain.persons.Trainer;
import repository.exceptions.ObjectNotContained;
import repository.inMemoryRepository.CustomerRepository;
import repository.interfaces.ICustomerRepository;

import java.util.ArrayList;


public class CustomerController extends Controller<Customer> implements ICustomerController, IObserverDeletedTrainer
{
    private static CustomerController instance;

    private final ICustomerRepository ICustomerRepository;

    private CustomerController(CustomerRepository customerRepository)
    {
        super(customerRepository);
        ICustomerRepository = customerRepository;
    }

    public static CustomerController getInstance()
    {
        if (instance == null) instance = new CustomerController(CustomerRepository.getInstance());
        return instance;
    }

    @Override
    public ArrayList<Customer> searchByPartialKeyName(String keyName)
    {
        return ICustomerRepository.searchByPartialKeyName(keyName);
    }

    @Override
    public Boolean keyNameInRepo(String keyName)
    {
        return ICustomerRepository.keyNameInRepo(keyName);
    }

    @Override
    public Boolean trainerUsernameInRepo(String username)
    {
        TrainerController trainerController = TrainerController.getInstance();
        return trainerController.keyNameInRepo(username);
    }

    @Override
    public Customer searchByKeyName(String keyName) {
        return ICustomerRepository.searchByKeyName(keyName);
    }

    @Override
    public Trainer changeAssignedTrainerOfCustomer(Customer customer, Trainer trainer) throws ObjectNotContained {
        return ICustomerRepository.changeAssignedTrainerOfCustomer(customer, trainer);
    }

    @Override
    public Trainer getTrainerByUsername(String username) {
        TrainerController trainerController = TrainerController.getInstance();
        return trainerController.searchByKeyName(username);
    }

    @Override
    public void updatedTrainerDeleted(Trainer trainer) {
        ICustomerRepository.trainerDeleted(trainer);
    }

    @Override
    public boolean hasValidSubscription(String username) {
        ICustomerSubscriptionController customerSubscriptionController = CustomerSubscriptionController.getInstance();
        Customer customer = ICustomerRepository.searchByKeyName(username);
        return customerSubscriptionController.hasValidSubscription(customer);
    }
}
