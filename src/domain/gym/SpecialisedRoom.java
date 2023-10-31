package domain.gym;

public class SpecialisedRoom extends Room{
    private String roomType;
    private int personCapacity;

    public SpecialisedRoom(int id, boolean cleaned, boolean occupied, String roomType, int personCapacity) {
        super(id, cleaned, occupied);
        this.roomType = roomType;
        this.personCapacity = personCapacity;
    }

    @Override
    public String toString() {
        return "SpecialisedRoom{" + super.toString() +
                "roomType='" + roomType + '\'' +
                ", personCapacity=" + personCapacity +
                '}';
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getPersonCapacity() {
        return personCapacity;
    }

    public void setPersonCapacity(int personCapacity) {
        this.personCapacity = personCapacity;
    }
}
