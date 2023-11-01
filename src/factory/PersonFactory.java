package factory;

import domain.persons.*;

import java.time.LocalDate;

public class PersonFactory
{
    public static Person buildPerson(PersonType personType, String username, String name, LocalDate birthdate, Gender gender)
    {
        return switch (personType)
        {
            case customer -> new Customer(username, name, birthdate, gender);
            case employee -> new Employee(username, name, birthdate, gender);
            case trainer -> new Trainer(username, name, birthdate, gender);
        };
    }
}
