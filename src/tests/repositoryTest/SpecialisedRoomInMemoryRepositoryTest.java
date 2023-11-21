package tests.repositoryTest;

import domain.gym.RoomType;
import domain.gym.SpecialisedRoom;
import org.junit.jupiter.api.Test;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;
import repository.inMemoryRepository.SpecialisedRoomInMemoryRepository;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SpecialisedRoomInMemoryRepositoryTest {
    private final SpecialisedRoomInMemoryRepository specialisedRoomRepository = SpecialisedRoomInMemoryRepository.getInstance();

    @Test
    public void testAdd() throws ObjectAlreadyContained {
        // Successful add
        SpecialisedRoom room = new SpecialisedRoom(3, true, RoomType.cardio, 15);
        specialisedRoomRepository.addEntity(room);
        ArrayList<SpecialisedRoom> specialisedRooms = specialisedRoomRepository.getAllEntities();
        assertTrue(specialisedRooms.contains(room));
        // Already in repo
        assertThrows(ObjectAlreadyContained.class, () -> specialisedRoomRepository.addEntity(room));
        // End
        System.out.println("Test add in SpecialisedRoomRepo passed, bravo!");
    }

    @Test
    public void testUpdate() throws ObjectAlreadyContained, ObjectNotContained {
        SpecialisedRoom room = new SpecialisedRoom(4, true, RoomType.freeWeights, 20);
        specialisedRoomRepository.addEntity(room);

        specialisedRoomRepository.updateEntity(room);

        ArrayList<SpecialisedRoom> specialisedRooms = specialisedRoomRepository.getAllEntities();
        assertTrue(specialisedRooms.contains(room));
        System.out.println("Test update in SpecialisedRoomRepo passed, bravo!");
    }

    @Test
    public void testDelete() throws ObjectAlreadyContained, ObjectNotContained {
        SpecialisedRoom room = new SpecialisedRoom(5, true, RoomType.freeWeights, 25);
        specialisedRoomRepository.addEntity(room);

        specialisedRoomRepository.deleteEntity(room);

        ArrayList<SpecialisedRoom> specialisedRooms = specialisedRoomRepository.getAllEntities();
        assertFalse(specialisedRooms.contains(room));
        System.out.println("Test delete in SpecialisedRoomRepo passed, bravo!");
    }

    @Test
    public void testGetAll() {
        ArrayList<SpecialisedRoom> specialisedRooms = specialisedRoomRepository.getAllEntities();
        assertNotNull(specialisedRooms);
        System.out.println("Test getAll in SpecialisedRoomRepo passed, bravo!");
    }
}
