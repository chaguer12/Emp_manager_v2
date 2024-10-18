package app.emp.dao.implementations;

import app.emp.dao.interfaces.EmployeeInterfaceDAO;
import app.emp.entities.Employee;
import app.emp.persistence.PersistenceFactoryManager;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@ApplicationScoped
public class EmployeeDAO implements EmployeeInterfaceDAO {
    private static EntityTransaction trns = null;
    @Override
    public Employee save(Employee emp){
        try(EntityManager em = PersistenceFactoryManager.getEntityManager()){
            trns = em.getTransaction();
            trns.begin();
            em.persist(emp);
            trns.commit();
            return emp;
        } catch (Exception e) {
            if(trns != null){
                trns.rollback();
            }
            System.out.println(e.getMessage());
        }
        return emp;
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
    public boolean deleteEmployee(Employee emp){
        try(EntityManager em = PersistenceFactoryManager.getEntityManager()){
            trns = em.getTransaction();
            trns.begin();
            Employee emplo = em.merge(emp);
            em.remove(emplo);
            trns.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
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
    @Override
    public boolean updateEmployee(Employee emp){
        try(EntityManager em = PersistenceFactoryManager.getEntityManager()){
            em.getTransaction().begin();
            em.merge(emp);
            em.getTransaction().commit();
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
