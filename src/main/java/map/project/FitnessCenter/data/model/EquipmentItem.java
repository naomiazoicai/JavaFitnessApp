package map.project.FitnessCenter.data.model;

import jakarta.persistence.*;
import lombok.*;
import map.project.FitnessCenter.data.model.enums.Condition;

import java.util.Objects;

/**
 * Entity class representing an equipment item in the fitness center.
 **/
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
@Entity
public class EquipmentItem {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    @Enumerated
    @Column(nullable = false)
    private Condition condition = Condition.UNKNOWN; // Default value

    public EquipmentItem copy() {
        return new EquipmentItem(id, name, condition);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        EquipmentItem that = (EquipmentItem) object;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

