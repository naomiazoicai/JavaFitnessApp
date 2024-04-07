package map.project.FitnessCenter.data.repository.intefaces;

import org.springframework.data.domain.Example;

import java.util.List;
import java.util.Optional;

/**
 * Generic repository interface defining common CRUD operations for entities.
 *
 * @param <Entity> The type of entity.
 * @param <Id>     The type of entity's identifier.
 */
public interface IRepository<Entity, Id> {
    /**
     * Save an entity.
     *
     * @param entity The entity to be saved.
     * @param <E>    The type of the entity.
     * @return The saved entity.
     */
    <E extends Entity> E save(E entity);

    /**
     * Delete an entity by its identifier.
     *
     * @param id The identifier of the entity to be deleted.
     */
    void deleteById(Id id);

    /**
     * Check if an entity exists based on the provided example.
     *
     * @param entity The example entity.
     * @param <E>    The type of the entity.
     * @return True if the entity exists; otherwise, false.
     */
    <E extends Entity> boolean exists(Example<E> entity);


    /**
     * Find an entity by its identifier.
     *
     * @param id The identifier of the entity to be found.
     * @return An optional containing the found entity, or empty if not found.
     */
    Optional<Entity> findById(Id id);

    /**
     * Get a list of all entities.
     *
     * @return A list of entities.
     */
    List<Entity> findAll();


    /**
     * Check if an entity with the given identifier exists.
     *
     * @param id The identifier to check.
     * @return True if the entity exists; otherwise, false.
     */
    boolean existsById(Id id);
}
