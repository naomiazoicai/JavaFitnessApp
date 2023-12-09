package map.project.FitnessCenter.data.model;

import jakarta.persistence.*;
import lombok.*;
import map.project.FitnessCenter.data.model.enums.Gender;

import java.time.LocalDate;

@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Employee extends Person
{
    @Column
    protected double salary = 0;

    public Employee(String username, String name, LocalDate birthDate, Gender gender, double salary) {
        super(username, name, birthDate, gender);
        this.salary = salary;
    }

    public Employee copy()
    {
        return new Employee(username, name, birthDate, gender, salary);
    }
}
