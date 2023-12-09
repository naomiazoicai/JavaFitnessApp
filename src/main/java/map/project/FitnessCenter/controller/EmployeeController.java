package map.project.FitnessCenter.controller;

import map.project.FitnessCenter.data.model.Employee;
import map.project.FitnessCenter.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController extends Controller<Employee, String>
{
    @Autowired
    public EmployeeController(EmployeeService service) {
        super(service);
    }

    @PostMapping("/employee")
    @Override
    public ResponseEntity<Employee> add(@RequestBody Employee object) {
        return super.add(object);
    }

    @PutMapping("/employee/{username}")
    @Override
    public ResponseEntity<Employee> update(@PathVariable(value = "username") String id, @RequestBody Employee object) {
        return super.update(id, object);
    }

    @DeleteMapping("/employee/{username}")
    @Override
    public ResponseEntity<Employee> delete(@PathVariable(value = "username") String id) {
        return super.delete(id);
    }

    @GetMapping("/employee")
    @Override
    public ResponseEntity<List<Employee>> getAll() {
        return super.getAll();
    }

    @GetMapping("/employee/{username}")
    @Override
    public ResponseEntity<Employee> getEntityById(@PathVariable(value = "username") String id) {
        return super.getEntityById(id);
    }
}
