//package map.project.FitnessCenter.controller;
//
//import map.project.FitnessCenter.data.model.Trainer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class TrainerController extends Controller<Trainer, String>
//{
//    @Autowired
//    public TrainerController(TrainerService service) {
//        super(service);
//    }
//
//    @PostMapping("/trainer")
//    @Override
//    public ResponseEntity<Trainer> add(@RequestBody Trainer object) {
//        return super.add(object);
//    }
//
//    @PutMapping("/trainer/{username}")
//    @Override
//    public ResponseEntity<Trainer> update(@PathVariable(value = "username") String id, @RequestBody Trainer object) {
//        return super.update(id, object);
//    }
//
//    @DeleteMapping("/trainer/{username}")
//    @Override
//    public ResponseEntity<Trainer> delete(@PathVariable(value = "username") String id) {
//        return super.delete(id);
//    }
//
//    @GetMapping("/trainer")
//    @Override
//    public ResponseEntity<List<Trainer>> getAll() {
//        return super.getAll();
//    }
//
//    @GetMapping("/trainer/{username}")
//    @Override
//    public ResponseEntity<Trainer> getEntityById(@PathVariable(value = "username") String id) {
//        return super.getEntityById(id);
//    }
//}
