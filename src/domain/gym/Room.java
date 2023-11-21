package domain.gym;

import java.util.Objects;

public class Room
{
    protected int id;
    protected boolean occupied;

    protected RoomAccess roomAccess;

    private final static Room nullRoom = new Room();

    public Room(int id)
    {
        this.id = id;
    }

    public Room(int id, boolean occupied)
    {
        this.id = id;
        this.occupied = occupied;
        this.roomAccess = RoomAccess.forAll;
    }

    public Room(boolean occupied, RoomAccess roomAccess)
    {
        this.occupied = occupied;
        this.roomAccess = roomAccess;
    }

    public Room(int id, boolean occupied, RoomAccess roomAccess)
    {
        this.id = id;
        this.occupied = occupied;
        this.roomAccess = roomAccess;
    }

    public Room()
    {
        this.id = 0;
        this.occupied = false;
        this.roomAccess = RoomAccess.forAll;
    }

    @Override
    public String toString()
    {
        return "Room{" +
                "id=" + id +
                ", occupied=" + occupied +
                ", roomAccess=" + roomAccess +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return id == room.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RoomAccess getRoomAccess() {
        return roomAccess;
    }

    public void setRoomAccess(RoomAccess roomAccess) {
        this.roomAccess = roomAccess;
    }


    public Room copy()
    {
        return new Room(id, occupied);
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public static Room getNullRoom()
    {
        return nullRoom.copy();
    }
}
