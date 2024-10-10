package app.emp.dao.interfaces;

import app.emp.entities.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeInterfaceDAO {
    void save(Employee emp);
    List<Employee> getEmployees();
    void deleteEmployee(Employee emp);
    Employee getEmployeeById(UUID id);
}
