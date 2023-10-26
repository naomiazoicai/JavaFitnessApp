package domain.gym;

import java.util.ArrayList;
import java.util.Objects;

public class Workout {
    private int id;
    private ArrayList<Exercise> exercises;
    private Room room;

    public Workout(int id, ArrayList<Exercise> exercises, Room room) {
        this.id = id;
        this.exercises = exercises;
        this.room = room;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "id=" + id +
                ", exercises=" + exercises +
                ", room=" + room +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Workout workout = (Workout) o;
        return id == workout.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
