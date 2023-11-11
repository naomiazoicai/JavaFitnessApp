package controller.interfaces;

import java.util.ArrayList;

public interface NameIdentifiedEntitiesController<Entity> {
    ArrayList<Entity> searchByPartialKeyName(String keyName);

    Entity searchByKeyName(String keyName);

    Boolean keyNameInRepo(String keyName);
}
