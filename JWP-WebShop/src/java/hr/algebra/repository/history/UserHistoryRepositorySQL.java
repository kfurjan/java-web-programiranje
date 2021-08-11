package hr.algebra.repository.history;

import hr.algebra.model.UserHistory;
import hr.algebra.util.EntityManagerSingleton;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Kevin
 */
public class UserHistoryRepositorySQL implements UserHistoryRepository {

    /**
     * Save user history into, for example, database 
     * 
     * @param userHistory 
     */
    @Override
    public void saveUserHistory(UserHistory userHistory) {
        try {
            EntityManager entityManager = EntityManagerSingleton.getInstance();
            
            entityManager.getTransaction().begin();
            entityManager.persist(userHistory);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Get all user history date.
     *
     * @return List of all user history
     */
    @Override
    public List<UserHistory> getAllUserHistory() {
        
        try {
            EntityManager entityManager = EntityManagerSingleton.getInstance();
            
            TypedQuery<UserHistory> query = entityManager.createNamedQuery(
                UserHistory.FIND_ALL_QUERY,
                UserHistory.class
            );
            
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
