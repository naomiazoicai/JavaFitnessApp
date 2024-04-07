package map.project.FitnessCenter.data.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

/**
 * Entity class representing an exercise in the fitness center.
 **/
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
@Entity
public class Exercise {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column
    private String muscleTrained = "";
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn()
    private EquipmentItem equipmentUsed;
    @Column
    private int sets = 0;
    @Column
    private int reps = 0;

    public Exercise copy() {
        return new Exercise(id, name, muscleTrained, equipmentUsed, sets, reps);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Exercise exercise = (Exercise) object;
        return Objects.equals(name, exercise.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
