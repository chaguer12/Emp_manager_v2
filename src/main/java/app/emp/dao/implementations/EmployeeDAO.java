package app.emp.dao.implementations;

import app.emp.dao.interfaces.EmployeeInterfaceDAO;
import app.emp.entities.Employee;
import app.emp.persistence.PersistenceFactoryManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements EmployeeInterfaceDAO {
    private static EntityTransaction trns = null;
    @Override
    public void save(Employee emp){
        try(EntityManager em = PersistenceFactoryManager.getEntityManager()){
            trns = em.getTransaction();
            trns.begin();
            em.persist(emp);
            trns.commit();
        } catch (Exception e) {
            if(trns != null){
                trns.rollback();
            }
            System.out.println(e.getMessage());
        }
    }
    @Override
    public List<Employee> getEmployees(){
        List<Employee> emplos = new ArrayList<>();
        try(EntityManager em = PersistenceFactoryManager.getEntityManager()) {
            Query query = em.createQuery("SELECT e FROM Employee e");
            emplos = query.getResultList();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return emplos;
    }
}
