package app.emp.services.implementations;

import app.emp.dao.implementations.OfferDAO;
import app.emp.entities.Offer;
import app.emp.services.interfaces.OfferServiceInterface;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.UUID;
@ApplicationScoped
public class OfferService implements OfferServiceInterface {
    @Inject
    private OfferDAO offerDAO;

    @Override
    public Offer save(Offer offer) {
        return offerDAO.save(offer);
    }

    @Override
    public List<Offer> getOffers() {
        return offerDAO.getAll();
    }

    @Override
    public boolean deleteOffer(Offer offer) {
        return offerDAO.delete(offer);
    }

    @Override
    public Offer getOfferById(UUID id) {
        return offerDAO.getByID(id);
    }
    @Override
    public boolean updateOffer(Offer offer){
        return offerDAO.update(offer);
    }
    public boolean getStatus(Offer offer){
        return offerDAO.getStatus(offer);
    }
}
