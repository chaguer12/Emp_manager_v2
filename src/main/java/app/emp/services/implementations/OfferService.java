package app.emp.services.implementations;

import app.emp.dao.implementations.GenericDAO;
import app.emp.dao.implementations.OfferDAO;
import app.emp.dao.interfaces.GenericDaoInterface;
import app.emp.entities.Offer;
import app.emp.services.interfaces.OfferServiceInterface;

import java.util.List;
import java.util.UUID;

public class OfferService implements OfferServiceInterface {
    private final OfferDAO offerDAO = new OfferDAO();
    @Override
    public void save(Offer offer) {
        offerDAO.save(offer);
    }

    @Override
    public List<Offer> getOffers() {
        return List.of();
    }

    @Override
    public void deleteEmployee(Offer offer) {

    }

    @Override
    public Offer getEmployeeById(UUID id) {
        return null;
    }
}
