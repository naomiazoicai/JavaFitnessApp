package dao.interaces;

import domain.persons.Customer;
import domain.persons.Trainer;

import java.util.ArrayList;

public interface ICustomerDao
{
    Boolean keyNameInRepo(String keyName);

    Customer searchByKeyName(String keyName);

    ArrayList<Customer> searchByPartialKeyName(String keyName);

    void trainerDeleted(Trainer trainer);
}
