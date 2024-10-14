package app.emp.dao.implementations;

import app.emp.dao.interfaces.OfferInterfaceDAO;
import app.emp.entities.Offer;
import app.emp.persistence.PersistenceFactoryManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

public class OfferDAO  implements OfferInterfaceDAO {

    private GenericDAO<Offer> genericDAO = new GenericDAO<>(Offer.class);

    @Override
    @Transactional
    public void save(Offer offer) {
        genericDAO.save(offer);

    }


    @Override
    public List<Offer> getAll() {
        return genericDAO.getAll();
    }

    @Override
    public void delete(Offer offer) {

    }

    @Override
    public Offer getByID(UUID id) {
        return null;
    }

    @Override
    public void update(Offer offer) {

    }
}
