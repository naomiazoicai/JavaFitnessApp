package domain.persons;

import java.time.LocalDate;

public class Employee extends Person{

    protected double salary;
    public Employee(String username, String name, LocalDate birthDate, Gender gender) {
        super(username, name, birthDate, gender);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                '}';
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
