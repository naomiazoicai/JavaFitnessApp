package map.project.FitnessCenter.data.repository.intefaces;

import map.project.FitnessCenter.data.model.SpecialisedRoom;
import map.project.FitnessCenter.data.model.SubscriptionType;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Custom repository interface for SubscriptionType, providing additional query methods.
 */
public interface ICustomSubscriptionTypeRepository {
    /**
     * Get subscription types containing a specific room.
     *
     * @param room The room to search for.
     * @return Optional list of subscription types containing the specified room.
     */
    Optional<List<SubscriptionType>> getSubscriptionTypesContainingRoom(@Param("room") SpecialisedRoom room);
}
