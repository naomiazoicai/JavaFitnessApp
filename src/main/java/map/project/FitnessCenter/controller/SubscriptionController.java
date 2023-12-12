package map.project.FitnessCenter.controller;

import map.project.FitnessCenter.data.model.Subscription;
import map.project.FitnessCenter.service.subjects.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController extends BaseController<Subscription, Long> {
    @Autowired
    SubscriptionController(SubscriptionService service)
    {
        super(service);
    }
}
