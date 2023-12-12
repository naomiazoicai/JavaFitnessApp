package map.project.FitnessCenter.controller;

import map.project.FitnessCenter.data.model.SpecialisedRoom;
import map.project.FitnessCenter.service.SpecialisedRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/room")
public class SpecialisedRoomController extends BaseController<SpecialisedRoom, Long>
{
    @Autowired
    public SpecialisedRoomController(SpecialisedRoomService service) {
        super(service);
    }
}

