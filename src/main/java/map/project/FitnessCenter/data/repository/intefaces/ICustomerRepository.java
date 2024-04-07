package map.project.FitnessCenter.data.repository.intefaces;

import map.project.FitnessCenter.data.model.Customer;
import map.project.FitnessCenter.data.model.Trainer;

/**
 * Interface for the Customer repository, extending the general repository interface.
 */
public interface ICustomerRepository extends IRepository<Customer, String> {
    /**
     * Method to handle the deletion of a trainer.
     *
     * @param trainer The trainer to be deleted.
     */
    void trainerDeleted(Trainer trainer);
}
