package map.project.FitnessCenter.controller;

import map.project.FitnessCenter.data.model.Trainer;
import map.project.FitnessCenter.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for managing trainer-related operations in the fitness center.
 * This controller extends the BaseController and provides endpoints for common CRUD operations on Trainer entities.
 */


@RestController
@RequestMapping("/trainer")
public class TrainerController extends BaseController<Trainer, String> {
    @Autowired
    public TrainerController(TrainerService service) {
        super(service);
    }
}
