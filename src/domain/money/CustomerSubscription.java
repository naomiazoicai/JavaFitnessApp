package domain.money;

import domain.persons.Customer;

import java.time.LocalDate;
import java.util.Objects;

public class CustomerSubscription{
    private Customer customer;
    private SubscriptionType subscriptionType;
    private LocalDate validFrom;
    private LocalDate validUntil;

    public CustomerSubscription(Customer customer, SubscriptionType subscriptionType, LocalDate validFrom, LocalDate validUntil) {
        this.customer = customer;
        this.subscriptionType = subscriptionType;
        this.validFrom = validFrom;
        this.validUntil = validUntil;
    }

    @Override
    public String toString() {
        return "CustomerSubscription{" +
                "customer=" + customer +
                "subscriptionType" + subscriptionType +
                ", validFrom=" + validFrom +
                ", validUntil=" + validUntil +
                '}';
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(SubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDate getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDate validUntil) {
        this.validUntil = validUntil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerSubscription that = (CustomerSubscription) o;
        return Objects.equals(customer, that.customer) && Objects.equals(subscriptionType, that.subscriptionType) && Objects.equals(validFrom, that.validFrom);
    }
}
