package map.project.FitnessCenter.service.subjects;

import map.project.FitnessCenter.data.exceptions.ObjectAlreadyContained;
import map.project.FitnessCenter.data.exceptions.ObjectNotContained;
import map.project.FitnessCenter.data.model.Room;
import map.project.FitnessCenter.data.repository.RoomRepository;
import map.project.FitnessCenter.service.interfaces.BaseService;
import map.project.FitnessCenter.service.interfaces.IRoomService;
import map.project.FitnessCenter.service.observers.IObserverDeleteRoom;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class RoomService  extends BaseService<Room, Long> implements IRoomService, ISubjectDeleteRoom {

    private final RoomRepository roomRepository; //TODO add interface for repo

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
        return Optional.empty();
    }

    @Override
    public Optional<Room> delete(Long id) throws ObjectNotContained {
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
