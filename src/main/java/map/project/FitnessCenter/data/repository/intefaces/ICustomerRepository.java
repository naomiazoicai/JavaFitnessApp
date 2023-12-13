package map.project.FitnessCenter.data.repository.intefaces;

import map.project.FitnessCenter.data.model.Customer;
import map.project.FitnessCenter.data.model.Trainer;

public interface ICustomerRepository extends IRepository<Customer, String> {
    void trainerDeleted(Trainer trainer);
}
