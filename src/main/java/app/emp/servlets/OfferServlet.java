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
import java.sql.Date;
import java.util.List;
import java.util.UUID;
@ApplicationScoped
@WebServlet(name = "OfferServlet",value = {"/offer","/add-offer","/offer-form","/update-offer","/delete-offer"})
public class OfferServlet extends HttpServlet {
    @Inject
    private OfferServiceInterface offerService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("_method");
        switch(action){
            case "FORM":
                dataTransfer(req,resp);
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
                addOffer(req, resp);
                break;
            case "UPDATE":
                updateOffer(req, resp);
                break;
            case "DELETE":
                doDelete(req, resp);
                break;
            default:
                req.getRequestDispatcher("/view/error/error.jsp").forward(req, resp);
                break;
        }


    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = UUID.fromString(req.getParameter("id"));
        Offer offer = offerService.getOfferById(id);
        offerService.deleteOffer(offer);
        List<Offer> offers = offerService.getOffers();
        req.setAttribute("offers",offers);
        req.getServletContext().getRequestDispatcher("/view/recruiter/AddOffer.jsp").forward(req,resp);
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
        UUID id = UUID.fromString(req.getParameter("id"));
        Offer offer =  offerService.getOfferById(id);
        req.setAttribute("offer",offer);
        req.getRequestDispatcher("/view/recruiter/updateForm.jsp").forward(req,resp);

    }
    private void updateOffer(HttpServletRequest req, HttpServletResponse resp)throws IOException,ServletException{
        String title = req.getParameter("title");
        String desc = req.getParameter("desc");
        Date end_Date = Date.valueOf(req.getParameter("end_date"));
        UUID id = UUID.fromString(req.getParameter("id"));
        Offer offer =new Offer(title, desc, end_Date);
        offer.setId(id);
        offerService.updateOffer(offer);
        listOffers(req,resp);

    }
}
