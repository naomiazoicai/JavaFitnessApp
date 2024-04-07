package map.project.FitnessCenter.controller;

import map.project.FitnessCenter.service.NonBudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for managing free subscription-related operations in the fitness center.
 * This controller extends the SubscriptionController and provides endpoints for common CRUD operations on free subscriptions.
 */
@RestController
@RequestMapping("/freeSubscription")
public class FreeSubscriptionController extends SubscriptionController {
    @Autowired
    public FreeSubscriptionController(NonBudgetService service) {
        super(service);
    }
}
