package domain.persons;

import java.time.LocalDate;

public class Trainer extends Employee {
    private final static Trainer nullTrainer = new Trainer();

    private TrainerSpecialization specialization;

    public Trainer(String username, String name, LocalDate birthDate, Gender gender, double salary, TrainerSpecialization specialization) {
        super(username, name, birthDate, gender, salary);
        this.specialization = specialization;
    }

    public Trainer(String username, String name, LocalDate birthDate, Gender gender) {
        super(username, name, birthDate, gender);
        this.specialization = TrainerSpecialization.none;
    }

    public Trainer(String username, String name, LocalDate birthDate, Gender gender, TrainerSpecialization specialization) {
        super(username, name, birthDate, gender);
        this.specialization = specialization;
    }

    public Trainer(String username) {
        super(username);
    }

    public Trainer()
    {
        super("null", "null", LocalDate.of(1, 1, 1), Gender.notSpecifying, 0);
        this.specialization = TrainerSpecialization.none;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "username=" + username +
                ", salary=" + salary +
                ", specialisation='" + specialization + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
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

    public static Trainer getNullTrainer()
    {
        return nullTrainer.copy();
    }
}
