package app.emp.servlets;

import app.emp.entities.Employee;
import app.emp.services.implementations.EmployeeService;
import app.emp.services.interfaces.EmployeeServiceInterface;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class EmployeeServlet extends HttpServlet {
    private EmployeeServiceInterface empService ;

    @Override
    public void init(ServletConfig config) throws ServletException {
        empService = new EmployeeService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("_method");
        if(action != null){
            switch(action){
                case "UPDATE":
                    updateEmployee(req,resp);
                    break;
                case "PATCH":
                    dataTransporter(req,resp);
                    break;
                case "LIST":
                    listEmplos(req,resp);
                    break;
                default:
                    listEmplos(req,resp);
                    break;

            }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String method = req.getParameter("_method");
            switch(method){
                case "DELETE":
                    doDelete(req, resp);
                    break;
                case "ADD":
                    insert(req, resp);
                    break;
                case "UPDATE":
                    updateEmployee(req,resp);
                    break;
                default:
                    listEmplos(req,resp);
            }
    }
        



}
