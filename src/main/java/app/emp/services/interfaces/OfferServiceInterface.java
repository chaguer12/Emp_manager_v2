package app.emp.services.interfaces;

import app.emp.entities.Offer;

import java.util.List;
import java.util.UUID;

public interface OfferServiceInterface {
    void save(Offer offer);
    List<Offer> getOffers();
    void deleteEmployee(Offer offer);
    Offer getEmployeeById(UUID id);
}
