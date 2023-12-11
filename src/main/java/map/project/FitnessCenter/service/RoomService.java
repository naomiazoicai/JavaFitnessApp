package map.project.FitnessCenter.service;

import map.project.FitnessCenter.data.exceptions.ObjectAlreadyContained;
import map.project.FitnessCenter.data.exceptions.ObjectNotContained;
import map.project.FitnessCenter.data.model.Room;
import map.project.FitnessCenter.data.repository.Jpa.RoomRepository;
import map.project.FitnessCenter.data.repository.intefaces.IRoomRepository;
import map.project.FitnessCenter.service.observers.IObserverDeleteRoom;
import map.project.FitnessCenter.service.subjects.ISubjectDeleteRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomService  extends BaseService<Room, Long> implements ISubjectDeleteRoom {

    private final IRoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository repository) {
        super(repository);
        this.roomRepository = repository;
       //addObserver(roomService);
    }

    @Override
    public Optional<Room> add(Room object){
        roomRepository.save(object);
        return Optional.of(object);
    }


    @Override
    public Optional<Room> update(Long id, Room object) throws ObjectNotContained, ObjectAlreadyContained {
        // TODO
        return Optional.empty();
    }

    @Override
    public Optional<Room> delete(Long id) throws ObjectNotContained {
        // TODO
        return Optional.empty();
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
    public void notifyRoomDeleted(Room room) {
        for (IObserverDeleteRoom observer : observerList) observer.updateRoomDeleted(room);
    }

}
