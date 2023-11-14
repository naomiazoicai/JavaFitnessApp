package tests.controller;

import controller.CustomerController;
import controller.EquipmentItemController;
import domain.gym.EquipmentItem;
import domain.gym.Exercise;
import domain.persons.Customer;
import domain.persons.Gender;
import org.junit.jupiter.api.Test;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;
import repository.inMemoryRepository.ExerciseRepository;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class EquipmentItemControllerTest {
    EquipmentItemController equipmentItemController = EquipmentItemController.getInstance();
    @Test
    void testDelete()
    {
        EquipmentItem item2 = new EquipmentItem(2, "Plate");
        EquipmentItem item3 = new EquipmentItem(3, "Dumbbell");
        // Remove equipment item with not existing id
        assertThrows(Exception.class, () -> {
            equipmentItemController.delete(item3);
        });
        // Check if Equipment item2 exists
        ExerciseRepository exerciseRepository = ExerciseRepository.getInstance();
        ArrayList<Exercise> exerciseArrayList = exerciseRepository.getAll();
        boolean exists = false;
        for (Exercise exercise : exerciseArrayList)
        {
            if (exercise.getEquipmentUsed().equals(item2)) {
                exists = true;
                break;
            }
        }
        assertTrue(exists);
        // Remove equipment item with existing id
        try {
            equipmentItemController.delete(item2);
        } catch (ObjectNotContained e) {
            throw new RuntimeException(e);
        }
        // Check observer pattern. Item 2 should not exist
        exerciseArrayList = exerciseRepository.getAll();
        for (Exercise exercise : exerciseArrayList)
        {
            assertNotEquals(exercise.getEquipmentUsed(), item2);
        }
    }
}
