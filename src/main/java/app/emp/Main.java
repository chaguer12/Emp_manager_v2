package app.emp;

import app.emp.entities.Department;
import app.emp.entities.Employee;
import app.emp.persistence.PersistenceFactoryManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.Transaction;

import java.sql.Date;

public class Main {
    public static void main (String[] args){
        Employee emp = new Employee("djfsqkd","djsql","jdsqfjdlf","sfq","dfqdsm","dslqfkjds",23948938,null,null);
        EntityManager em = PersistenceFactoryManager.getEntityManager();
        EntityTransaction trns = em.getTransaction();
        trns.begin();
        em.persist(emp);
        trns.commit();
    }
}
