package map.project.FitnessCenter.factory;

import map.project.FitnessCenter.data.repository.intefaces.IRepository;

/**
 * Factory interface for creating repositories.
 *
 * @param <Entity> The type of entity for the repository.
 * @param <Id>     The type of the entity's identifier.
 */
public interface IRepoFactory<Entity, Id> {

    /**
     * Build and return a repository based on the specified repository type.
     *
     * @param type The type of repository to build.
     * @return The created repository.
     */
    IRepository<Entity, Id> buildIRepository(RepoTypes type);
}
