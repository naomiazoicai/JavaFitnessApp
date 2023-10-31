package domain.persons;

import java.time.LocalDate;

public class Customer extends Person{

    private domain.money.Customer subscriptionType;
    public Customer(String username, String name, LocalDate birthDate, Gender gender) {
        super(username, name, birthDate, gender);
    }

    public Customer(String username)
    {
        super(username, "", LocalDate.now(), Gender.notSpecifying);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "subscriptionType=" + subscriptionType +
                '}';
    }

    public domain.money.Customer getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(domain.money.Customer subscriptionType) {
        this.subscriptionType = subscriptionType;
    }
}
