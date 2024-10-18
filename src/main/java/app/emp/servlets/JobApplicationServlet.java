package app.emp.servlets;

import app.emp.entities.Offer;
import app.emp.services.implementations.OfferService;
import app.emp.services.interfaces.OfferServiceInterface;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
@ApplicationScoped
@WebServlet(name = "JobApplicationServlet",value = {"/fetch-offers"})
public class JobApplicationServlet extends HttpServlet {
    @Inject
    private OfferServiceInterface offerService;



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("_method");
        switch(action){
            case "FETCH":
                listOffers(req, resp);
                break;
            case null:
                listOffers(req, resp);
            default:
                listOffers(req, resp);
                break;


        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
    private void listOffers(HttpServletRequest req , HttpServletResponse resp) throws ServletException,IOException{
        List<Offer> offers = offerService.getOffers();
        req.setAttribute("offers",offers);
        req.getServletContext().getRequestDispatcher("/view/jobSeeker/jobOffers.jsp").forward(req,resp);
    }
    private void insert(HttpServletRequest req, HttpServletResponse resp){

    }
}
