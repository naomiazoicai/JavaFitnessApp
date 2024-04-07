package map.project.FitnessCenter.data.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Entity class representing a log for free subscriptions in the fitness center.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Data
public class FreeSubscriptionsLog {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    String personUsername;
    @Column
    LocalDate date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FreeSubscriptionsLog that = (FreeSubscriptionsLog) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
