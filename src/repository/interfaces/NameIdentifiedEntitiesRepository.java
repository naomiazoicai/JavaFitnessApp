package repository.interfaces;

import java.util.ArrayList;

public interface NameIdentifiedEntitiesRepository<Entity>{
    Boolean keyNameInRepo(String keyName);

    ArrayList<Entity> searchByPartialKeyName(String keyName);

    Entity searchByKeyName(String keyName);
}
