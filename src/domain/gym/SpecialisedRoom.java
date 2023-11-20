package domain.gym;

public class SpecialisedRoom extends Room{
    private RoomType roomType;
    private int personCapacity;

    private final static SpecialisedRoom nullSpecialisedRoom = new SpecialisedRoom();

    public SpecialisedRoom(int id, boolean occupied, RoomType roomType, int personCapacity) {
        super(id, occupied);
        this.roomType = roomType;
        this.personCapacity = personCapacity;
    }

    public SpecialisedRoom(boolean occupied, RoomAccess roomAccess, RoomType roomType, int personCapacity) {
        super(occupied, roomAccess);
        this.roomType = roomType;
        this.personCapacity = personCapacity;
    }

    public SpecialisedRoom(int id, boolean occupied, RoomAccess roomAccess, RoomType roomType, int personCapacity) {
        super(id, occupied, roomAccess);
        this.roomType = roomType;
        this.personCapacity = personCapacity;
    }

    public SpecialisedRoom(boolean occupied, RoomType roomType, int personCapacity) {
        super(0, occupied);
        this.roomType = roomType;
        this.personCapacity = personCapacity;
    }

    public SpecialisedRoom(int id)
    {
        super(id, false);
        this.roomType = RoomType.empty;
        this.personCapacity = 0;
    }

    public SpecialisedRoom()
    {
        super();
        this.roomType = RoomType.empty;
        this.personCapacity = 0;
    }

    @Override
    public String toString() {
        return "SpecialisedRoom{" +
                " id=" + id +
                ", roomType=" + roomType +
                ", personCapacity=" + personCapacity +
                ", occupied=" + occupied +
                ", roomAccess=" + roomAccess +
               " }";
    }

    public SpecialisedRoom copy()
    {
        return new SpecialisedRoom(id, occupied, roomType, personCapacity);
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public int getPersonCapacity() {
        return personCapacity;
    }

    public void setPersonCapacity(int personCapacity) {
        this.personCapacity = personCapacity;
    }

    public static SpecialisedRoom getNullSpecialisedRoom()
    {
        return nullSpecialisedRoom.copy();
    }
}
