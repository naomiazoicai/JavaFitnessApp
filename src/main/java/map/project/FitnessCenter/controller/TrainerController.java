package map.project.FitnessCenter.controller;

import map.project.FitnessCenter.data.model.Trainer;
import map.project.FitnessCenter.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainer")
public class TrainerController extends BaseController<Trainer, String>
{
    @Autowired
    public TrainerController(TrainerService service) {
        super(service);
    }

    @PostMapping
    @Override
    public ResponseEntity<Trainer> add(@RequestBody Trainer object) {
        return super.add(object);
    }

    @PutMapping("/{username}")
    @Override
    public ResponseEntity<Trainer> update(@PathVariable(value = "username") String id, @RequestBody Trainer object) {
        return super.update(id, object);
    }

    @DeleteMapping("/{username}")
    @Override
    public ResponseEntity<Trainer> delete(@PathVariable(value = "username") String id) {
        return super.delete(id);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Trainer>> getAll() {
        return super.getAll();
    }

    @GetMapping("/{username}")
    @Override
    public ResponseEntity<Trainer> getEntityById(@PathVariable(value = "username") String id) {
        return super.getEntityById(id);
    }
}
