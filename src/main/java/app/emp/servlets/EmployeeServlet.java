package app.emp.servlets;

import app.emp.entities.Employee;
import app.emp.services.implementations.EmployeeService;
import app.emp.services.interfaces.EmployeeServiceInterface;
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

@WebServlet(name = "EmployeeServlet", value = {"/add-employee","/emplist","/delete-emp","/update-emp"})
public class EmployeeServlet extends HttpServlet {
    private EmployeeServiceInterface empService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        empService = new EmployeeService();
    }

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
            System.out.println("heeeeeey => " + emp.getEmail());
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
        Double nss = Double.valueOf(req.getParameter("nss"));
        String date = req.getParameter("insertion");
        Date insertion = Date.valueOf(date);
        Employee emp = new Employee(name,lastName,tel,email,poste,password,nss,insertion,dprt);
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

