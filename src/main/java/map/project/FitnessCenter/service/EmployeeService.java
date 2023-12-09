package map.project.FitnessCenter.service;

import map.project.FitnessCenter.data.exceptions.ObjectAlreadyContained;
import map.project.FitnessCenter.data.exceptions.ObjectNotContained;
import map.project.FitnessCenter.data.model.Employee;
import map.project.FitnessCenter.data.repository.EmployeeRepository;
import map.project.FitnessCenter.service.interfaces.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService extends BaseService<Employee, String> {
    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        super(repository);
    }

    @Override
    public Optional<Employee> update(String id, Employee object) throws ObjectNotContained, ObjectAlreadyContained {
        Optional<Employee> oldObject = repository.findById(id).map(Employee::copy);
        object.setUsername(id);
        repository.save(object);
        return oldObject;
    }

    @Override
    public Optional<Employee> delete(String id) throws ObjectNotContained {
        if (!repository.existsById(id)) throw new ObjectNotContained();
        Optional<Employee> oldObject = repository.findById(id);
        repository.deleteById(id);
        return oldObject;
    }
}
