package UI;

import domain.gym.*;
import domain.money.Budget;
import domain.persons.Customer;
import domain.persons.Trainer;
import repository.inMemoryRepository.InMemoryRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class UI implements IUi, ISubject{
    private final InMemoryRepository repository;
    private static UI instance;

    private UI(InMemoryRepository repository)
    {
        this.repository = repository;
    }
    public static UI getInstance(InMemoryRepository repository)
    {
        if (instance == null) instance = new UI(repository);
        return instance;

    }

    public void showAllEquipmentItems(){
        ArrayList<EquipmentItem> equipmentItems = repository.getEquipmentItems();
        for(EquipmentItem equipmentItem : equipmentItems)
        {
            System.out.println(equipmentItem);
        }
    }
    public void showAllExercises(){
        ArrayList<Exercise> exercises = repository.getExercises();
        for(Exercise exercise : exercises)
        {
            System.out.println(exercise);
        }
    }
    public void showAllSpecialisedRooms(){
        ArrayList<SpecialisedRoom> specialisedRooms = repository.getSpecialisedRooms();
        for(SpecialisedRoom specialisedRoom : specialisedRooms)
        {
            System.out.println(specialisedRooms);
        }
    }

    public void showAllWorkouts(){
        ArrayList<Workout> workouts = repository.getWorkouts();
        for(Workout workout : workouts)
        {
            System.out.println(workouts);
        }
    }

    public void showBudget(){
        Budget budget = repository.getBudget();
   }
    public void showAllCustomers() {
        ArrayList<Customer> customers = repository.getCustomers();
        for(Customer customer : customers)
        {
            System.out.println(customer);
        }
    }
        public void showAllTrainers() {
        ArrayList<Trainer> trainers = repository.getTrainers();
        for(Trainer trainer : trainers)
        {
            System.out.println(trainers);
        }
    }
    public void runUi(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                """



                        1. See all equipment items
                        2. See all exercises
                        3. See all rooms
                        4. See all workouts
                        5. See the total budget
                        6. See all customers
                        7. See all trainers
                        Please enter your choice (1-7):""");
        int input = scanner.nextInt();
        switch(input) {
            case 1:
                System.out.println("Equipment items:");
                showAllEquipmentItems();
                runUi();
                break;
            case 2:
                System.out.println("Exercises:");
                showAllExercises();
                runUi();
                break;
            case 3:
                System.out.println("Rooms:");
                showAllSpecialisedRooms();
                runUi();
                break;
            case 4:
                System.out.println("Workouts:");
                showAllWorkouts();
                runUi();
                break;
            case 5:
                System.out.println("Budget:");
                showBudget();
                runUi();
                break;
            case 6:
                System.out.println("Customers:");
                showAllCustomers();
                runUi();
                break;
            case 7:
                System.out.println("Trainers:");
                showAllTrainers();
                runUi();
                break;
            default:
                System.out.println("bravo, Naomiiiiiiiiiii");
        }
        scanner.close();
    }
}

