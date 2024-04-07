package map.project.FitnessCenter.data.model;

import jakarta.persistence.*;
import lombok.*;
import map.project.FitnessCenter.data.model.enums.Gender;

import java.time.LocalDate;

/**
 * Entity class representing a customer in the fitness center.
 */
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Customer extends Person {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn()
    private Trainer assignedTrainer;

    public Customer(String username, String name, LocalDate birthDate, Gender gender, Trainer assignedTrainer) {
        super(username, name, birthDate, gender);
        this.assignedTrainer = assignedTrainer;
    }

    public Customer copy() {
        return new Customer(username, name, birthDate, gender, assignedTrainer);
    }
}
