package domain.persons;

import domain.money.SubscriptionType;

import java.time.LocalDate;

public class Customer extends Person{

    private SubscriptionType subscriptionType;
    public Customer(String username, String name, LocalDate birthDate, Gender gender) {
        super(username, name, birthDate, gender);
    }

    public Customer(String username)
    {
        super(username, "", LocalDate.now(), Gender.notSpecifying);
    }

    @Override
    public String toString() {
        return "Customer{" + super.toString() +
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
