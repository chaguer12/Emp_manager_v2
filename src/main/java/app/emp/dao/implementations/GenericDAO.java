package app.emp.dao.implementations;

import app.emp.dao.interfaces.GenericDaoInterface;
import app.emp.entities.Employee;
import app.emp.persistence.PersistenceFactoryManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GenericDAO<T> implements GenericDaoInterface<T> {
    private static EntityTransaction trns = null;
    private final Class<T> entityClass;

    public GenericDAO(Class<T> entityClass){
        this.entityClass = entityClass;

    }
    @Override
    public void save(T entity) {
        try(EntityManager em = PersistenceFactoryManager.getEntityManager()){
            trns = em.getTransaction();
            trns.begin();
            em.persist(entity);
            trns.commit();
        } catch (Exception e) {
            if(trns != null){
                trns.rollback();
            }
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<T> getAll() {
        List<T> list = new ArrayList<>();
        try(EntityManager em = PersistenceFactoryManager.getEntityManager()) {
            Query query = em.createQuery("FROM" + entityClass);
            list = query.getResultList();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void delete(T entity) {
        try(EntityManager em = PersistenceFactoryManager.getEntityManager()){
            trns = em.getTransaction();
            trns.begin();
            T managedEntity = em.merge(entity);
            em.remove(managedEntity);
            trns.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public T getByID(UUID id) {
        T entity = null;
        try(EntityManager em = PersistenceFactoryManager.getEntityManager()){
            entity =  em.find(entityClass,id);
            return entity;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return entity;
    }

    @Override
    public void update(Object entity) {

    }
}
