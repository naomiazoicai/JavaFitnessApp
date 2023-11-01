package repository;

import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;

import java.util.ArrayList;

public abstract class Repository<Type> implements IRepository<Type>
{
    protected final ArrayList<Type> arrayList = new ArrayList<>();

    @Override
    public void add(Type object) throws ObjectAlreadyContained
    {
        if (arrayList.contains(object)) throw new ObjectAlreadyContained();
        arrayList.add(object);
    }

    @Override
    public void update(Type object) throws ObjectNotContained
    {
        if (!arrayList.contains(object)) throw new ObjectNotContained();
        arrayList.remove(object);
        arrayList.add(object);
    }

    @Override
    public void delete(Type object) throws ObjectNotContained
    {
        if (!arrayList.contains(object)) throw new ObjectNotContained();
        arrayList.remove(object);
    }

    @Override
    public ArrayList<Type> getAll()
    {
        return new ArrayList<>(arrayList);
    }
}
