package app.emp.servlets;

import app.emp.entities.Employee;
import app.emp.services.implementations.EmployeeService;
import app.emp.services.interfaces.EmployeeServiceInterface;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.UUID;
@ApplicationScoped
@WebServlet(name = "EmployeeServlet", value = {"/add-employee","/emplist","/delete-emp","/update-emp"})
public class EmployeeServlet extends HttpServlet {
    @Inject
    private EmployeeServiceInterface empService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("_method");
        if (action != null) {
            switch (action) {
                case "UPDATE":
                    updateEmployee(req, resp);
                    break;
                case "PATCH":
                    dataTransporter(req, resp);
                    break;
                case "LIST":
                    listEmplos(req, resp);
                    break;
                default:
                    listEmplos(req, resp);
                    break;

            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("_method");
        switch (method) {
            case "DELETE":
                doDelete(req, resp);
                break;
            case "ADD":
                insert(req, resp);
                break;
            case "UPDATE":
                updateEmployee(req, resp);
                break;
            default:
                listEmplos(req, resp);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = UUID.fromString(req.getParameter("id"));
        Employee emp = empService.getEmployeeById(id);
        if(emp != null){
            empService.deleteEmployee(emp);
            listEmplos(req, resp);
        }else{
            resp.sendRedirect("/add-employee");

        }

    }
    private void insert(HttpServletRequest req, HttpServletResponse resp)throws IOException{
        String name = req.getParameter("nom");
        String lastName = req.getParameter("prenom");
        String tel = req.getParameter("tel");
        String email = req.getParameter("email");
        String poste = req.getParameter("poste");
        String dprt = req.getParameter("departement");
        String password = req.getParameter("password");
        double nss = Double.parseDouble(req.getParameter("nss"));
        String date = req.getParameter("insertion");
        double salary = Double.parseDouble(req.getParameter("salary"));
        double children = Double.parseDouble(req.getParameter("children"));
        Date insertion = Date.valueOf(date);
        Employee emp = new Employee(name,lastName,tel,email,poste,password,nss,insertion,dprt,salary,children);
        empService.save(emp);
        resp.sendRedirect("/");
    }

    private void listEmplos(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        List<Employee> employees = empService.getEmployees();
        req.setAttribute("employees",employees);
        req.getRequestDispatcher("/view/employees/employees.jsp").forward(req,resp);
    }
    private void dataTransporter(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Employee emp = empService.getEmployeeById(UUID.fromString(req.getParameter("id")));
        req.setAttribute("employee",emp);
        req.getRequestDispatcher("/view/employees/updateForm.jsp").forward(req, resp);
    }

    private void updateEmployee(HttpServletRequest req, HttpServletResponse resp){

    }
}

