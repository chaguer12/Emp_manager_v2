package app.emp.dao.implementations;

import app.emp.dao.interfaces.EmployeeInterfaceDAO;
import app.emp.entities.Employee;
import app.emp.persistence.PersistenceFactoryManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    @Override
    public void deleteEmployee(Employee emp){
        try(EntityManager em = PersistenceFactoryManager.getEntityManager()){
            trns = em.getTransaction();
            trns.begin();
            Employee emplo = em.merge(emp);
            em.remove(emplo);
            trns.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public Employee getEmployeeById(UUID id){
        Employee emp = null;
        try(EntityManager em = PersistenceFactoryManager.getEntityManager()){
            emp =  em.find(Employee.class,id);
            return emp;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return emp;

    }
}
