package map.project.FitnessCenter.data.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
@Entity
public class Subscription {
    @Id @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn()
    private Customer customer;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn()
    private SubscriptionType subscriptionType;
    @Column
    private LocalDate startDate;
    @Column
    private int durationInDays;

    public Subscription copy()
    {
        return new Subscription(id, customer, subscriptionType, startDate, durationInDays);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
