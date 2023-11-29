package map.project.FitnessCenter.data.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
@Entity
public class Exercise {
    @Id @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private String muscleTrained;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn()
    private EquipmentItem equipmentUsed;
    @Column
    private int sets;
    @Column
    private int reps;

    public Exercise copy()
    {
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
