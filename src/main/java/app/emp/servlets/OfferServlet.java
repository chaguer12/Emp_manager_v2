package app.emp.servlets;

import app.emp.entities.Offer;
import app.emp.services.implementations.OfferService;
import app.emp.services.interfaces.OfferServiceInterface;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "OfferServlet",value = {"/offer","/add-offer"})
public class OfferServlet extends HttpServlet {
    private OfferServiceInterface offerService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        offerService = new OfferService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.sendRedirect("/view/recruiter/AddOffer.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("_method");
        switch(action){
            case "ADD":
                addOffer(req,resp);
                break;
            default:
                doGet(req,resp);
        }


    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private void addOffer(HttpServletRequest req, HttpServletResponse resp)throws IOException{
        String title = req.getParameter("title");
        String desc = req.getParameter("desc");
        Date end_date = Date.valueOf(req.getParameter("end_date"));
        Offer offer = new Offer(title,desc,end_date);
        offerService.save(offer);
        resp.sendRedirect("/");
    }
}
