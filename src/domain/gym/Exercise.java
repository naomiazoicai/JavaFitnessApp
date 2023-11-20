package domain.gym;

import java.util.Objects;

public class Exercise {
    private final static Exercise nullExercise = new Exercise();

    private int id;
    private String name;
    private String muscleTrained;
    private EquipmentItem equipmentUsed;
    private int sets;
    private int reps;

    public Exercise(int id, String name, String muscleTrained, EquipmentItem equipmentUsed, int sets, int reps) {
        this.id = id;
        this.name = name;
        this.muscleTrained = muscleTrained;
        this.equipmentUsed = equipmentUsed;
        this.sets = sets;
        this.reps = reps;
    }

    public Exercise(String name, String muscleTrained, EquipmentItem equipmentUsed, int sets, int reps) {
        this.name = name;
        this.muscleTrained = muscleTrained;
        this.equipmentUsed = equipmentUsed;
        this.sets = sets;
        this.reps = reps;
    }

    public Exercise(int id)
    {
        this.id = id;
        this.name = "null";
        this.muscleTrained = "null";
        this.equipmentUsed = new EquipmentItem();
        this.sets = 0;
        this.reps = 0;
    }

    public Exercise()
    {
        this.id = 0;
        this.name = "null";
        this.muscleTrained = "null";
        this.equipmentUsed = new EquipmentItem();
        this.sets = 0;
        this.reps = 0;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", muscleTrained='" + muscleTrained + '\'' +
                ", equipmentUsed=" + equipmentUsed +
                ", sets=" + sets +
                ", reps=" + reps +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMuscleTrained() {
        return muscleTrained;
    }

    public void setMuscleTrained(String muscleTrained) {
        this.muscleTrained = muscleTrained;
    }

    public EquipmentItem getEquipmentUsed() {
        return equipmentUsed;
    }

    public void setEquipmentUsed(EquipmentItem equipmentUsed) {
        this.equipmentUsed = equipmentUsed;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public Exercise copy()
    {
        return new Exercise(id, name, muscleTrained, equipmentUsed, sets, reps);
    }

    public static Exercise getNullExercise()
    {
        return nullExercise.copy();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exercise exercise = (Exercise) o;
        return id == exercise.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
