package map.project.FitnessCenter.service;

import map.project.FitnessCenter.data.exceptions.ObjectAlreadyContained;
import map.project.FitnessCenter.data.exceptions.ObjectNotContained;
import map.project.FitnessCenter.data.model.Person;
import map.project.FitnessCenter.data.repository.PersonRepository;
import map.project.FitnessCenter.service.interfaces.BaseService;
import map.project.FitnessCenter.service.interfaces.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PersonService extends BaseService<Person, String> implements IPersonService {
    @Autowired
    public PersonService(PersonRepository repository)
    {
        super(repository);
    }

    @Override
    public Optional<Person> add(Person object) throws ObjectAlreadyContained {
        if (usernameExists(object.getUsername())) throw new ObjectAlreadyContained();
        repository.save(object);
        return Optional.of(object);
    }

    @Override
    public Optional<Person> update(String id, Person object) throws ObjectNotContained, ObjectAlreadyContained {
        Optional<Person> oldObject = repository.findById(id).map(Person::copy);
        object.setUsername(id);
        repository.save(object);
        return oldObject;
    }

    @Override
    public Optional<Person> delete(String id) throws ObjectNotContained {
        if (!usernameExists(id)) throw new ObjectNotContained();
        Optional<Person> oldObject = repository.findById(id);
        repository.deleteById(id);
        return oldObject;
    }

    @Override
    public boolean usernameExists(String username) {
        return repository.existsById(username);
    }
}
