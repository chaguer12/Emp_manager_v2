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
import java.util.List;

@WebServlet(name = "OfferServlet",value = {"/offer","/add-offer","/offer-form","/update-offer"})
public class OfferServlet extends HttpServlet {
    private OfferServiceInterface offerService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        offerService = new OfferService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("_method");
        switch(action){
            case "FORM":
                //dataTransfer(req,resp);
                break;
            case null:
                listOffers(req,resp);
            default:
                listOffers(req, resp);

        }


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("_method");
        switch(action){
            case "ADD":
                addOffer(req,resp);
                break;
            default:
                req.getRequestDispatcher("/view/error/error.jsp").forward(req, resp);
                break;
        }


    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private void addOffer(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        String title = req.getParameter("title");
        String desc = req.getParameter("desc");
        Date end_date = Date.valueOf(req.getParameter("end_date"));
        Offer offer = new Offer(title,desc,end_date);
        offerService.save(offer);
        List<Offer> offers = offerService.getOffers();
        req.setAttribute("offers",offers);
        req.getServletContext().getRequestDispatcher("/view/recruiter/AddOffer.jsp").forward(req,resp);
    }
    private void listOffers(HttpServletRequest req , HttpServletResponse resp) throws ServletException,IOException{
        List<Offer> offers = offerService.getOffers();
        req.setAttribute("offers",offers);
        req.getServletContext().getRequestDispatcher("/view/recruiter/AddOffer.jsp").forward(req,resp);
    }
    private void dataTransfer(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{

    }
}
