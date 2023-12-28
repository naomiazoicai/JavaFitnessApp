package map.project.FitnessCenter.data.repository.intefaces;

import map.project.FitnessCenter.data.model.SpecialisedRoom;
import map.project.FitnessCenter.data.model.SubscriptionType;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
/**
 * Repository interface for the SubscriptionType entity.
 */
public interface ISubscriptionTypeRepository extends IRepository<SubscriptionType, String>,
ICustomSubscriptionTypeRepository{
    @Override
    @Query("SELECT sub FROM SubscriptionType sub WHERE :room MEMBER OF sub.accessibleRestrictedRooms")
    Optional<List<SubscriptionType>> getSubscriptionTypesContainingRoom(SpecialisedRoom room);
}
