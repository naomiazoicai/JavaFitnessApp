package domain.gym;

import java.util.Objects;

public class Room {
    private int id;
    private boolean cleaned;
    private boolean occupied;

    public Room(int id, boolean cleaned, boolean occupied) {
        this.id = id;
        this.cleaned = cleaned;
        this.occupied = occupied;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", cleaned=" + cleaned +
                ", occupied=" + occupied +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return id == room.id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCleaned() {
        return cleaned;
    }

    public void setCleaned(boolean cleaned) {
        this.cleaned = cleaned;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}
