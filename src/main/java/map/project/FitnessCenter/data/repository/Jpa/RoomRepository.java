package map.project.FitnessCenter.data.repository.Jpa;
import map.project.FitnessCenter.data.model.Room;
import map.project.FitnessCenter.data.repository.intefaces.IRoomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA repository for the Room entity.
 */
public interface RoomRepository extends JpaRepository<Room, Long>, IRoomRepository {

}
