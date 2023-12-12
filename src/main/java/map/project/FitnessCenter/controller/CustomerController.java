package map.project.FitnessCenter.controller;

import map.project.FitnessCenter.data.model.Customer;
import map.project.FitnessCenter.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController extends BaseController<Customer, String>
{
    @Autowired
    CustomerController(CustomerService service){super(service);}
}
