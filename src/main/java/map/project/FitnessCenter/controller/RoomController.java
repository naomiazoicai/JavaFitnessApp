package map.project.FitnessCenter.controller;

import map.project.FitnessCenter.data.model.Room;
import map.project.FitnessCenter.service.interfaces.BaseService;
import map.project.FitnessCenter.service.interfaces.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class RoomController extends Controller<Room, Long>
{
    private final IRoomService iRoomService;

    @Autowired
    public RoomController(BaseService<Room, Long> iService, IRoomService iRoomService) {
        super(iService);
        this.iRoomService = iRoomService;
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

