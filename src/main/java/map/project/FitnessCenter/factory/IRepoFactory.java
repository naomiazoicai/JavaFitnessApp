package map.project.FitnessCenter.factory;

import map.project.FitnessCenter.data.repository.intefaces.IRepository;

public interface IRepoFactory<Entity, Id> {
    IRepository<Entity, Id> buildIRepository(RepoTypes type);
}
