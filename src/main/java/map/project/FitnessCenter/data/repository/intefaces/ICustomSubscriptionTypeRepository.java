package map.project.FitnessCenter.data.repository.intefaces;

import map.project.FitnessCenter.data.model.SpecialisedRoom;
import map.project.FitnessCenter.data.model.SubscriptionType;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ICustomSubscriptionTypeRepository {
    Optional<List<SubscriptionType>> getSubscriptionTypesContainingRoom(@Param("room") SpecialisedRoom room);
}
