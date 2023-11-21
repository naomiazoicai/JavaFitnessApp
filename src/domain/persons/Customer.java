package domain.persons;

import java.time.LocalDate;

public class Customer extends Person
{
    private Trainer assignedTrainer;
    public Customer(String username, String name, LocalDate birthDate, Gender gender)
    {
        super(username, name, birthDate, gender);
        this.assignedTrainer = new Trainer();
    }

    public Customer(String username)
    {
        super(username, "", LocalDate.now(), Gender.notSpecifying);
        this.assignedTrainer = new Trainer();
    }

    public Customer()
    {
        super("", "", LocalDate.now(), Gender.notSpecifying);
        this.assignedTrainer = new Trainer();
    }

    @Override
    public String toString()
    {
        return "Customer{" +
                "assignedTrainer=" + assignedTrainer +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                '}';
    }

    public Customer copy()
    {
        return new Customer(username, name, birthDate, gender);
    }

    public Trainer getAssignedTrainer() {
        return assignedTrainer;
    }

    public void setAssignedTrainer(Trainer assignedTrainer) {
        this.assignedTrainer = assignedTrainer;
    }
}
