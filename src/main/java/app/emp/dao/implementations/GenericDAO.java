package app.emp.dao.implementations;

import app.emp.dao.interfaces.GenericDaoInterface;
import app.emp.entities.Employee;
import app.emp.persistence.PersistenceFactoryManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

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
    public T save(T entity) {
        try(EntityManager em = PersistenceFactoryManager.getEntityManager()){
            trns = em.getTransaction();
            trns.begin();
            em.persist(entity);
            trns.commit();
            return entity;

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
        return entity;
    }

    @Override
    public List<T> getAll() {
        List<T> list = new ArrayList<>();
        try(EntityManager em = PersistenceFactoryManager.getEntityManager()) {
            Query query = em.createQuery("FROM " + entityClass.getName());
            list = query.getResultList();

        } catch (Exception e) {
            System.out.println("hahahahahahah =>" + e.getMessage());
        }
        return list;
    }

    @Override
    public boolean delete(T entity) {
        try(EntityManager em = PersistenceFactoryManager.getEntityManager()){
            trns = em.getTransaction();
            trns.begin();
            T managedEntity = em.merge(entity);
            em.remove(managedEntity);
            trns.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;

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
    public boolean update(T entity) {
        try(EntityManager em = PersistenceFactoryManager.getEntityManager()){
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;

    }
}
