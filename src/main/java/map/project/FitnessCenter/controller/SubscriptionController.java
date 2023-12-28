package map.project.FitnessCenter.controller;

import map.project.FitnessCenter.data.exceptions.ObjectAlreadyContained;
import map.project.FitnessCenter.data.exceptions.ObjectNotContained;
import map.project.FitnessCenter.data.model.Subscription;
import map.project.FitnessCenter.service.interfaces.ISubscriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

/**
 * Controller class for managing subscription-related operations in the fitness center.
 * This controller implements the common CRUD (Create, Read, Update, Delete) operations for Subscription entities.
 *
 */
public class SubscriptionController implements IController<Subscription, Long>{
    private final ISubscriptionService service;

    public SubscriptionController(ISubscriptionService service)
    {
        this.service = service;
    }

    @Override
    public ResponseEntity<Subscription> add(Subscription object) {
        try {
            Optional<Subscription> addedObject = service.add(object);
            return addedObject.map(type
                    -> ResponseEntity.status(HttpStatus.CREATED).body(type)).orElseGet(()
                    -> ResponseEntity.internalServerError().build()
            );
        } catch (ObjectAlreadyContained exception)
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @Override
    public ResponseEntity<Subscription> update(Long id, Subscription object) {
        try {
            Optional<Subscription> oldObject = service.update(id, object);
            return oldObject.map(type
                    -> ResponseEntity.status(HttpStatus.OK).body(oldObject.get())).orElseGet(()
                    -> ResponseEntity.internalServerError().build()
            );
        } catch (ObjectNotContained e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (ObjectAlreadyContained e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @Override
    public ResponseEntity<Subscription> delete(Long id) {
        try {
            Optional<Subscription> deletedObject = service.delete(id);
            return deletedObject.map(type
                    -> ResponseEntity.status(HttpStatus.OK).body(deletedObject.get())).orElseGet(()
                    -> ResponseEntity.internalServerError().build()
            );
        } catch (ObjectNotContained e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Override
    public ResponseEntity<List<Subscription>> getAll() {
        return service.getAll()
                .map(list -> ResponseEntity.ok().body(list))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Subscription> getEntityById(Long id) {
        return service.getEntityByKey(id)
                .map(equipmentItem -> ResponseEntity.ok().body(equipmentItem))
                .orElse(ResponseEntity.notFound().build());
    }
}