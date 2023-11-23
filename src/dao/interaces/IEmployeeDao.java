package dao.interaces;

import domain.persons.Employee;

public interface IEmployeeDao {
    Boolean usernameInRepo(String keyName);

    Employee searchByUsername(String keyName);
}
