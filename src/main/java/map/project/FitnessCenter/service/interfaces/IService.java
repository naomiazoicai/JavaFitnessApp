package map.project.FitnessCenter.service.interfaces;

import map.project.FitnessCenter.data.exceptions.ObjectAlreadyContained;
import map.project.FitnessCenter.data.exceptions.ObjectNotContained;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * A generic interface defining operations related to the given generic object.
 */
@Service
public interface IService<Entity, IdType>
{
    /**
     * Adds an entity to the repository, ensuring it does not already exist.
     *
     * @param object The entity to be added to the repository.
     * @return An Optional containing the added entity if successful or null if it was not.
     * @throws ObjectAlreadyContained If the entity already exists in the repository.
     *                               In this case, the repository remains unchanged.
     */
    Optional<Entity> add(Entity object) throws ObjectAlreadyContained;

    /**
     * Updates an entity in the repository, ensuring the entity with the given ID exists,
     * and that the updated entity does not already exist in the repository.
     *
     * @param id The unique identifier of the entity to be updated.
     * @param object The updated entity to be persisted in the repository.
     * @return An Optional containing the updated entity if the update is successful or null if it was not.
     * @throws ObjectNotContained If no entity with the given ID is found in the repository.
     *                           In this case, the repository remains unchanged.
     * @throws ObjectAlreadyContained If an entity with the updated information already exists in the repository.
     *                               In this case, the repository remains unchanged.
     */
    Optional<Entity> update(IdType id, Entity object) throws ObjectNotContained, ObjectAlreadyContained;

    /**
     *  Deletes an entity from the repository, ensuring the entity with the given ID exists
     * @param id The unique identifier of the entity to be updated.
     * @return An optional containing the deleted entity, if the delete is successful or null if it was not.
     * @throws ObjectNotContained If no entity with the given ID is found in the repository.
     *                           In this case, the repository remains unchanged.
     */
    Optional<Entity> delete(IdType id) throws ObjectNotContained;

    /**
     * Gets all stored entities in the repository.
     * @return An optional containing a list of the stored entities.
     */
    Optional<List<Entity>> getAll();

    /**
     * Gets an entity from the repository identified with given ID.
     * @param id The unique identifier of the entity to be searched.
     * @return An optional containing the searched entity or null if it was not found
     */
    Optional<Entity> getEntityByKey(IdType id);
}
