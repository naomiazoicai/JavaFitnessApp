package map.project.FitnessCenter.data.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
@Entity
public class EquipmentItem
{
    @Id @GeneratedValue
    private Long id;
    @Column
    private String name;

    @Override
    public String toString() {
        return "EquipmentItem{" +
                "ID=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public EquipmentItem copy() {
        return new EquipmentItem(id, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquipmentItem that = (EquipmentItem) o;
        return name.equals(that.name);
    }
}

