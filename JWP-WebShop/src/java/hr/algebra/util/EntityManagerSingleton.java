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
    
    /**
     * Get EntityManager instance. If instance exists return that one,
     * otherwise create new one and return it.
     * 
     * @return EntityManager instance
     */
    public static EntityManager getInstance() {
        
        if (instance == null) {
            instance = createInstance(Strings.PERSISTENCE_UNIT);
        }
        
        return instance;
    }
    
    /**
     * Create EntityManager instance for given persistence unit.
     * 
     * @param persistenceUnit
     * @return EntityManager
     */
    private static EntityManager createInstance(String persistenceUnit) {
        
        return Persistence
                .createEntityManagerFactory(persistenceUnit)
                .createEntityManager();
    }
}
