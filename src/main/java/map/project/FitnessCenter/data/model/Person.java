package map.project.FitnessCenter.data.model;

import jakarta.persistence.*;
import lombok.*;
import map.project.FitnessCenter.data.model.enums.Gender;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Base entity class representing a person in the fitness center.
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    @Id
    protected String username;
    @Column
    protected String name;
    @Column
    protected LocalDate birthDate;
    @Column
    @Enumerated
    protected Gender gender = Gender.doNotSay;

    public Person copy() {
        return new Person(username, name, birthDate, gender);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(username, person.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
