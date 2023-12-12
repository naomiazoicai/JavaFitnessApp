package map.project.FitnessCenter.controller;

import map.project.FitnessCenter.data.model.SpecialisedRoom;
import map.project.FitnessCenter.service.SpecialisedRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class SpecialisedRoomController extends BaseController<SpecialisedRoom, Long>
{
    @Autowired
    public SpecialisedRoomController(SpecialisedRoomService service) {
        super(service);
    }

    @PostMapping
    @Override
    public ResponseEntity<SpecialisedRoom> add(@RequestBody SpecialisedRoom object) {
        return super.add(object);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<SpecialisedRoom> update(@PathVariable(value = "id") Long id, @RequestBody SpecialisedRoom object) {
        return super.update(id, object);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<SpecialisedRoom> delete(@PathVariable(value = "id") Long id) {
        return super.delete(id);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<SpecialisedRoom>> getAll() {
        return super.getAll();
    }

    @GetMapping(("/{id}"))
    @Override
    public ResponseEntity<SpecialisedRoom> getEntityById(@PathVariable(value = "id") Long id) {
        return super.getEntityById(id);
    }


}

