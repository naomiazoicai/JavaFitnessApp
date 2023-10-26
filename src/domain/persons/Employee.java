package domain.persons;

import java.time.LocalDate;

public class Employee extends Person{

    private double salary;
    public Employee(String username, String name, LocalDate birthDate, Gender gender) {
        super(username, name, birthDate, gender);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                '}';
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
