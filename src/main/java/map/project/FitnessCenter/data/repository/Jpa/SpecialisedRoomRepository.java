package map.project.FitnessCenter.data.repository.Jpa;

import map.project.FitnessCenter.data.model.SpecialisedRoom;
import map.project.FitnessCenter.data.repository.intefaces.ISpecialisedRoomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * JPA repository for the SpecialisedRoom entity.
 */
public interface SpecialisedRoomRepository extends JpaRepository<SpecialisedRoom, Long>, ISpecialisedRoomRepository {
}
