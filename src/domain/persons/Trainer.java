package domain.persons;

import java.time.LocalDate;

public class Trainer extends Employee {
    private TrainerSpecialization specialization;
    public Trainer(String username, String name, LocalDate birthDate, Gender gender) {
        super(username, name, birthDate, gender);
    }

    public Trainer(String username, String name, LocalDate birthDate, Gender gender, TrainerSpecialization specialization) {
        super(username, name, birthDate, gender);
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Trainer{" + super.toString() +
                "specialization=" + specialization +
                '}';
    }

    public Trainer copy()
    {
        return new Trainer(username, name, birthDate, gender, specialization);
    }

    public TrainerSpecialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(TrainerSpecialization specialization) {
        this.specialization = specialization;
    }
}
