package map.project.FitnessCenter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Interface defining common CRUD (Create, Read, Update, Delete) operations for controllers managing entities in the fitness center.
 *
 * @param <Entity>  The type of the entity managed by the controller.
 * @param <IdType>  The type of the entity's identifier.
 */
public interface IController<Entity, IdType>
{
    /**
     * Handles the HTTP POST request to add a new entity.
     *
     * @param object The entity to be added.
     * @return ResponseEntity with the added entity and appropriate status.
     */
    @PostMapping
    ResponseEntity<Entity> add(@RequestBody Entity object);

    /**
     * Handles the HTTP PUT request to update an existing entity.
     *
     * @param id     The identifier of the entity to be updated.
     * @param object The updated entity.
     * @return ResponseEntity with the updated entity and appropriate status.
     */
    @PutMapping("/{id}")
    ResponseEntity<Entity> update(@PathVariable(value = "id") IdType id, @RequestBody Entity object);

    /**
     * Handles the HTTP DELETE request to delete an existing entity.
     *
     * @param id The identifier of the entity to be deleted.
     * @return ResponseEntity with the deleted entity and appropriate status.
     */
    @DeleteMapping("/{id}")
    ResponseEntity<Entity> delete(@PathVariable(value = "id") IdType id);

    /**
     * Handles the HTTP GET request to retrieve all entities.
     *
     * @return ResponseEntity with a list of entities and appropriate status.
     */
    @GetMapping
    ResponseEntity<List<Entity>> getAll();

    /**
     * Handles the HTTP GET request to retrieve an entity by its identifier.
     *
     * @param id The identifier of the entity to be retrieved.
     * @return ResponseEntity with the retrieved entity and appropriate status.
     */
    @GetMapping(("/{id}"))
    ResponseEntity<Entity> getEntityById(@PathVariable(value = "id") IdType id);
}
