package domain.gym;

public class EquipmentItem {
    private int ID;
    private String name;


    public EquipmentItem(int ID, String name) {
        this.ID = ID;
        this.name = name;

    }

    @Override
    public String toString() {
        return "EquipmentItem{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquipmentItem that = (EquipmentItem) o;
        return ID == that.ID;
    }


}
