package dao;

import dao.interaces.ICustomerSubscriptionDao;
import domain.money.CustomerSubscription;
import domain.money.SubscriptionType;
import domain.persons.Customer;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class CustomerSubscriptionDao implements IDao<CustomerSubscription>, ICustomerSubscriptionDao {
    private static CustomerSubscriptionDao instance;


    private final SubscriptionTypeDao subscriptionTypeDao;

    private final CustomerDao customerDao;

    private CustomerSubscriptionDao()
    {
        subscriptionTypeDao = SubscriptionTypeDao.getInstance();
        customerDao = CustomerDao.getInstance();
    }

    public static CustomerSubscriptionDao getInstance()
    {
        if (instance == null) instance = new CustomerSubscriptionDao();
        return instance;
    }

    @Override
    public void addEntity(CustomerSubscription customerSubscription) throws ObjectAlreadyContained {
        String customerUsername = customerSubscription.getCustomer().getUsername();
        String subscriptionTypeName = customerSubscription.getSubscriptionType().getName();
        LocalDate validFrom = customerSubscription.getValidFrom();
        LocalDate validUntil = customerSubscription.getValidUntil();
        try {
            String insertQuery = "INSERT INTO customersubscription (customerUsername, subscriptionTypeName, validFrom, validUntil) VALUES (?, ?, ?, ?);";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setString(1, customerUsername);
            insertStatement.setString(2, subscriptionTypeName);
            insertStatement.setDate(3, Date.valueOf(validFrom));
            insertStatement.setDate(4, Date.valueOf(validUntil));
            insertStatement.executeUpdate();
        }
        catch (SQLIntegrityConstraintViolationException e) {
            throw new ObjectAlreadyContained();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateEntity(CustomerSubscription customerSubscription) throws ObjectNotContained {
        String customerUsername = customerSubscription.getCustomer().getUsername();
        String subscriptionTypeName = customerSubscription.getSubscriptionType().getName();
        LocalDate validFrom = customerSubscription.getValidFrom();
        LocalDate validUntil = customerSubscription.getValidUntil();
        try {
            String query = "UPDATE customersubscription SET customerUsername = ?, subscriptionTypeName = ?, validFrom = ?, validUntil = ? WHERE customerUsername = ? AND subscriptionTypeName = ? AND validFrom = ? AND validUntil = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, customerUsername);
            statement.setString(2, subscriptionTypeName);
            statement.setDate(3, Date.valueOf(validFrom));
            statement.setDate(4, Date.valueOf(validUntil));
            statement.setString(5, customerUsername);
            statement.setString(6, subscriptionTypeName);
            statement.setDate(7, Date.valueOf(validFrom));
            statement.setDate(8, Date.valueOf(validUntil));
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) throw new ObjectNotContained();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEntity(CustomerSubscription customerSubscription) throws ObjectNotContained {
        String customerUsername = customerSubscription.getCustomer().getUsername();
        String subscriptionTypeName = customerSubscription.getSubscriptionType().getName();
        LocalDate validFrom = customerSubscription.getValidFrom();
        LocalDate validUntil = customerSubscription.getValidUntil();
        try {
            String query = "DELETE FROM customersubscription WHERE customerUsername = ? AND subscriptionTypeName = ? AND validFrom = ? AND validUntil = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, customerUsername);
            statement.setString(2, subscriptionTypeName);
            statement.setDate(3, Date.valueOf(validFrom));
            statement.setDate(4, Date.valueOf(validUntil));
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) throw new ObjectNotContained();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<CustomerSubscription> getAllEntities() {
        ArrayList<CustomerSubscription> result = new ArrayList<>();
        try {
            String query = "SELECT * FROM customersubscription ORDER BY customerUsername;";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next())
            {
                String customerUsername = resultSet.getString("customerUsername");
                Customer customer = customerDao.searchByKeyName(customerUsername);
                String subscriptionTypeName = resultSet.getString("subscriptionTypeName");
                SubscriptionType subscriptionType = subscriptionTypeDao.searchByKeyName(subscriptionTypeName);
                LocalDate validFrom = resultSet.getDate("validFrom").toLocalDate();
                LocalDate validUntil = resultSet.getDate("validUntil").toLocalDate();
                CustomerSubscription customerSubscription = new CustomerSubscription(customer,
                        subscriptionType, validFrom, validUntil);
                // Return
                result.add(customerSubscription);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public ArrayList<CustomerSubscription> searchSubscriptionsOfUser(String username) {
        ArrayList<CustomerSubscription> result = new ArrayList<>();
        if (!customerDao.keyNameInRepo(username)) return result;
        try {
            String query = "SELECT * FROM customersubscription WHERE customerUsername = ? ORDER BY customerUsername;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next())
            {
                String customerUsername = resultSet.getString("customerUsername");
                Customer customer = customerDao.searchByKeyName(customerUsername);
                String subscriptionTypeName = resultSet.getString("subscriptionTypeName");
                SubscriptionType subscriptionType = subscriptionTypeDao.searchByKeyName(subscriptionTypeName);
                LocalDate validFrom = resultSet.getDate("validFrom").toLocalDate();
                LocalDate validUntil = resultSet.getDate("validUntil").toLocalDate();
                CustomerSubscription customerSubscription = new CustomerSubscription(customer,
                        subscriptionType, validFrom, validUntil);
                // Return
                result.add(customerSubscription);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public ArrayList<CustomerSubscription> searchSubscriptionByType(SubscriptionType subscriptionType) {
        ArrayList<CustomerSubscription> result = new ArrayList<>();
        if (!subscriptionTypeDao.keyNameInRepo(subscriptionType.getName())) return result;
        try {
            String query = "SELECT * FROM customersubscription WHERE subscriptionTypeName = ? ORDER BY customerUsername;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, subscriptionType.getName());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next())
            {
                String customerUsername = resultSet.getString("customerUsername");
                Customer customer = customerDao.searchByKeyName(customerUsername);
                String subscriptionTypeName = resultSet.getString("subscriptionTypeName");
                SubscriptionType subscriptionTypeFound = subscriptionTypeDao.searchByKeyName(subscriptionTypeName);
                LocalDate validFrom = resultSet.getDate("validFrom").toLocalDate();
                LocalDate validUntil = resultSet.getDate("validUntil").toLocalDate();
                CustomerSubscription customerSubscription = new CustomerSubscription(customer,
                        subscriptionTypeFound, validFrom, validUntil);
                // Return
                result.add(customerSubscription);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public Boolean hasValidSubscription(Customer customer) {
        if (!customerDao.keyNameInRepo(customer.getUsername())) return Boolean.FALSE;
        try {
            String query = "SELECT * FROM customersubscription WHERE customerUsername = ? ORDER BY customerUsername;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, customer.getUsername());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                String subscriptionTypeName = resultSet.getString("subscriptionTypeName");
                SubscriptionType subscriptionType = subscriptionTypeDao.searchByKeyName(subscriptionTypeName);
                LocalDate validFrom = resultSet.getDate("validFrom").toLocalDate();
                LocalDate validUntil = resultSet.getDate("validUntil").toLocalDate();
                CustomerSubscription customerSubscription = new CustomerSubscription(customer,
                        subscriptionType, validFrom, validUntil);
                // Return
                if (customerSubscription.checkValidity()) return Boolean.TRUE;
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Boolean.FALSE;
    }

    @Override
    public void subscriptionTypeDeleted(SubscriptionType subscriptionType) {
        try {
            String query = "UPDATE customersubscription SET subscriptionTypeName = 'null' WHERE subscriptionTypeName = ? ";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, subscriptionType.getName());
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
