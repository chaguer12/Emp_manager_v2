package app.emp;

import app.emp.entities.Employee;
import app.emp.persistence.PersistenceFactoryManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class Main {
    public static void main (String[] args){
        Employee emp = new Employee("djfsdqsfkdkdjfkqljsdfjdlfkjqkd","djqsdkjfsql","jdsqfjdlf","sqskfjdfq","dfqdsm","dslqqkjfdshffkjds",23948938,null,null);

          List<String> departments = List.of("informatique","finance","direction general","marketing");
              EntityManager em = PersistenceFactoryManager.getEntityManager();
              EntityTransaction trns = em.getTransaction();
              trns.begin();
              em.persist(emp);
              trns.commit();



    }
}
