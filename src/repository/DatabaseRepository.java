package repository;

import dao.IDao;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;

import java.util.ArrayList;

public class DatabaseRepository<Type> implements IRepository<Type>
{
    private final IDao<Type> dao;

    public DatabaseRepository(IDao<Type> dao)
    {
        this.dao = dao;
    }

    @Override
    public void addEntity(Type object) throws ObjectAlreadyContained
    {
        dao.addEntity(object);
    }

    @Override
    public void updateEntity(Type object) throws ObjectNotContained
    {
        dao.updateEntity(object);
    }

    @Override
    public void deleteEntity(Type object) throws ObjectNotContained
    {
        dao.deleteEntity(object);
    }

    @Override
    public ArrayList<Type> getAllEntities()
    {
        return dao.getAllEntities();
    }
}
