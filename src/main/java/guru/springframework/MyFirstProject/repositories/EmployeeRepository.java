package guru.springframework.MyFirstProject.repositories;

import guru.springframework.MyFirstProject.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {
}
