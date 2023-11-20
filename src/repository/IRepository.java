package repository;

import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;

import java.util.ArrayList;

public interface IRepository<Type> {

    void addEntity(Type object) throws ObjectAlreadyContained;

    void updateEntity(Type object) throws ObjectNotContained;

    void deleteEntity(Type object) throws ObjectNotContained;
    ArrayList<Type> getAllEntities();
}
