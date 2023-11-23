package dao.interaces;

import domain.persons.Customer;
import domain.persons.Trainer;

import java.util.ArrayList;

public interface ICustomerDao
{
    Boolean usernameInRepo(String username);

    Customer searchByUsername(String username);

    ArrayList<Customer> searchByPartialUsername(String username);

    void trainerDeleted(Trainer trainer);
}
