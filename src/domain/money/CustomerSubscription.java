package domain.money;

import domain.persons.Customer;

import java.time.LocalDate;
import java.util.Objects;

public class CustomerSubscription extends SubscriptionType{
    private Customer customer;
    private LocalDate validFrom;
    private LocalDate validUntil;

    public CustomerSubscription(String name, String description, double price, Customer customer, LocalDate validFrom, LocalDate validUntil) {
        super(name, description, price);
        this.customer = customer;
        this.validFrom = validFrom;
        this.validUntil = validUntil;
    }

    @Override
    public String toString() {
        return "CustomerSubscription{" +
                "customer=" + customer +
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
        if (!super.equals(o)) return false;
        CustomerSubscription that = (CustomerSubscription) o;
        return Objects.equals(customer, that.customer) && Objects.equals(validFrom, that.validFrom) && Objects.equals(validUntil, that.validUntil);
    }

}
