package map.project.FitnessCenter.data.repository.Jpa;

import jakarta.transaction.Transactional;
import map.project.FitnessCenter.data.model.Customer;
import map.project.FitnessCenter.data.model.Subscription;
import map.project.FitnessCenter.data.model.SubscriptionType;
import map.project.FitnessCenter.data.repository.intefaces.ISubscriptionRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
/**
 * JPA repository for the Subscription entity.
 */
public interface SubscriptionRepository extends JpaRepository<Subscription, Long>, ISubscriptionRepository {
    @Override
    @Modifying
    @Transactional
    @Query("UPDATE Subscription s SET s.customer = NULL WHERE s.customer = :customer")
    void updateCustomerDeleted(@Param("customer") Customer customer);

    @Override
    @Modifying
    @Transactional
    @Query("UPDATE Subscription s SET s.subscriptionType = NULL WHERE s.subscriptionType = :subscriptionType")
    void updateSubscriptionTypeDeleted(@Param("subscriptionType") SubscriptionType subscriptionType);
}
