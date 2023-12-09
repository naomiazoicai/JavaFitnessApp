package map.project.FitnessCenter.data.repository;

import map.project.FitnessCenter.data.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
