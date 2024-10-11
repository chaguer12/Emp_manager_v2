package app.emp.dao.implementations;

import app.emp.dao.interfaces.OfferInterfaceDAO;
import app.emp.entities.Offer;

import java.util.List;
import java.util.UUID;

public class OfferDAO extends GenericDAO  implements OfferInterfaceDAO {

    public OfferDAO() {
        super(OfferDAO.class);
    }

    @Override
    public void save(Offer offer) {
        super.save(offer);
    }

    @Override
    public List getAll() {
        return super.getAll();
    }

    @Override
    public void delete(Offer offer) {
        super.delete(offer);
    }

    @Override
    public Offer getByID(UUID id) {
        return (Offer) super.getByID(id);
    }

    @Override
    public void update(Offer offer) {
        super.update(offer);
    }
}
