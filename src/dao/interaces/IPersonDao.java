package dao.interaces;

import domain.persons.Person;

public interface IPersonDao {
    Person searchByUsername(String keyName);
}
