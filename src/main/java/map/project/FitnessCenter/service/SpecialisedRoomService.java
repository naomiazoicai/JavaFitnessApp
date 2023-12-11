package map.project.FitnessCenter.service;

import map.project.FitnessCenter.data.exceptions.ObjectAlreadyContained;
import map.project.FitnessCenter.data.exceptions.ObjectNotContained;
import map.project.FitnessCenter.data.model.Room;
import map.project.FitnessCenter.data.model.SpecialisedRoom;
import map.project.FitnessCenter.data.repository.Jpa.SpecialisedRoomRepository;
import map.project.FitnessCenter.data.repository.intefaces.ISpecialisedRoomRepository;
import map.project.FitnessCenter.service.observers.IObserverDeleteRoom;
import map.project.FitnessCenter.service.subjects.ISubjectDeleteRoom;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class SpecialisedRoomService extends BaseService<SpecialisedRoom, Long> implements ISubjectDeleteRoom {

    private final ISpecialisedRoomRepository specialisedRoomRepository;

    @Autowired
    public SpecialisedRoomService(SpecialisedRoomRepository repository) {
        super(repository);
        this.specialisedRoomRepository = repository;
        //addObserver(specialisedRoomService);
    }

    @Override
    public Optional<SpecialisedRoom> add(SpecialisedRoom object){
        specialisedRoomRepository.save(object);
        return Optional.of(object);
    }

    @Override
    public Optional<SpecialisedRoom> update(Long id, SpecialisedRoom object) throws ObjectNotContained, ObjectAlreadyContained {
//        if (!repository.existsById(id)) throw new ObjectNotContained();
//        // Save old object
//        Optional<SpecialisedRoom> oldObject = repository.findById(id).map(Room::copy);
//        // Update
//        object.setId(id);
//        repository.save(object);
//        return oldObject;
        return Optional.empty();

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

    }

    @Override
    public void removeObserver(IObserverDeleteRoom observer) {

    }

    @Override
    public void notifyRoomDeleted(Room room) {

    }
}
