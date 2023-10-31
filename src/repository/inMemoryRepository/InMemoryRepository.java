package repository.inMemoryRepository;

import domain.gym.*;
import domain.money.Budget;
import domain.money.CustomerSubscription;
import domain.money.SubscriptionType;
import domain.persons.Customer;
import domain.persons.Gender;
import domain.persons.Trainer;

import java.time.LocalDate;
import java.util.ArrayList;

public class InMemoryRepository
{
    // Gym
    ArrayList<EquipmentItem> equipmentItems = new ArrayList<EquipmentItem>();
    ArrayList<Exercise> exercises = new ArrayList<Exercise>();
    ArrayList<SpecialisedRoom> specialisedRooms = new ArrayList<SpecialisedRoom>();
    ArrayList<Workout> workouts = new ArrayList<Workout>();
    // Budget
    Budget budget = Budget.getInstance();
    ArrayList<CustomerSubscription> customerSubscriptions = new ArrayList<CustomerSubscription>();
    ArrayList<SubscriptionType> subscriptionTypes = new ArrayList<SubscriptionType>();
    // Persons
    ArrayList<Customer> customers = new ArrayList<Customer>();
    ArrayList<Trainer> trainers = new ArrayList<Trainer>();

    // Singleton instance
    private static InMemoryRepository instance;
    private InMemoryRepository(){}
    public static InMemoryRepository getInstance()
    {
        if (instance == null) instance = new InMemoryRepository();
        return instance;
    }

    // Methods
    public ArrayList<EquipmentItem> getEquipmentItems()
    {
        EquipmentItem item1 = new EquipmentItem(1, "Plate");
        EquipmentItem item2 = new EquipmentItem(2, "Dumbbell");
        equipmentItems.add(item1);
        equipmentItems.add(item2);
        return equipmentItems;
    }

    public ArrayList<Exercise> getExercises()
    {
        Exercise exercise1 = new Exercise(1, "Squat", "quads", null, 4, 10);
        Exercise exercise2 = new Exercise(2, "Dead-lift", "hamstrings", null, 4, 10);
        exercises.add(exercise1);
        exercises.add(exercise2);
        return exercises;
    }

    public ArrayList<SpecialisedRoom> getSpecialisedRooms()
    {
        SpecialisedRoom room1 = new SpecialisedRoom(1, true, false, "Studio", 10);
        SpecialisedRoom room2 = new SpecialisedRoom(2, true, false, "Studio", 10);
        specialisedRooms.add(room1);
        specialisedRooms.add(room2);
        return specialisedRooms;
    }

    public ArrayList<Workout> getWorkouts()
    {
        ArrayList<Exercise> exercises = getExercises();
        ArrayList<SpecialisedRoom> rooms = getSpecialisedRooms();
        Workout workout1 = new Workout(1, exercises, null);
        Workout workout2 = new Workout(2, exercises, rooms.get(1));
        workouts.add(workout1);
        workouts.add(workout2);
        return workouts;
    }

    public Budget getBudget()
    {
        budget = Budget.getInstance();
        return budget;
    }

    public ArrayList<SubscriptionType> getSubscriptionTypes()
    {
        SubscriptionType subscriptionType1 = new SubscriptionType("Silver", "Basic plan", 100);
        SubscriptionType subscriptionType2 = new SubscriptionType("Diamond", "King", 1000);
        subscriptionTypes.add(subscriptionType1);
        subscriptionTypes.add(subscriptionType2);
        return subscriptionTypes;
    }

    public ArrayList<Customer> getCustomers() {
        Customer customer1 = new Customer("gigiSlay", "gigi", LocalDate.of(2000, 10, 10), Gender.male);
        Customer customer2 = new Customer("swiftie", "taylorSwift", LocalDate.of(1900, 10, 10), Gender.female);
        customers.add(customer1);
        customers.add(customer2);
        return customers;
    }

    public ArrayList<CustomerSubscription> getCustomerSubscriptions()
    {
        ArrayList<Customer> customers = getCustomers();
        CustomerSubscription subscription1 = new CustomerSubscription("Silver", "Basic plan", 100, customers.get(1), LocalDate.now(), LocalDate.now());
        CustomerSubscription subscription2 = new CustomerSubscription("Premium", "King++", 1000, customers.get(0), LocalDate.now(), LocalDate.now());
        customerSubscriptions.add(subscription1);
        customerSubscriptions.add(subscription2);
        return customerSubscriptions;
    }

    public ArrayList<Trainer> getTrainers()
    {
        Trainer trainer1 = new Trainer("bgy99", "BogdanTrainer", LocalDate.of(1995, 1, 1), Gender.male);
        Trainer trainer2 = new Trainer("bgyClone", "BogdanTrainerClone", LocalDate.of(1995, 1, 1), Gender.male);
        trainers.add(trainer1);
        trainers.add(trainer2);
        return trainers;
    }
}

