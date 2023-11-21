package dao.interaces;

import domain.money.CustomerSubscription;
import domain.money.SubscriptionType;
import domain.persons.Customer;

import java.util.ArrayList;

public interface ICustomerSubscriptionDao {
    ArrayList<CustomerSubscription> searchSubscriptionsOfUser(String username);

    ArrayList<CustomerSubscription> searchSubscriptionByType(SubscriptionType subscriptionType);

    Boolean hasValidSubscription(Customer customer);

    void subscriptionTypeDeleted(SubscriptionType subscriptionType);
}
