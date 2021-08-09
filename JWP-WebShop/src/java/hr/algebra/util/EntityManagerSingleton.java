package hr.algebra.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Kevin
 */
public class EntityManagerSingleton {
    
    private static EntityManager instance;
    
    private EntityManagerSingleton() { }
    
    public static EntityManager getInstance() {
        
        if (instance == null) {
            instance = createInstance();
        }
        return instance;
    }
    
    private static EntityManager createInstance() {
        
        return Persistence.createEntityManagerFactory(
            Strings.PERSISTENCE_UNIT
        ).createEntityManager();
    }
}
