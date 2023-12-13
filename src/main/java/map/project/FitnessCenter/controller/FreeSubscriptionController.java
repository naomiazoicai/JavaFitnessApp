package map.project.FitnessCenter.controller;

import map.project.FitnessCenter.service.NonBudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/freeSubscription")
public class FreeSubscriptionController extends SubscriptionController {
    @Autowired
    public FreeSubscriptionController(NonBudgetService service)
    {
        super(service);
    }
}
