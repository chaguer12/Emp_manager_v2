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

    private EntityTransaction trns = null;

    @Override
    public void save(Offer offer) {
        try(EntityManager em = PersistenceFactoryManager.getEntityManager()){
            trns = em.getTransaction();
            trns.begin();
            em.persist(offer);
            trns.commit();
        } catch (Exception e) {
            if(trns != null){
                trns.rollback();
            }
            System.out.println(e.getMessage());
        }
    }

    public OfferDAO() {
        super();
    }

    @Override
    public List getAll() {
        return List.of();
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
