package app.emp.services.interfaces;

import app.emp.entities.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeServiceInterface {
    void save(Employee emp);
    List<Employee> getEmployees();
    void deleteEmployee(Employee employee);
    Employee getEmployeeById(UUID id);
//    void updateEmployee(Employee employee);
}
