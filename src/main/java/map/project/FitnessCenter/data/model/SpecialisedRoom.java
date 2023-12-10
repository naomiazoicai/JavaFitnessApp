package map.project.FitnessCenter.data.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import lombok.*;
import map.project.FitnessCenter.data.model.enums.RoomType;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
@Entity
public class SpecialisedRoom extends Room{
    @Enumerated
    @Column(nullable = false)
    private RoomType roomType;

    @Column(nullable = false)
    private int personCapacity;

    @Enumerated
    @Column(nullable = false)
    private final static SpecialisedRoom nullSpecialisedRoom = new SpecialisedRoom();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SpecialisedRoom that = (SpecialisedRoom) o;
        return personCapacity == that.personCapacity && roomType == that.roomType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), roomType, personCapacity);
    }
}