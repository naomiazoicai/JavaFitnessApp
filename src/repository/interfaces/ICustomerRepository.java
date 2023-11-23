package repository.interfaces;

import domain.persons.Customer;
import domain.persons.Trainer;
import repository.exceptions.ObjectNotContained;

import java.util.ArrayList;

public interface ICustomerRepository {
    Trainer changeAssignedTrainerOfCustomer(Customer customer, Trainer trainer) throws ObjectNotContained;

    void trainerDeleted(Trainer trainer);

    boolean usernameInRepo(String username);

    ArrayList<Customer> searchByPartialUsername(String username);

    Customer searchByUsername(String username);
}
