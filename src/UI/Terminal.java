package UI;

import domain.persons.Gender;

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
