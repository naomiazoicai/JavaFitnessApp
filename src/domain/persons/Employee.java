package domain.persons;

import java.time.LocalDate;

public class Employee extends Person
{
    private final static Employee nullEmployee = new Employee();

    protected double salary;

    public Employee(String username, String name, LocalDate birthDate, Gender gender, double salary) {
        super(username, name, birthDate, gender);
        this.salary = salary;
    }

    public Employee(String username, String name, LocalDate birthDate, Gender gender)
    {
        super(username, name, birthDate, gender);
        salary = 0;
    }

    public Employee(String username) {
        super(username);
    }

    public Employee() {
        super();
        salary = 0;
    }

    @Override
    public String toString()
    {
        return "Employee{" +
                "salary=" + salary +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                '}';
    }

    public Employee copy() {
        return new Employee(username, name, birthDate, gender, salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static Employee getNullEmployee()
    {
        return nullEmployee.copy();
    }
}
