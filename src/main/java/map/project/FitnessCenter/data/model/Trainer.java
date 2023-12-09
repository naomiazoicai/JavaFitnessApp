package map.project.FitnessCenter.data.model;

import jakarta.persistence.*;
import lombok.*;
import map.project.FitnessCenter.data.model.enums.Gender;
import map.project.FitnessCenter.data.model.enums.TrainerSpecialisation;

import java.time.LocalDate;

@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Trainer extends Employee{
    @Column
    @Enumerated
    TrainerSpecialisation trainerSpecialisation = TrainerSpecialisation.none;

    public Trainer(String username, String name, LocalDate birthDate, Gender gender, double salary, TrainerSpecialisation trainerSpecialisation) {

        super(username, name, birthDate, gender, salary);
        this.trainerSpecialisation = trainerSpecialisation;
    }

    public Trainer copy()
    {
        return new Trainer(username, name, birthDate, gender, salary, trainerSpecialisation);
    }
}

