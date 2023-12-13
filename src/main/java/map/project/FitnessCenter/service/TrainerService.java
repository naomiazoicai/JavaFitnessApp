package map.project.FitnessCenter.service;

import map.project.FitnessCenter.data.exceptions.ObjectAlreadyContained;
import map.project.FitnessCenter.data.exceptions.ObjectNotContained;
import map.project.FitnessCenter.data.model.Trainer;
import map.project.FitnessCenter.data.repository.Jpa.PersonRepository;
import map.project.FitnessCenter.data.repository.Jpa.TrainerRepository;
import map.project.FitnessCenter.service.interfaces.ITrainerService;
import map.project.FitnessCenter.service.observers.IObserverDeletedTrainer;
import map.project.FitnessCenter.service.subjects.ISubjectDeletedTrainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TrainerService extends PersonService<Trainer> implements ITrainerService, ISubjectDeletedTrainer {
    @Autowired
    public TrainerService(TrainerRepository repository, PersonRepository personRepository) {
        super(repository, personRepository);
    }

    @Override
    public Optional<Trainer> update(String id, Trainer object) throws ObjectNotContained, ObjectAlreadyContained {
        Optional<Trainer> oldObject = repository.findById(id).map(Trainer::copy);
        object.setUsername(id);
        repository.save(object);
        return oldObject;
    }

    @Override
    public Optional<Trainer> delete(String id) throws ObjectNotContained {
        super.getEntityByKey(id).ifPresent(this::notifyTrainerDeleted);
        return super.delete(id);
    }

    @Override
    public Trainer getTrainerByUsername(String username) {
        Optional<Trainer> trainer = getEntityByKey(username);
        return trainer.orElse(null);
    }

    @Override
    public void addObserver(IObserverDeletedTrainer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(IObserverDeletedTrainer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyTrainerDeleted(Trainer trainer) {
        for (IObserverDeletedTrainer observer : observerList) observer.trainerDeleted(trainer);
    }
}
