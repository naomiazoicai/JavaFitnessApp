package domain.persons;

import java.time.LocalDate;

public class Trainer extends Employee {
    private TrainerSpecialization specialization;
    public Trainer(String username, String name, LocalDate birthDate, Gender gender) {
        super(username, name, birthDate, gender);
    }

}
