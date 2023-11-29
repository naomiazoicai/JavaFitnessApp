package map.project.FitnessCenter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IController<Type, KeyType>
{
    ResponseEntity<Type> add(Type object); //entity (POST)

    ResponseEntity<Type> update(@PathVariable(value = "id") KeyType id, Type object);  //entity/{id} (PUT)

    ResponseEntity<Type> delete(@PathVariable(value = "id") KeyType id);  //entity/{id} (DELETE)

    ResponseEntity<List<Type>> getAll();  //entity (GET)

    ResponseEntity<Type> getEntityById(KeyType id);  //entity/{id} (GET)  - by id or sth else
}
