package app.emp.services.interfaces;

import app.emp.entities.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeServiceInterface {
    Employee save(Employee emp);
    List<Employee> getEmployees();
    boolean deleteEmployee(Employee employee);
    Employee getEmployeeById(UUID id);
    boolean updateEmployee(Employee employee);
}
