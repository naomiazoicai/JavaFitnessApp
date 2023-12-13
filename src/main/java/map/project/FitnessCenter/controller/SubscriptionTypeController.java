package map.project.FitnessCenter.controller;

import map.project.FitnessCenter.data.model.SubscriptionType;
import map.project.FitnessCenter.service.SubscriptionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/subscriptionType")
public class SubscriptionTypeController extends BaseController<SubscriptionType, String> {
    @Autowired
    public SubscriptionTypeController(SubscriptionTypeService service)
    {
        super(service);
    }
}


