package app.emp.services.implementations;

import app.emp.dao.implementations.EmployeeDAO;
import app.emp.dao.interfaces.EmployeeInterfaceDAO;
import app.emp.entities.Employee;
import app.emp.services.interfaces.EmployeeServiceInterface;

import java.util.List;
import java.util.UUID;

public class EmployeeService implements EmployeeServiceInterface {
    private EmployeeInterfaceDAO dao = new EmployeeDAO();
    @Override
    public void save(Employee emp){
        dao.save(emp);

    }
    @Override
    public List<Employee> getEmployees() {
        List<Employee> emplos = dao.getEmployees();
        return emplos;
    }
    @Override
    public void deleteEmployee(Employee employee) {
        dao.deleteEmployee(employee);
    }
    @Override
    public Employee getEmployeeById(UUID id){
        return dao.getEmployeeById(id);
    }
//    @Override
//    public void updateEmployee(Employee employee) {
//        dao.updateEmployee(employee);
//    }
}
