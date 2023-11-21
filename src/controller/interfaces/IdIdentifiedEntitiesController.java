package controller.interfaces;

public interface IdIdentifiedEntitiesController<Entity>
{
    boolean idInRepo(int id);

    Entity searchById(int id);
}
