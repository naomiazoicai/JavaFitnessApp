package repository;

import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;

import java.util.ArrayList;

public interface IRepository<Type> {

    public void add(Type object) throws ObjectAlreadyContained;

    public void update(Type object) throws ObjectNotContained;

    public void delete(Type object) throws ObjectNotContained;
    public ArrayList<Type> getAll();
}
