package UI;

import controller.*;
import domain.gym.*;
import domain.persons.Customer;
import domain.persons.Trainer;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;
import java.util.ArrayList;
import java.util.Scanner;

public class UI implements IUi, ISubject{
//    private static UI instance;
//
//    private UI() {}
//    public static UI getInstance()
//    {
//        if (instance == null) instance = new UI();
//        return instance;
//
//    }
//
//    public void showAllEquipmentItems(){
//        EquipmentItemController equipmentItemController = EquipmentItemController.getInstance();
//
//        ArrayList<EquipmentItem> equipmentItems = equipmentItemController.getAll();
//        for(EquipmentItem equipmentItem : equipmentItems)
//        {
//            System.out.println(equipmentItem);
//        }
//    }
//    public void showAllExercises(){
//        ExerciseController exerciseController = ExerciseController.getInstance();
//        ArrayList<Exercise> exercises = exerciseController.getAll();
//        for(Exercise exercise : exercises)
//        {
//            System.out.println(exercise);
//        }
//    }
//    public void showAllSpecialisedRooms()
//    {
//        SpecialisedRoomController specialisedRoomController = SpecialisedRoomController.getInstance();
//        ArrayList<SpecialisedRoom> specialisedRooms = specialisedRoomController.getAll();
//        for(SpecialisedRoom specialisedRoom : specialisedRooms)
//        {
//            System.out.println(specialisedRoom);
//        }
//    }
//
//    public void showAllWorkouts(){
//        WorkoutController workoutController = WorkoutController.getInstance();
//        ArrayList<Workout> workouts = workoutController.getAll();
//        for(Workout workout : workouts)
//        {
//            System.out.println(workout);
//        }
//    }
//
//    public void showAllCustomers() {
//        CustomerController customerController = CustomerController.getInstance();
//        ArrayList<Customer> customers = customerController.getAll();
//        for(Customer customer : customers)
//        {
//            System.out.println(customer);
//        }
//    }
//
//        public void showAllTrainers() {
//        TrainerController trainerController = TrainerController.getInstance();
//        ArrayList<Trainer> trainers = trainerController.getAll();
//        for(Trainer trainer : trainers)
//        {
//            System.out.println(trainer);
//        }
//    }
//
//    public void addCustomer() throws ObjectAlreadyContained {
//        CustomerUI customerUI = CustomerUI.getInstance();
//        customerUI.addCustomer();
//    }
//    public void deleteCustomer() throws ObjectNotContained {
//        CustomerUI customerUI = CustomerUI.getInstance();
//        customerUI.deleteCustomer();
//    }
//
//    public void runUi() throws ObjectAlreadyContained, ObjectNotContained {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println(
//                """
//
//
//
//                        1. See all equipment items
//                        2. See all exercises
//                        3. See all rooms
//                        4. See all workouts
//                        5. See the total budget
//                        6. See all customers
//                        7. See all trainers
//                        8. Add a customer
//                        9. Delete a customer
//                        Please enter your choice (1-9):""");
//        int input = scanner.nextInt();
//        switch(input) {
//            case 1:
//                System.out.println("Equipment items:");
//                showAllEquipmentItems();
//                runUi();
//                break;
//            case 2:
//                System.out.println("Exercises:");
//                showAllExercises();
//                runUi();
//                break;
//            case 3:
//                System.out.println("Rooms:");
//                showAllSpecialisedRooms();
//                runUi();
//                break;
//            case 4:
//                System.out.println("Workouts:");
//                showAllWorkouts();
//                runUi();
//                break;
//            case 5:
//                System.out.println("Budget:");
//                System.out.println("10 euro");
//                runUi();
//                break;
//            case 6:
//                System.out.println("Customers:");
//                showAllCustomers();
//                runUi();
//                break;
//            case 7:
//                System.out.println("Trainers:");
//                showAllTrainers();
//                runUi();
//                break;
//            case 8:
//                addCustomer();
//                runUi();
//                break;
//            case 9:
//                deleteCustomer();
//                runUi();
//                break;
//            default:
//                System.out.println("Sorry, not a valid option.");
//        }
//        scanner.close();
//    }
}

