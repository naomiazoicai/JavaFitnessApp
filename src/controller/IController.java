package controller;

public interface IController<Type>
{
    void add(Type object);

    void update(Type object);

    void delete(Type object);
}
