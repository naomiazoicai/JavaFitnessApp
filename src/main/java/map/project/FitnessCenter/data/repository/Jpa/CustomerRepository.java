package map.project.FitnessCenter.data.repository.Jpa;

import jakarta.transaction.Transactional;
import map.project.FitnessCenter.data.model.Customer;
import map.project.FitnessCenter.data.model.Trainer;
import map.project.FitnessCenter.data.repository.intefaces.ICustomerRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * JPA repository for the Customer entity.
 */
public interface CustomerRepository extends JpaRepository<Customer, String>, ICustomerRepository {
    @Override
    @Modifying
    @Transactional
    @Query("UPDATE Customer c SET c.assignedTrainer = NULL WHERE c.assignedTrainer = :trainer")
    void trainerDeleted(Trainer trainer);
}
