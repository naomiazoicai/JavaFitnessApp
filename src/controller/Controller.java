package controller;

import controller.interfaces.IController;
import repository.Repository;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;

import java.util.ArrayList;

public abstract class Controller<Type> implements IController<Type>
{
    final protected Repository<Type> repository;

    protected Controller(Repository<Type> repository)
    {
        this.repository = repository;
    }

    @Override
    public void add(Type object) throws ObjectAlreadyContained
    {
        repository.addEntity(object);
    }

    @Override
    public void update(Type object) throws ObjectNotContained
    {
        repository.updateEntity(object);
    }

    @Override
    public void delete(Type object) throws ObjectNotContained
    {
        repository.deleteEntity(object);
    }

    @Override
    public ArrayList<Type> getAll()
    {
        return repository.getAllEntities();
    }
}
