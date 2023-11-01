package tests.factoryTest;

import domain.persons.*;
import domain.persons.Gender;
import domain.persons.PersonType;
import factory.PersonFactory;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonFactoryTest
{
    @Test
    void testBuildPerson()
    {
        String username = "test";
        String name = "test";
        LocalDate birthdate = LocalDate.of(1000, 1, 1);
        Gender gender = Gender.male;
        // Test
        Person customer = PersonFactory.buildPerson(PersonType.customer, username, name, birthdate, gender);
        Person employee = PersonFactory.buildPerson(PersonType.employee, username, name, birthdate, gender);
        Person trainer = PersonFactory.buildPerson(PersonType.trainer, username, name, birthdate, gender);
        assertTrue(customer instanceof Customer);
        assertTrue(employee instanceof Employee);
        assertTrue(trainer instanceof Trainer);
    }
}
