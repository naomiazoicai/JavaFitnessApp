package map.project.FitnessCenter.controller;

import map.project.FitnessCenter.data.model.SubscriptionType;
import map.project.FitnessCenter.service.SubscriptionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscriptionType")
public class SubscriptionTypeController extends BaseController<SubscriptionType, String> {
    @Autowired
    public SubscriptionTypeController(SubscriptionTypeService service)
    {
        super(service);
    }

    @Override
    public ResponseEntity<SubscriptionType> add(SubscriptionType object) {
        return super.add(object);
    }

    @Override
    public ResponseEntity<SubscriptionType> update(String id, SubscriptionType object) {
        return super.update(id, object);
    }

    @Override
    public ResponseEntity<SubscriptionType> delete(String id) {
        return super.delete(id);
    }

    @Override
    public ResponseEntity<List<SubscriptionType>> getAll() {
        return super.getAll();
    }

    @Override
    public ResponseEntity<SubscriptionType> getEntityById(String id) {
        return super.getEntityById(id);
    }

}


