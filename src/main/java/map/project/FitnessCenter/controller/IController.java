package map.project.FitnessCenter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IController<Entity, IdType>
{
    ResponseEntity<Entity> add(Entity object); //entity (POST)

    ResponseEntity<Entity> update(@PathVariable(value = "id") IdType id, Entity object);  //entity/{id} (PUT)

    ResponseEntity<Entity> delete(@PathVariable(value = "id") IdType id);  //entity/{id} (DELETE)

    ResponseEntity<List<Entity>> getAll();  //entity (GET)

    ResponseEntity<Entity> getEntityById(IdType id);  //entity/{id} (GET)  - by id or sth else
}
