package map.project.FitnessCenter.controller;

import map.project.FitnessCenter.data.model.SubscriptionType;
import map.project.FitnessCenter.service.SubscriptionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * Controller class for managing subscription type-related operations in the fitness center.
 * This controller extends the BaseController and provides endpoints for common CRUD operations on SubscriptionType entities.
 *
 */

@RestController
@RequestMapping("/subscriptionType")
public class SubscriptionTypeController extends BaseController<SubscriptionType, String> {
    @Autowired
    public SubscriptionTypeController(SubscriptionTypeService service)
    {
        super(service);
    }
}


