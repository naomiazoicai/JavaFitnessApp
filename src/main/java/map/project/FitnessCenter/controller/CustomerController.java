package map.project.FitnessCenter.controller;

import map.project.FitnessCenter.data.model.Customer;
import map.project.FitnessCenter.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController extends BaseController<Customer, String>
{
    @Autowired
    CustomerController(CustomerService service){super(service);}

    @PostMapping
    @Override
    public ResponseEntity<Customer> add(@RequestBody Customer object) {
        return super.add(object);
    }

    @PutMapping("/{username}")
    @Override
    public ResponseEntity<Customer> update(@PathVariable(value = "username") String id, @RequestBody Customer object) {
        return super.update(id, object);
    }

    @DeleteMapping("/{username}")
    @Override
    public ResponseEntity<Customer> delete(@PathVariable(value = "username") String id) {
        return super.delete(id);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Customer>> getAll() {
        return super.getAll();
    }

    @GetMapping("/{username}")
    @Override
    public ResponseEntity<Customer> getEntityById(@PathVariable(value = "username") String id) {
        return super.getEntityById(id);
    }
}
