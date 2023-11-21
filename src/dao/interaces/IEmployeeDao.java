package dao.interaces;

import domain.persons.Person;

public interface IEmployeeDao {
    Boolean keyNameInRepo(String keyName);

    Person searchByKeyName(String keyName);
}
