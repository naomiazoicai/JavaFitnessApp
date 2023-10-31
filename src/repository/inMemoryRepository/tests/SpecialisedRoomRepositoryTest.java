package repository.inMemoryRepository.tests;

import domain.gym.SpecialisedRoom;
import org.junit.jupiter.api.Test;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;
import repository.inMemoryRepository.SpecialisedRoomRepository;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SpecialisedRoomRepositoryTest {
    private final SpecialisedRoomRepository specialisedRoomRepository = SpecialisedRoomRepository.getInstance();

    @Test
    public void testAdd() throws ObjectAlreadyContained {
        // Successful add
        SpecialisedRoom room = new SpecialisedRoom(3, true, false, "Cardio Room", 15);
        specialisedRoomRepository.add(room);
        ArrayList<SpecialisedRoom> specialisedRooms = specialisedRoomRepository.getAll();
        assertTrue(specialisedRooms.contains(room));
        // Already in repo
        assertThrows(ObjectAlreadyContained.class, () -> specialisedRoomRepository.add(room));
        // End
        System.out.println("Test add in SpecialisedRoomRepo passed, bravo!");
    }

    @Test
    public void testUpdate() throws ObjectAlreadyContained, ObjectNotContained {
        SpecialisedRoom room = new SpecialisedRoom(4, true, false, "Yoga Room", 20);
        specialisedRoomRepository.add(room);

        specialisedRoomRepository.update(room);

        ArrayList<SpecialisedRoom> specialisedRooms = specialisedRoomRepository.getAll();
        assertTrue(specialisedRooms.contains(room));
        System.out.println("Test update in SpecialisedRoomRepo passed, bravo!");
    }

    @Test
    public void testDelete() throws ObjectAlreadyContained, ObjectNotContained {
        SpecialisedRoom room = new SpecialisedRoom(5, true, false, "Weightlifting Room", 25);
        specialisedRoomRepository.add(room);

        specialisedRoomRepository.delete(room);

        ArrayList<SpecialisedRoom> specialisedRooms = specialisedRoomRepository.getAll();
        assertFalse(specialisedRooms.contains(room));
        System.out.println("Test delete in SpecialisedRoomRepo passed, bravo!");
    }

    @Test
    public void testGetAll() {
        ArrayList<SpecialisedRoom> specialisedRooms = specialisedRoomRepository.getAll();
        assertNotNull(specialisedRooms);
        System.out.println("Test getAll in SpecialisedRoomRepo passed, bravo!");
    }
}
