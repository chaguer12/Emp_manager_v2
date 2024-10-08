package app.emp.persistence;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersistenceFactoryManager {
    private static final String PUN = "PersistenceOptimizer";
    private static EntityManagerFactory EMF = Persistence.createEntityManagerFactory(PUN);

    public static EntityManager getEntityManager   (){
        return EMF.createEntityManager();

    }

    public static void closeEntityManager(){
        if(EMF != null){
            EMF.close();
        }
    }





}
