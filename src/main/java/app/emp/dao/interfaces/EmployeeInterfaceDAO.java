package app.emp.dao.interfaces;

import app.emp.entities.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeInterfaceDAO {
    Employee save(Employee emp);
    List<Employee> getEmployees();
    boolean deleteEmployee(Employee emp);
    Employee getEmployeeById(UUID id);
    boolean updateEmployee(Employee emp);
}
