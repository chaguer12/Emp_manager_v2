package app.emp.dao.interfaces;

import app.emp.entities.Offer;

import java.util.List;
import java.util.UUID;

public interface OfferInterfaceDAO {
    Offer save(Offer offer);
    List<Offer> getAll();
    boolean delete(Offer offer);
    Offer getByID(UUID id);
    boolean update(Offer offer);

}
