package repository.databaseRepository;

import dao.CustomerDao;
import dao.interaces.ICustomerDao;
import domain.persons.Customer;
import domain.persons.Trainer;
import repository.DatabaseRepository;
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
    public boolean usernameInRepo(String username)
    {
        return customerDao.usernameInRepo(username);
    }

    @Override
    public ArrayList<Customer> searchByPartialUsername(String username)
    {
        return customerDao.searchByPartialUsername(username);
    }

    @Override
    public Customer searchByUsername(String username)
    {
        return customerDao.searchByUsername(username);
    }

    @Override
    public Trainer changeAssignedTrainerOfCustomer(Customer customer, Trainer trainer)
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
