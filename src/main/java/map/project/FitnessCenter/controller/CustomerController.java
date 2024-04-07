package map.project.FitnessCenter.controller;

import map.project.FitnessCenter.data.model.Customer;
import map.project.FitnessCenter.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for managing customer-related operations in the fitness center.
 * This controller extends the BaseController and provides endpoints for common CRUD operations on Customer entities.
 **/
@RestController
@RequestMapping("/customer")
public class CustomerController extends BaseController<Customer, String> {
    @Autowired
    CustomerController(CustomerService service) {
        super(service);
    }
}
