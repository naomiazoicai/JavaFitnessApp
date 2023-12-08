package map.project.FitnessCenter.controller;

import map.project.FitnessCenter.data.model.Exercise;
import map.project.FitnessCenter.service.ExerciseService;
import map.project.FitnessCenter.service.interfaces.IExerciseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ExerciseController extends Controller<Exercise, Long>
{
    private final IExerciseService exerciseService;
    public ExerciseController(ExerciseService service) {
        super(service);
        this.exerciseService = service;
    }

    @PostMapping("/exercise")
    @Override
    public ResponseEntity<Exercise> add(@RequestBody Exercise object) {
        return super.add(object);
    }

    @PutMapping("/exercise/{id}")
    @Override
    public ResponseEntity<Exercise> update(@PathVariable(value = "id") Long id, @RequestBody Exercise object) {
        return super.update(id, object);
    }

    @DeleteMapping("/exercise/{id}")
    @Override
    public ResponseEntity<Exercise> delete(@PathVariable(value = "id") Long id) {
        return super.delete(id);
    }

    @GetMapping("/exercise")
    @Override
    public ResponseEntity<List<Exercise>> getAll() {
        return super.getAll();
    }

    @GetMapping(("/exercise/{id}"))
    @Override
    public ResponseEntity<Exercise> getEntityById(@PathVariable(value = "id") Long id) {
        return super.getEntityById(id);
    }

    @GetMapping("/exercise/byName/{name}")
    public ResponseEntity<List<Exercise>> getEntityByName(@PathVariable(value = "name") String name)
    {
        Optional<List<Exercise>> result = exerciseService.getByName(name);
        if (result.isPresent())
        {
            List<Exercise> list = result.get();
            if (list.isEmpty()) return ResponseEntity.notFound().build();
            else return ResponseEntity.ok().body(list);
        }
        return ResponseEntity.internalServerError().build();
    }
}
