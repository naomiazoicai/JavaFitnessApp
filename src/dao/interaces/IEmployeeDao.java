package dao.interaces;

import domain.persons.Employee;

public interface IEmployeeDao {
    Boolean keyNameInRepo(String keyName);

    Employee searchByKeyName(String keyName);
}
