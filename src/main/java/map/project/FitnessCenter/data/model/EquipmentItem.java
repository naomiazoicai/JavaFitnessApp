package map.project.FitnessCenter.data.model;

import jakarta.persistence.*;
import lombok.*;
import map.project.FitnessCenter.data.model.enums.Condition;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
@Entity
public class EquipmentItem
{
    @Id @GeneratedValue
    private Long id;
    @Column(nullable = false)   
    private String name;

    @Column (columnDefinition = "enum('NEW', 'GOOD', 'WORN', 'BROKEN', 'UNKNOWN')")
    @Enumerated(EnumType.STRING)
    private Condition condition;

//    public EquipmentItem(Long id, String name, Condition condition) {
//        if (condition == null) condition = Condition.UNKNOWN;
//        this.id = id;
//        this.name = name;
//        this.condition = condition;
//    }

    public EquipmentItem copy() {
        return new EquipmentItem(id, name, condition);
    }

//    public EquipmentItem copy() {
//        return new EquipmentItem(id, name);
//    }


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

//    public void setCondition(Condition condition) {
//        if (condition == null) condition = Condition.UNKNOWN;
//    }
}

