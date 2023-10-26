package domain.persons;

public class Trainer extends Employee {
    private TrainerSpecialization specialization;
    public Trainer(String username, String name, String birthDate, Gender gender) {
        super(username, name, birthDate, gender);
    }

}
