package map.project.FitnessCenter.controller;

import map.project.FitnessCenter.data.model.Room;
import map.project.FitnessCenter.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController extends BaseController<Room, Long>
{
    @Autowired
    public RoomController(RoomService service) {
        super(service);
    }

    @PostMapping("/room")
    @Override
    public ResponseEntity<Room> add(@RequestBody Room object) {
        return super.add(object);
    }

    @PutMapping("/room/{id}")
    @Override
    public ResponseEntity<Room> update(@PathVariable(value = "id") Long id, @RequestBody Room object) {
        return super.update(id, object);
    }

    @DeleteMapping("/room/{id}")
    @Override
    public ResponseEntity<Room> delete(@PathVariable(value = "id") Long id) {
        return super.delete(id);
    }

    @GetMapping("/room")
    @Override
    public ResponseEntity<List<Room>> getAll() {
        return super.getAll();
    }

    @GetMapping(("/room/{id}"))
    @Override
    public ResponseEntity<Room> getEntityById(@PathVariable(value = "id") Long id) {
        return super.getEntityById(id);
    }


}

