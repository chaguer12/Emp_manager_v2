package app.emp.dao.interfaces;

import app.emp.entities.Employee;

import java.util.List;

public interface EmployeeInterfaceDAO {
    void save(Employee emp);
    List<Employee> getEmployees();
}
