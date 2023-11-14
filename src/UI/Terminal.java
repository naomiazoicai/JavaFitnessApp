package UI;

import domain.gym.RoomType;
import domain.persons.Gender;
import domain.persons.TrainerSpecialization;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Terminal
{
    private static Terminal instance;

    private final Scanner scanner;

    private Terminal(){
        scanner = new Scanner(System.in);
    }

    public static Terminal getInstance()
    {
        if (instance == null) instance = new Terminal();
        return instance;
    }

    // Run UI
    public void pressEnterToContinue()
    {
        System.out.println("Press enter to continue...");
        scanner.nextLine();
    }

    public String mainUiMenu()
    {
        System.out.println("Choose an action: ");
        System.out.println("1. Budget");
        System.out.println("2. Customer subscription");
        System.out.println("3. Customer");
        System.out.println("4. Equipment item");
        System.out.println("5. Exercise");
        System.out.println("6. Specialised Room");
        System.out.println("7. Subscription type");
        System.out.println("8. Trainer");
        System.out.println("x. <--- Close app");
        System.out.println("Your choice: ");
        String choice = scanner.nextLine();
        while (!Objects.equals(choice, "1") && !Objects.equals(choice, "2")  && !Objects.equals(choice, "3")
                && !Objects.equals(choice, "4") && !Objects.equals(choice, "5") && !Objects.equals(choice, "6")
                && !Objects.equals(choice, "7") && !Objects.equals(choice, "8") && !Objects.equals(choice, "x")) {
            System.out.println("Enter a valid choice (1-8)");
            System.out.println("Your choice: ");
            choice = scanner.nextLine();
        }
        return choice;
    }
    public String customerUiMenu()
    {
        System.out.println("Choose an action: ");
        System.out.println("1. Add customer");
        System.out.println("2. Update customer");
        System.out.println("3. Delete customer");
        System.out.println("4. Search customer by username");
        System.out.println("5. Assign trainer to user");
        System.out.println("6. Check user subscription validity");
        System.out.println("7. Show all customers");
        System.out.println("X. <-- Return to main menu");
        System.out.println("Your choice: ");
        String choice = scanner.nextLine();
        while (!Objects.equals(choice, "1") && !Objects.equals(choice, "2")  && !Objects.equals(choice, "3")
                && !Objects.equals(choice, "4") && !Objects.equals(choice, "5") && !Objects.equals(choice, "6")
                && !Objects.equals(choice, "7") && !Objects.equals(choice, "x") && !Objects.equals(choice, "X")) {
            System.out.println("Enter a valid choice (1-7) | X for exit");
            System.out.println("Your choice: ");
            choice = scanner.nextLine();
        }
        return choice;
    }

    public String equipmentItemUiMenu()
    {
        System.out.println("Choose an action: ");
        System.out.println("1. Add equipment item");
        System.out.println("2. Update equipment item");
        System.out.println("3. Delete equipment item");
        System.out.println("4. Search equipment item by id");
        System.out.println("5. Show all equipment items");
        System.out.println("6. <-- Return to main menu");
        System.out.println("Your choice: ");
        String choice = scanner.nextLine();
        while (!Objects.equals(choice, "1") && !Objects.equals(choice, "2")  && !Objects.equals(choice, "3")
                && !Objects.equals(choice, "4") && !Objects.equals(choice, "5") && !Objects.equals(choice, "6")) {
            System.out.println("Enter a valid choice (1-6)");
            System.out.println("Your choice: ");
            choice = scanner.nextLine();
        }
        return choice;
    }

    public String exerciseUiMenu()
    {
        System.out.println("Choose an action: ");
        System.out.println("1. Add exercise");
        System.out.println("2. Update exercise");
        System.out.println("3. Delete exercise");
        System.out.println("4. Search exercise by id");
        System.out.println("5. Show all exercises");
        System.out.println("6. <-- Return to main menu");
        System.out.println("Your choice: ");
        String choice = scanner.nextLine();
        while (!Objects.equals(choice, "1") && !Objects.equals(choice, "2")  && !Objects.equals(choice, "3")
                && !Objects.equals(choice, "4") && !Objects.equals(choice, "5") && !Objects.equals(choice, "6")) {
            System.out.println("Enter a valid choice (1-6)");
            System.out.println("Your choice: ");
            choice = scanner.nextLine();
        }
        return choice;
    }

    public String specialisedRoomUiMenu()
    {
        System.out.println("Choose an action: ");
        System.out.println("1. Add room");
        System.out.println("2. Update room");
        System.out.println("3. Delete room");
        System.out.println("4. Search room by id");
        System.out.println("5. Show all rooms");
        System.out.println("6. <-- Return to main menu");
        System.out.println("Your choice: ");
        String choice = scanner.nextLine();
        while (!Objects.equals(choice, "1") && !Objects.equals(choice, "2")  && !Objects.equals(choice, "3")
                && !Objects.equals(choice, "4") && !Objects.equals(choice, "5") && !Objects.equals(choice, "6")) {
            System.out.println("Enter a valid choice (1-6)");
            System.out.println("Your choice: ");
            choice = scanner.nextLine();
        }
        return choice;
    }

    public String trainerUiMenu()
    {
        System.out.println("Choose an action: ");
        System.out.println("1. Add trainer");
        System.out.println("2. Update trainer");
        System.out.println("3. Delete trainer");
        System.out.println("4. Search trainer by username");
        System.out.println("5. Show all trainers");
        System.out.println("6. <-- Return to main menu");
        System.out.println("Your choice: ");
        String choice = scanner.nextLine();
        while (!Objects.equals(choice, "1") && !Objects.equals(choice, "2")  && !Objects.equals(choice, "3")
                && !Objects.equals(choice, "4") && !Objects.equals(choice, "5") && !Objects.equals(choice, "6")) {
            System.out.println("Enter a valid choice (1-6)");
            System.out.println("Your choice: ");
            choice = scanner.nextLine();
        }
        return choice;
    }

    public String subscriptionTypeUiMenu()
    {
        System.out.println("Choose an action: ");
        System.out.println("1. Add subscription type");
        System.out.println("2. Update subscription type");
        System.out.println("3. Delete subscription type");
        System.out.println("4. Search subscription type by name");
        System.out.println("5. Add room to subscription");
        System.out.println("6. Remove room from subscription");
        System.out.println("7. Show all subscription types");
        System.out.println("X. <-- Return to main menu");
        System.out.println("Your choice: ");
        String choice = scanner.nextLine();
        while (!Objects.equals(choice, "1") && !Objects.equals(choice, "2")  && !Objects.equals(choice, "3")
                && !Objects.equals(choice, "4") && !Objects.equals(choice, "5") && !Objects.equals(choice, "6")
                && !Objects.equals(choice, "7") && !Objects.equals(choice, "x") && !Objects.equals(choice, "X")) {
            System.out.println("Enter a valid choice (1-7) | X for exit");
            System.out.println("Your choice: ");
            choice = scanner.nextLine();
        }
        return choice;
    }

    public String customerSubscriptionUiMenu()
    {
        System.out.println("Choose an action: ");
        System.out.println("1. Add customer subscription");
        System.out.println("2. Update customer subscription");
        System.out.println("3. Delete customer subscription");
        System.out.println("4. Search customer subscription by customer username");
        System.out.println("5. Search customer subscription by subscription type name");
        System.out.println("6. Show all customer subscriptions");
        System.out.println("7. <-- Return to main menu");
        System.out.println("Your choice: ");
        String choice = scanner.nextLine();
        while (!Objects.equals(choice, "1") && !Objects.equals(choice, "2")  && !Objects.equals(choice, "3")
                && !Objects.equals(choice, "4") && !Objects.equals(choice, "5")
                && !Objects.equals(choice, "6") && !Objects.equals(choice, "7")) {
            System.out.println("Enter a valid choice (1-7)");
            System.out.println("Your choice: ");
            choice = scanner.nextLine();
        }
        return choice;
    }

    public String budgetUiMenu()
    {
        System.out.println("Choose an action: ");
        System.out.println("1. Show budget");
        System.out.println("2. Add money");
        System.out.println("3. Spend money");
        System.out.println("4. <-- Return to main menu");
        System.out.println("Your choice: ");
        String choice = scanner.nextLine();
        while (!Objects.equals(choice, "1") && !Objects.equals(choice, "2")  && !Objects.equals(choice, "3")
                && !Objects.equals(choice, "4"))
        {
            System.out.println("Enter a valid choice (1-4)");
            System.out.println("Your choice: ");
            choice = scanner.nextLine();
        }
        return choice;
    }

    // Write methods
    public void printMessage(String message)
    {
        System.out.println(message);
    }

    public <Type> void printArrayList(ArrayList<Type> list)
    {
        for (Type element : list)
        {
            System.out.println(element);
        }
    }

    // Read methods
    public int readId()
    {
        System.out.println("Enter id (number): ");
        String idString = scanner.nextLine();
        // Check if int
        while (true) {
            try {
                return Integer.parseInt(idString);
            } catch (NumberFormatException e) {
                System.out.println("The id must be a number: ");
                idString = scanner.nextLine();
            }
        }
    }

    public int readSets()
    {
        System.out.println("Enter sets (number): ");
        String setsString = scanner.nextLine();
        // Check if int
        while (true) {
            try {
                return Integer.parseInt(setsString);
            } catch (NumberFormatException e) {
                System.out.println("The sets must be a number: ");
                setsString = scanner.nextLine();
            }
        }
    }

    public int readReps()
    {
        System.out.println("Enter reps (number): ");
        String repsString = scanner.nextLine();
        // Check if int
        while (true) {
            try {
                return Integer.parseInt(repsString);
            } catch (NumberFormatException e) {
                System.out.println("The reps must be a number: ");
                repsString = scanner.nextLine();
            }
        }
    }

    public RoomType readRoomType()
    {
        System.out.println("Room types: ");
        System.out.println("1. empty");
        System.out.println("2. freeWeights");
        System.out.println("3. cardio");
        System.out.println("4. functional");
        System.out.println("5. resistanceMachines");
        System.out.println("6. studio");
        System.out.println("7. reception");
        System.out.println("8. storage");
        System.out.println("Enter a room type: ");
        String choice = scanner.nextLine();
        while (!Objects.equals(choice, "1") && !Objects.equals(choice, "2")  && !Objects.equals(choice, "3")
                && !Objects.equals(choice, "4") && !Objects.equals(choice, "5")  && !Objects.equals(choice, "6")
                && !Objects.equals(choice, "7") && !Objects.equals(choice, "8"))
        {
            System.out.println("Enter a valid choice (1-8)");
            System.out.println("Enter a room type: ");
            choice = scanner.nextLine();
        }
        return switch (choice) {
            case "2" -> RoomType.freeWeights;
            case "3" -> RoomType.cardio;
            case "4" -> RoomType.functional;
            case "5" -> RoomType.resistanceMachines;
            case "6" -> RoomType.studio;
            case "7" -> RoomType.reception;
            case "8" -> RoomType.storage;
            default -> RoomType.empty;
        };
    }

    public TrainerSpecialization readTrainerSpecialisation()
    {
        System.out.println("Trainer specialisations: ");
        System.out.println("1. CrossTraining");
        System.out.println("2. Cycling");
        System.out.println("3. Yoga");
        System.out.println("4. Zumba");
        System.out.println("5. Aerobic");
        System.out.println("6. Pilates");
        System.out.println("7. Box");
        System.out.println("8. TRX");
        System.out.println("9. none");
        System.out.println("Enter trainer specialisation: ");
        String choice = scanner.nextLine();
        while (!(Objects.equals(choice, "1") || Objects.equals(choice, "2") || Objects.equals(choice, "3")
                || Objects.equals(choice, "4") || Objects.equals(choice, "5") || Objects.equals(choice, "6")
                || Objects.equals(choice, "7") || Objects.equals(choice, "8") || Objects.equals(choice, "9")))
        {
            System.out.println("Enter a valid choice (1-9)");
            System.out.println("Enter trainer specialisation: ");
            choice = scanner.nextLine();
        }
        return switch (choice) {
            case "1" -> TrainerSpecialization.CrossTraining;
            case "2" -> TrainerSpecialization.Cycling;
            case "3" -> TrainerSpecialization.Yoga;
            case "4" -> TrainerSpecialization.Zumba;
            case "5" -> TrainerSpecialization.Aerobic;
            case "6" -> TrainerSpecialization.Pilates;
            case "7" -> TrainerSpecialization.Box;
            case "8" -> TrainerSpecialization.TRX;
            default -> TrainerSpecialization.none;
        };
    }

    public Boolean occupied()
    {
        System.out.println("1. Yes / 2. No)");
        System.out.println("Enter occupied: ");
        String choice = scanner.nextLine();
        while (!Objects.equals(choice, "1") && !Objects.equals(choice, "2"))
        {
            System.out.println("Enter a valid choice");
            System.out.println("1. Yes / 2. No");
            System.out.println("Enter occupied: ");
            choice = scanner.nextLine();
        }
        if (choice.equals("1")) return Boolean.TRUE;
        else return Boolean.FALSE;
    }

    public int readPersonCapacity()
    {
        System.out.println("Enter person capacity (number): ");
        String personCapacityString = scanner.nextLine();
        // Check if int
        while (true) {
            try {
                return Integer.parseInt(personCapacityString);
            } catch (NumberFormatException e) {
                System.out.println("The capacity must be a number: ");
                personCapacityString = scanner.nextLine();
            }
        }
    }

    public String readUsername()
    {
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        // Check for empty username
        while (Objects.equals(username, "")) {
            System.out.println("Please enter an username");
        }
        return username;
    }

    public String readName()
    {
        System.out.println("Enter name: ");
        String username = scanner.nextLine();
        // Check for empty username
        while (Objects.equals(username, "")) {
            System.out.println("Please enter a name: ");
        }
        return username;
    }

    public String readDescription()
    {
        System.out.println("Enter description: ");
        String description = scanner.nextLine();
        // Check for empty description
        while (Objects.equals(description, "")) {
            System.out.println("Please enter a description: ");
        }
        return description;
    }

    public double readPrice()
    {
        System.out.println("Enter price (number): ");
        String price = scanner.nextLine();
        // Check if int
        while (true) {
            try {
                return Integer.parseInt(price);
            } catch (NumberFormatException e) {
                System.out.println("The price must be a number: ");
                price = scanner.nextLine();
            }
        }
    }

    public double readMoneyAmount()
    {
        System.out.println("Enter money amount (number): ");
        String moneyAmount = scanner.nextLine();
        // Check if int
        while (true) {
            try {
                return Double.parseDouble(moneyAmount);
            } catch (NumberFormatException e) {
                System.out.println("The money amount must be a number: ");
                moneyAmount = scanner.nextLine();
            }
        }
    }

    public String readSubscriptionTypeName()
    {
        System.out.println("Enter subscription name: ");
        String subscriptionName = scanner.nextLine();
        // Check for empty subscriptionName
        while (Objects.equals(subscriptionName, "")) {
            System.out.println("Please enter a subscription name: ");
        }
        return subscriptionName;
    }


    public String muscleTrained()
    {
        System.out.println("Enter muscle trained name: ");
        String name = scanner.nextLine();
        // Check for empty username
        while (Objects.equals(name, "")) {
            System.out.println("Please enter muscle trained name: ");
        }
        return name;
    }

    public Gender readGender()
    {
        System.out.println("1. Male / 2. Female / 3. Not specified");
        System.out.println("Enter gender: ");
        String choice = scanner.nextLine();
        while (!Objects.equals(choice, "1") && !Objects.equals(choice, "2")  && !Objects.equals(choice, "3"))
        {
            System.out.println("Enter a valid choice");
            System.out.println("1. Male / 2. Female / 3. Not specified");
            System.out.println("Enter customer's gender: ");
            choice = scanner.nextLine();
        }
        return switch (choice) {
            case "1" -> Gender.male;
            case "2" -> Gender.female;
            default -> Gender.notSpecifying;
        };
    }

    // Date stuff
    public LocalDate readBirthDate(){
        System.out.println("Enter birth date: ");
        return readDate();
    }

    public LocalDate readValidFromDate()
    {
        System.out.println("Enter valid from date: ");
        return readDate();
    }

    public LocalDate readValidToDate(LocalDate validFrom)
    {
        System.out.println("Enter valid to date: ");
        LocalDate validTo = readDate();
        while (validTo.isBefore(validFrom))
        {
            System.out.println("Valid to must be after valid from!");
            System.out.println("Enter valid to date: ");
            validTo = readDate();
        }
        return validTo;
    }

    public LocalDate readDate()
    {
        System.out.print("Enter a date (yyyy-MM-dd): ");
        String input = scanner.nextLine();
        while (!parseLocalDate(input))
        {
            System.out.print("Enter a valid date (yyyy-MM-dd): ");
            input = scanner.nextLine();
        }
        // Return date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(input, formatter);
    }
    public Boolean parseLocalDate(String input) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(input, formatter);
        } catch (Exception e) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }


}
