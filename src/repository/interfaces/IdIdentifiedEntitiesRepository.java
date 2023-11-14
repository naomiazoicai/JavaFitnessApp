package repository.interfaces;

import repository.exceptions.ObjectNotContained;

public interface IdIdentifiedEntitiesRepository<Entity>{
    Boolean idInRepo(int id);

    Entity searchById(int id) throws ObjectNotContained;

    int generateNextId();
}
