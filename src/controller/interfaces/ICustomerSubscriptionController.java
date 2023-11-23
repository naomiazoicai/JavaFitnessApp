package controller.interfaces;

import domain.money.CustomerSubscription;
import domain.money.SubscriptionType;
import domain.persons.Customer;

import java.time.LocalDate;
import java.util.ArrayList;

public interface ICustomerSubscriptionController
{
    ArrayList<CustomerSubscription> searchSubscriptionsOfUser(String username);

    ArrayList<CustomerSubscription> searchSubscriptionByType(SubscriptionType subscriptionType);

    boolean usernameInRepo(String username);

    Customer searchCustomerInRepo(String username);

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    boolean subscriptionTypeInRepo(String name);

    SubscriptionType searchSubscriptionType(String name);

    CustomerSubscription searchCustomerSubscription(Customer customer, SubscriptionType subscriptionType, LocalDate validFrom);

    Boolean hasValidSubscription(Customer customer);
}
