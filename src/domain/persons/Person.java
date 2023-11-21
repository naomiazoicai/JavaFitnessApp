package domain.persons;

import java.time.LocalDate;
import java.util.Objects;

public class Person
{
    private final static Person nullPerson = new Person();

    protected String username;
    protected String name;
    protected LocalDate birthDate;
    protected Gender gender;

    public Person(String username, String name, LocalDate birthDate, Gender gender)
    {
        this.username = username;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public Person(String username) {
        this.username = username;
    }

    public Person()
    {
        this.username = "null";
        this.name = "null";
        this.birthDate = LocalDate.of(1000, 1, 1);
        this.gender = Gender.notSpecifying;
    }

    @Override
    public String toString()
    {
        return "Person{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", gender=" + gender +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person;
        person = (Person) o;
        return Objects.equals(username, person.username);
    }

    public Person copy()
    {
        return new Person(username, name, birthDate, gender);
    }

    public static Person getNullPerson() {
        return nullPerson.copy();
    }
}
