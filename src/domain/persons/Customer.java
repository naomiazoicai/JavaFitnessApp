package domain.persons;

import domain.money.SubscriptionType;

public class Customer extends Person{

    private SubscriptionType subscriptionType;
    public Customer(String username, String name, String birthDate, Gender gender) {
        super(username, name, birthDate, gender);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "subscriptionType=" + subscriptionType +
                '}';
    }

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(SubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
    }
}
