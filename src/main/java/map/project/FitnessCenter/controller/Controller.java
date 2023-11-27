package map.project.FitnessCenter.controller;

import map.project.FitnessCenter.data.exceptions.ObjectAlreadyContained;
import map.project.FitnessCenter.data.exceptions.ObjectNotContained;
import map.project.FitnessCenter.service.interfaces.IService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public abstract class Controller<Type> implements IController<Type>
{
    IService<Type> service;
    @Override
    public ResponseEntity<Type> add(Type object) {
        try {
            Optional<Type> addedObject = service.add(object);
            return addedObject.map(type
                    -> ResponseEntity.status(HttpStatus.CREATED).body(type)).orElseGet(()
                    -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
            );
        } catch (ObjectAlreadyContained exception)
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @Override
    public ResponseEntity<Type> update(@PathVariable(value = "id") Long id, Type object) {
        try {
            Optional<Type> oldObject = service.update(id, object);
            return oldObject.map(type
                    -> ResponseEntity.status(HttpStatus.OK).body(oldObject.get())).orElseGet(()
                    -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
            );
        } catch (ObjectNotContained e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Override
    public ResponseEntity<Type> delete(@PathVariable(value = "id") Long id) {
        try {
            Optional<Type> deletedObject = service.delete(id);
            return deletedObject.map(type
                    -> ResponseEntity.status(HttpStatus.OK).body(deletedObject.get())).orElseGet(()
                    -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
            );
        } catch (ObjectNotContained e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Override
    public ResponseEntity<List<Type>> getAll() {
        return service.getAll()
                .map(list -> ResponseEntity.ok().body(list))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Type> getEntityById(Long id) {
        return service.getEntityById(id)
                .map(equipmentItem -> ResponseEntity.ok().body(equipmentItem))
                .orElse(ResponseEntity.notFound().build());
    }
}
