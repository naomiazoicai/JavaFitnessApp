package domain.persons;

import domain.money.CustomerSubscription;
import domain.money.SubscriptionType;

import java.time.LocalDate;

public class Customer extends Person {

    private CustomerSubscription customerSubscription;

    public Customer(String username, String name, LocalDate birthDate, Gender gender) {
        super(username, name, birthDate, gender);
    }

    public Customer(String username) {
        super(username, "", LocalDate.now(), Gender.notSpecifying);
    }

    public boolean hasValidSubscription()
    {
        if (customerSubscription == null) return false;
        return customerSubscription.checkValidity();
    }

    @Override
    public String toString() {
        return "Customer{" + super.toString() +
                "subscriptionType=" + customerSubscription +
                '}';
    }

    public CustomerSubscription getCustomerSubscription() {
        return customerSubscription;
    }

    public void setCustomerSubscription(CustomerSubscription customerSubscription) {
        this.customerSubscription = customerSubscription;
    }
}
