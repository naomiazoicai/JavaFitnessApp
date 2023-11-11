package controller.interfaces;

import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;

import java.util.ArrayList;

public interface IController<Type>
{
    void add(Type object) throws ObjectAlreadyContained;

    void update(Type object) throws ObjectNotContained, ObjectAlreadyContained;

    void delete(Type object) throws ObjectNotContained, ObjectAlreadyContained;

    ArrayList<Type> getAll();
}
