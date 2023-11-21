package repository.databaseRepository;

import dao.CustomerDao;
import dao.interaces.ICustomerDao;
import domain.persons.Customer;
import domain.persons.Trainer;
import repository.DatabaseRepository;
import repository.exceptions.ObjectNotContained;
import repository.interfaces.ICustomerRepository;

import java.util.ArrayList;

public class CustomerDatabaseRepository extends DatabaseRepository<Customer> implements ICustomerRepository
{
    private static CustomerDatabaseRepository instance;

    private final ICustomerDao customerDao;

    public CustomerDatabaseRepository()
    {
        super(CustomerDao.getInstance());
        customerDao = CustomerDao.getInstance();
    }

    public static CustomerDatabaseRepository getInstance()
    {
        if (instance == null) instance = new CustomerDatabaseRepository();
        return instance;
    }

    @Override
    public Boolean keyNameInRepo(String keyName)
    {
        return customerDao.keyNameInRepo(keyName);
    }

    @Override
    public ArrayList<Customer> searchByPartialKeyName(String keyName)
    {
        return customerDao.searchByPartialKeyName(keyName);
    }

    @Override
    public Customer searchByKeyName(String keyName)
    {
        return customerDao.searchByKeyName(keyName);
    }

    @Override
    public Trainer changeAssignedTrainerOfCustomer(Customer customer, Trainer trainer) throws ObjectNotContained
    {
        // TODO
        return Trainer.getNullTrainer();
    }

    @Override
    public void trainerDeleted(Trainer trainer)
    {
        customerDao.trainerDeleted(trainer);
    }
}
