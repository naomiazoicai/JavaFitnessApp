package map.project.FitnessCenter.data.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
@Entity
public class Room {
    @Id @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private boolean occupied;

    @Enumerated
    @Column(nullable = false)
    private RoomAccess roomAccess = RoomAccess.forAll; // Default value

    public Room copy() {
        return new Room(id, occupied, roomAccess);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(id, room.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
