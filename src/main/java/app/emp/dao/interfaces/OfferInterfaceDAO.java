package app.emp.dao.interfaces;

import app.emp.entities.Offer;

import java.util.List;
import java.util.UUID;

public interface OfferInterfaceDAO {
    void save(Offer offer);
    List getAll();
    void delete(Offer offer);
    Offer getByID(UUID id);
    void update(Offer offer);

}
