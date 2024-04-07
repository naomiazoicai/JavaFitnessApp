package map.project.FitnessCenter.controller;

import map.project.FitnessCenter.data.model.SpecialisedRoom;
import map.project.FitnessCenter.service.SpecialisedRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for managing specialized room-related operations in the fitness center.
 * This controller extends the BaseController and provides endpoints for common CRUD operations on SpecialisedRoom entities.
 */
@RestController
@RequestMapping("/room")
public class SpecialisedRoomController extends BaseController<SpecialisedRoom, Long> {
    @Autowired
    public SpecialisedRoomController(SpecialisedRoomService service) {
        super(service);
    }
}

