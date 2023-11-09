package repository;

import domain.persons.Customer;

import java.util.ArrayList;

public interface CustomerRepositoryInterface {

    Boolean usernameInRepo(String username);
    ArrayList<Customer> searchByPartialUsername(String username);

    Customer searchByUsername(String username);
}
