package controller.interfaces;

import domain.persons.Customer;
import domain.persons.Trainer;
import repository.exceptions.ObjectNotContained;

import java.util.ArrayList;


public interface ICustomerController {
    Trainer changeAssignedTrainerOfCustomer(Customer customer, Trainer trainer) throws ObjectNotContained;

    Boolean trainerUsernameInRepo(String username);

    Trainer getTrainerByUsername(String username);

    boolean hasValidSubscription(String username);

    ArrayList<Customer> searchByPartialKeyName(String keyName);

    Customer searchByKeyName(String keyName);

    Boolean keyNameInRepo(String keyName);
}
