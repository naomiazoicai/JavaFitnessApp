package map.project.FitnessCenter.service;

import map.project.FitnessCenter.data.exceptions.ObjectAlreadyContained;
import map.project.FitnessCenter.data.exceptions.ObjectNotContained;
import map.project.FitnessCenter.data.model.SubscriptionType;
import map.project.FitnessCenter.data.repository.Jpa.SubscriptionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class SubscriptionTypeService extends BaseService<SubscriptionType, String> {
    @Autowired
    public SubscriptionTypeService(SubscriptionTypeRepository repository)
    {
        super(repository);
    }

    @Override
    public Optional<SubscriptionType> add(SubscriptionType object) throws ObjectAlreadyContained {
        String name = object.getName();
        if (repository.existsById(name)) throw new ObjectAlreadyContained();
        repository.save(object);
        return Optional.of(object);
    }

    @Override
    public Optional<SubscriptionType> update(String id, SubscriptionType object) throws ObjectNotContained, ObjectAlreadyContained {
        if (!repository.existsById(id)) throw new ObjectNotContained();
        Optional<SubscriptionType> oldObject = repository.findById(id).map(SubscriptionType::copy);
        object.setName(id);
        repository.save(object);
        return oldObject;
    }

    @Override
    public Optional<SubscriptionType> delete(String id) throws ObjectNotContained {
        if (!repository.existsById(id)) throw new ObjectNotContained();
        Optional<SubscriptionType> oldObject = repository.findById(id);
        repository.deleteById(id);
        return oldObject;
    }
}
