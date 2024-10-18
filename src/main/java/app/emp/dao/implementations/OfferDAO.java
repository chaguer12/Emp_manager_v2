package app.emp.dao.implementations;

import app.emp.dao.interfaces.OfferInterfaceDAO;
import app.emp.entities.Offer;
import app.emp.persistence.PersistenceFactoryManager;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;
@ApplicationScoped
public class OfferDAO  implements OfferInterfaceDAO {
    @Inject
    private GenericDAO<Offer> genericDAO;

    @Override
    @Transactional
    public Offer save(Offer offer) {
        return genericDAO.save(offer);

    }


    @Override
    public List<Offer> getAll() {
        return genericDAO.getAll();
    }

    @Override
    public boolean delete(Offer offer) {
        return genericDAO.delete(offer);

    }

    @Override
    public Offer getByID(UUID id) {
        return genericDAO.getByID(id);
    }

    @Override
    public boolean update(Offer offer) {
        return genericDAO.update(offer);

    }
    public boolean getStatus(Offer offer){
        boolean status = true;
        try(EntityManager em = PersistenceFactoryManager.getEntityManager()) {
            String query = "select o.status from Offer o where o.id = :offerId";
            status = em.createQuery(query,Boolean.class).setParameter("offerId",offer.getId())
                    .getSingleResult();
            return status;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return status;
    }
}
