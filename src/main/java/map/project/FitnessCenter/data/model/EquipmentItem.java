package map.project.FitnessCenter.data.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
@Entity
public class EquipmentItem
{
    @Id @GeneratedValue
    private Long id;
    @Column
    private String name;

    private static final EquipmentItem nullEquipmentItem = new EquipmentItem();

    public EquipmentItem(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public EquipmentItem(Long id) {
        this.id = id;
        this.name = "";
    }

    public EquipmentItem(String name) {
        this.id = 0L;
        this.name = name;

    }

    public EquipmentItem() {
        this.id = 0L;
        this.name = "null";
    }

    @Override
    public String toString() {
        return "EquipmentItem{" +
                "ID=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setId(Long ID) {
        this.id = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EquipmentItem copy() {
        return new EquipmentItem(id, name);
    }

    public static EquipmentItem getNullEquipmentItem() {
        return nullEquipmentItem.copy();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquipmentItem that = (EquipmentItem) o;
        return id.equals(that.id);
    }
}

