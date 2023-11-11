package domain.persons;

import java.time.LocalDate;
import java.util.Objects;

public class Person {
    protected String username;
    protected String name;
    protected LocalDate birthDate;
    protected Gender gender;

    public Person(String username, String name, LocalDate birthDate, Gender gender) {
        this.username = username;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    @Override
    public String toString() {
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
    public boolean equals(Object o) {
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

}
