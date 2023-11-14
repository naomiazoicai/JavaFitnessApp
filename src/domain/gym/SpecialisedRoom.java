package domain.gym;

public class SpecialisedRoom extends Room{
    private RoomType roomType;
    private int personCapacity;

    public SpecialisedRoom(int id, boolean occupied, RoomType roomType, int personCapacity) {
        super(id, occupied);
        this.roomType = roomType;
        this.personCapacity = personCapacity;
    }

    public SpecialisedRoom(boolean occupied, RoomType roomType, int personCapacity) {
        super(0, occupied);
        this.roomType = roomType;
        this.personCapacity = personCapacity;
    }

    public SpecialisedRoom()
    {
        super(0, false);
        this.roomType = RoomType.empty;
        this.personCapacity = 0;
    }

    @Override
    public String toString() {
        return "SpecialisedRoom{" + super.toString() +
                "roomType='" + roomType + '\'' +
                ", personCapacity=" + personCapacity +
                '}';
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
}
