package map.project.FitnessCenter.controller;

import map.project.FitnessCenter.data.model.Exercise;
import map.project.FitnessCenter.service.ExerciseService;
import map.project.FitnessCenter.service.interfaces.IExerciseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
/**
 * Controller class for managing exercise-related operations in the fitness center.
 * This controller extends the BaseController and provides endpoints for common CRUD operations on Exercise entities.
 * It also includes a specific endpoint for retrieving exercises by name.
 **/
@RestController
@RequestMapping("/exercise")
public class ExerciseController extends BaseController<Exercise, Long>
{
    private final IExerciseService exerciseService;
    public ExerciseController(ExerciseService service) {
        super(service);
        this.exerciseService = service;
    }

    @GetMapping("/byName/{name}")
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
