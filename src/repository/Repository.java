package repository;

import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;

import java.util.ArrayList;

public abstract class Repository<Type> implements IRepository<Type>
{
    protected final ArrayList<Type> arrayList = new ArrayList<>();

    @Override
    public void addEntity(Type object) throws ObjectAlreadyContained
    {
        if (arrayList.contains(object)) throw new ObjectAlreadyContained();
        arrayList.add(object);
    }

    @Override
    public void updateEntity(Type object) throws ObjectNotContained
    {
        if (!arrayList.contains(object)) throw new ObjectNotContained();
        arrayList.remove(object);
        arrayList.add(object);
    }

    @Override
    public void deleteEntity(Type object) throws ObjectNotContained
    {
        if (!arrayList.contains(object)) throw new ObjectNotContained();
        arrayList.remove(object);
    }

    @Override
    public ArrayList<Type> getAllEntities()
    {
        return new ArrayList<>(arrayList);
    }
}
