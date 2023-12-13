package map.project.FitnessCenter.service;

import map.project.FitnessCenter.data.exceptions.ObjectAlreadyContained;
import map.project.FitnessCenter.data.exceptions.ObjectNotContained;
import map.project.FitnessCenter.data.model.SpecialisedRoom;
import map.project.FitnessCenter.data.model.SubscriptionType;
import map.project.FitnessCenter.data.repository.Jpa.SubscriptionTypeRepository;
import map.project.FitnessCenter.data.repository.intefaces.ICustomSubscriptionTypeRepository;
import map.project.FitnessCenter.service.observers.IObserverDeleteRoom;
import map.project.FitnessCenter.service.observers.IObserverDeletedSubscriptionType;
import map.project.FitnessCenter.service.subjects.ISubjectDeletedSubscriptionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SubscriptionTypeService extends BaseService<SubscriptionType, String>
implements IObserverDeleteRoom, ISubjectDeletedSubscriptionType {
    private final SpecialisedRoomService roomService;
    private final ICustomSubscriptionTypeRepository customSubscriptionTypeRepository;

    @Autowired
    public SubscriptionTypeService(SubscriptionTypeRepository repository, SpecialisedRoomService roomService)
    {
        super(repository);
        this.customSubscriptionTypeRepository = repository;
        this.roomService = roomService;
        roomService.addObserver(this);
    }

    @Override
    public Optional<SubscriptionType> add(SubscriptionType object) throws ObjectAlreadyContained {
        String name = object.getName();
        if (repository.existsById(name)) throw new ObjectAlreadyContained();
        validateAccessibleRooms(object);
        repository.save(object);
        return Optional.of(object);
    }

    private void validateAccessibleRooms(SubscriptionType object)
    {
        Set<SpecialisedRoom> newContainer = new HashSet<>();
        for (SpecialisedRoom room : object.getAccessibleRestrictedRooms())
        {
            Optional<SpecialisedRoom> existingRoom = roomService.getEntityByKey(room.getId());
            existingRoom.ifPresent(newContainer::add);
        }
        object.setAccessibleRestrictedRooms(newContainer);
    }

    @Override
    public Optional<SubscriptionType> update(String id, SubscriptionType object) throws ObjectNotContained, ObjectAlreadyContained {
        if (!repository.existsById(id)) throw new ObjectNotContained();
        Optional<SubscriptionType> oldObject = repository.findById(id).map(SubscriptionType::copy);
        validateAccessibleRooms(object);
        object.setName(id);
        repository.save(object);
        return oldObject;
    }

    @Override
    public Optional<SubscriptionType> delete(String id) throws ObjectNotContained {
        if (!repository.existsById(id)) throw new ObjectNotContained();
        Optional<SubscriptionType> oldObject = repository.findById(id);
        oldObject.ifPresent(this::notifySubscriptionTypeDeleted);
        repository.deleteById(id);
        return oldObject;
    }

    @Override
    public void updateRoomDeleted(SpecialisedRoom room) {
        Optional<List<SubscriptionType>> subs = customSubscriptionTypeRepository.getSubscriptionTypesContainingRoom(room);
       if (subs.isPresent())
       {
           for (SubscriptionType subscriptionType : subs.get()) {
               subscriptionType.removeRoom(room);
               repository.save(subscriptionType);
           }
       }
    }

    @Override
    public void addObserver(IObserverDeletedSubscriptionType observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(IObserverDeletedSubscriptionType observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifySubscriptionTypeDeleted(SubscriptionType subscriptionType) {
        for (IObserverDeletedSubscriptionType observer : observerList) observer.subscriptionTypeDeleted(subscriptionType);
    }
}
