package map.project.FitnessCenter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IController<Entity, IdType>
{
    @PostMapping
    ResponseEntity<Entity> add(@RequestBody Entity object);

    @PutMapping("/{id}")
    ResponseEntity<Entity> update(@PathVariable(value = "id") IdType id, @RequestBody Entity object);

    @DeleteMapping("/{id}")
    ResponseEntity<Entity> delete(@PathVariable(value = "id") IdType id);

    @GetMapping
    ResponseEntity<List<Entity>> getAll();

    @GetMapping(("/{id}"))
    ResponseEntity<Entity> getEntityById(@PathVariable(value = "id") IdType id);
}
