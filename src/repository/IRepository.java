package repository;

import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;

import java.util.ArrayList;

public interface IRepository<Type> {

    void add(Type object) throws ObjectAlreadyContained;

    void update(Type object) throws ObjectNotContained;

    void delete(Type object) throws ObjectNotContained;
    ArrayList<Type> getAll();
}
