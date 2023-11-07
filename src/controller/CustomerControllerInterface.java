package controller;

import domain.persons.Customer;

import java.util.ArrayList;

public interface CustomerControllerInterface {
    ArrayList<Customer> searchByPartialUsername(String username);

    Customer searchByUsername(String username);

    Boolean usernameInRepo(String username);
}
