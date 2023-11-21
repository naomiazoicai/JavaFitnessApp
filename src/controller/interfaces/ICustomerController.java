package controller.interfaces;

import domain.persons.Customer;
import domain.persons.Person;
import domain.persons.Trainer;
import repository.exceptions.ObjectNotContained;


public interface ICustomerController extends NameIdentifiedEntitiesController<Customer>
{
    Trainer changeAssignedTrainerOfCustomer(Customer customer, Trainer trainer) throws ObjectNotContained;

    Boolean trainerUsernameInRepo(String username);

    Trainer getTrainerByUsername(String username);

    boolean hasValidSubscription(String username);
}
