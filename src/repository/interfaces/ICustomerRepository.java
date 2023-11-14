package repository.interfaces;

import domain.persons.Customer;
import domain.persons.Trainer;
import repository.exceptions.ObjectNotContained;

public interface ICustomerRepository extends NameIdentifiedEntitiesRepository<Customer> {
    Trainer changeAssignedTrainerOfCustomer(Customer customer, Trainer trainer) throws ObjectNotContained;

    void trainerDeleted(Trainer trainer);
}
