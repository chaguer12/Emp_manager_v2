package app.emp.services.implementations;

import app.emp.dao.implementations.EmployeeDAO;
import app.emp.dao.interfaces.EmployeeInterfaceDAO;
import app.emp.entities.Employee;
import app.emp.services.interfaces.EmployeeServiceInterface;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.UUID;
@ApplicationScoped
public class EmployeeService implements EmployeeServiceInterface {
    @Inject
    private EmployeeInterfaceDAO dao;

    @Override
    public Employee save(Employee emp){
        return dao.save(emp);

    }
    @Override
    public List<Employee> getEmployees() {
        return dao.getEmployees();
    } 
    @Override
    public boolean deleteEmployee(Employee employee) {
        return dao.deleteEmployee(employee);
    }
    @Override
    public Employee getEmployeeById(UUID id){
        return dao.getEmployeeById(id);
    }
    @Override
    public boolean updateEmployee(Employee employee) {
        return dao.updateEmployee(employee);
    }
}
