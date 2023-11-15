package repository.interfaces;

import domain.money.CustomerSubscription;
import domain.money.SubscriptionType;
import domain.persons.Customer;

import java.util.ArrayList;

public interface ICustomerSubscriptionRepository {
    ArrayList<CustomerSubscription> searchSubscriptionsOfUser(String username);

    ArrayList<CustomerSubscription> searchSubscriptionByType(SubscriptionType subscriptionType);

    Boolean hasValidSubscription(Customer customer);

    void subscriptionTypeDeleted(SubscriptionType subscriptionType);
}
