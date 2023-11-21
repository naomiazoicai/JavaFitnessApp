package dao.interaces;

import domain.persons.Person;

public interface IPersonDao {
    Boolean keyNameInRepo(String keyName);

    Person searchByKeyName(String keyName);
}
