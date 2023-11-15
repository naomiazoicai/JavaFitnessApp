package domain.money;

import domain.gym.Room;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class SubscriptionType {
    private String name;
    private String description;
    private double price;

    public static SubscriptionType nullSubscriptionType = new SubscriptionType();

    private final HashSet<Room> accessibleRestrictedRooms = new HashSet<>();

    public SubscriptionType(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public SubscriptionType(){
        this.name = "";
        this.description = "";
        this.price = 0;
    }

    public void addRoomAccess(Room room)
    {
        accessibleRestrictedRooms.add(room);
    }

    public void removeRoomAccess(Room room)
    {
        accessibleRestrictedRooms.remove(room);
    }

    @Override
    public String toString() {
        return "SubscriptionType{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", restrictedAccessibleRooms=" + accessibleRestrictedRooms +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubscriptionType that = (SubscriptionType) o;
        return Objects.equals(name, that.name);
    }

    public SubscriptionType copy()
    {
        return new SubscriptionType(name, description, price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<Room> getAccessibleRestrictedRooms() {
        return new ArrayList<>(accessibleRestrictedRooms);
    }

}
