package domain.persons;

import java.time.LocalDate;

public class Customer extends Person
{
    private final static Customer nullCustomer = new Customer();
    private Trainer assignedTrainer;

    public Customer(String username, String name, LocalDate birthDate, Gender gender, Trainer assignedTrainer)
    {
        super(username, name, birthDate, gender);
        this.assignedTrainer = assignedTrainer;
    }

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
        super("null", "null", LocalDate.now(), Gender.notSpecifying);
        this.assignedTrainer = new Trainer();
    }

    @Override
    public String toString()
    {
        return "Customer{" +
                "username=" + username +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                ", assignedTrainer='" + assignedTrainer + '\'' +
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

    public static Customer getNullCustomer()
    {
        return nullCustomer.copy();
    }
}
