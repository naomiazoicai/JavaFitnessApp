package controller.interfaces;

import domain.money.CustomerSubscription;
import domain.money.SubscriptionType;
import domain.persons.Customer;

import java.util.ArrayList;

public interface ICustomerSubscriptionController {
    ArrayList<CustomerSubscription> searchSubscriptionsOfUser(String username);

    ArrayList<CustomerSubscription> searchSubscriptionByType(SubscriptionType subscriptionType);

    boolean customerInRepo(String username);

    Customer searchCustomerInRepo(String username);

    boolean subscriptionTypeInRepo(String name);

    SubscriptionType searchSubscriptionType(String name);
}
