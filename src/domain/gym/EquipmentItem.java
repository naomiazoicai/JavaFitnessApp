package domain.gym;

public class EquipmentItem
{
    private int ID;
    private String name;

    private static final EquipmentItem nullEquipmentItem = new EquipmentItem();

    public EquipmentItem(int ID, String name)
    {
        this.ID = ID;
        this.name = name;

    }

    public EquipmentItem(int id)
    {
        this.ID = id;
        this.name = "";
    }

    public EquipmentItem(String name)
    {
        this.ID = 0;
        this.name = name;

    }

    public EquipmentItem()
    {
        this.ID = 0;
        this.name = "null";
    }

    @Override
    public String toString()
    {
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

    public EquipmentItem copy() {
        return new EquipmentItem(ID, name);
    }

    public static EquipmentItem getNullEquipmentItem() {
        return nullEquipmentItem.copy();
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquipmentItem that = (EquipmentItem) o;
        return ID == that.ID;
    }


}
