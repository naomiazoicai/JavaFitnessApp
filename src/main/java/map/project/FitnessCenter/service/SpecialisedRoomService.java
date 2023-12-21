package map.project.FitnessCenter.service;

import map.project.FitnessCenter.data.exceptions.ObjectAlreadyContained;
import map.project.FitnessCenter.data.exceptions.ObjectNotContained;
import map.project.FitnessCenter.data.model.SpecialisedRoom;
import map.project.FitnessCenter.data.repository.Jpa.SpecialisedRoomRepository;
import map.project.FitnessCenter.data.repository.intefaces.ISpecialisedRoomRepository;
import map.project.FitnessCenter.service.observers.IObserverDeleteRoom;
import map.project.FitnessCenter.service.subjects.ISubjectDeleteRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service class for managing the rooms of the fitness center.
 */
@Service
public class SpecialisedRoomService extends BaseService<SpecialisedRoom, Long> implements ISubjectDeleteRoom {

    private final ISpecialisedRoomRepository specialisedRoomRepository;

    @Autowired
    public SpecialisedRoomService(SpecialisedRoomRepository repository) {
        super(repository);
        this.specialisedRoomRepository = repository;
    }

    @Override
    public Optional<SpecialisedRoom> add(SpecialisedRoom object){
        specialisedRoomRepository.save(object);
        return Optional.of(object);
    }

    @Override
    public Optional<SpecialisedRoom> update(Long id, SpecialisedRoom object) throws ObjectNotContained, ObjectAlreadyContained {
        if (!repository.existsById(id)) throw new ObjectNotContained();
        // Save old object
        Optional<SpecialisedRoom> oldObject = getEntityByKey(id).map(SpecialisedRoom::copy);
        // Update
        object.setId(id);
        repository.save(object);
        return oldObject;
    }


    @Override
    public Optional<SpecialisedRoom> delete(Long id) throws ObjectNotContained {
        if (!repository.existsById(id)) throw new ObjectNotContained();
        Optional<SpecialisedRoom> oldObject = repository.findById(id);
        oldObject.ifPresent(this::notifyRoomDeleted);
        repository.deleteById(id);
        return oldObject;
    }

    @Override
    public void addObserver(IObserverDeleteRoom observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(IObserverDeleteRoom observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyRoomDeleted(SpecialisedRoom room) {
        for (IObserverDeleteRoom observer : observerList) observer.updateRoomDeleted(room);
    }
}
