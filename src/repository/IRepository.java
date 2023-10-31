package repository;

import domain.gym.EquipmentItem;

import java.util.ArrayList;
import java.util.HashSet;

public interface IRepository<Type> {

    public void add(Type object);

    public void update(Type object);

    public void delete(Type object);
    public ArrayList<Type> getAll();
}
