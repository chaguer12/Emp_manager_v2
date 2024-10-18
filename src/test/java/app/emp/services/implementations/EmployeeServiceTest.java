package app.emp.services.implementations;

import app.emp.dao.interfaces.EmployeeInterfaceDAO;
import app.emp.entities.Employee;
import app.emp.services.interfaces.EmployeeServiceInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeInterfaceDAO employeeDAO;
    @InjectMocks
    private EmployeeService employeeService;
    private  Employee emp;
    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        emp = new Employee();
        emp.setName("amine");


    }


    @Test
    void save() {

        when(employeeDAO.save(emp)).thenReturn(emp);
        Employee result = employeeService.save(emp);
        assertEquals(emp.getName(),result.getName());
        verify(employeeDAO,times(1)).save(emp);


    }

    @Test
    void listEmployees(){
        Employee emp1 = new Employee();
        emp1.setName("amine");
        Employee emp2 = new Employee();
        emp2.setName("ali");
        List<Employee> employees = Arrays.asList(emp1, emp2);
        when(employeeDAO.getEmployees()).thenReturn(employees);
        List<Employee> result = employeeService.getEmployees();
        assertNotNull(result);
        assertEquals(2,result.size());
        assertEquals("amine",result.get(0).getName());
        verify(employeeDAO,times(1)).getEmployees();

    }

    @Test
    void deleteEmployeeTest(){
        when(employeeDAO.deleteEmployee(emp)).thenReturn(true);
        boolean result = employeeDAO.deleteEmployee(emp);
        assertTrue(result);
    }
}