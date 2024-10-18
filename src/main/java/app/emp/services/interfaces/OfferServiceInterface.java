package app.emp.services.interfaces;

import app.emp.entities.Offer;

import java.util.List;
import java.util.UUID;

public interface OfferServiceInterface {
    Offer save(Offer offer);
    List<Offer> getOffers();
    boolean deleteOffer(Offer offer);
    Offer getOfferById(UUID id);
    boolean updateOffer(Offer offer);
}
