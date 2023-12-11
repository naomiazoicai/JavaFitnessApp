package map.project.FitnessCenter.data.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
@Entity
public class SubscriptionType {
    @Id
    private String name;
    @Column
    private String description;
    @Column(nullable = false)
    private double price = 0;
    @ManyToMany
    @JoinColumn
    private Set<Room> accessibleRestrictedRooms;

    public SubscriptionType copy()
    {
        return new SubscriptionType(name, description, price, accessibleRestrictedRooms);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubscriptionType that = (SubscriptionType) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
