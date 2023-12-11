package map.project.FitnessCenter.data.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import lombok.*;
import map.project.FitnessCenter.data.model.enums.RoomType;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class SpecialisedRoom extends Room{
    @Enumerated
    @Column(nullable = false)
    private RoomType roomType = RoomType.empty;
    @Column(nullable = false)
    private int personCapacity = 0;
}