package repository.interfaces;

import domain.persons.Customer;

import java.util.ArrayList;

public interface ICustomerRepository {

    Boolean usernameInRepo(String username);
    ArrayList<Customer> searchByPartialUsername(String username);

    Customer searchByUsername(String username);
}
