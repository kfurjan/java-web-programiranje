package hr.algebra.repository.history;

import hr.algebra.model.UserHistory;
import java.util.List;

/**
 *
 * @author Kevin
 */
public interface UserHistoryRepository {
    
    /**
     * Save user history into, for example, database 
     * 
     * @param userHistory 
     */
    void saveUserHistory(UserHistory userHistory);
    
    /**
     * Get all user history date.
     *
     * @return List of all user history
     */
    List<UserHistory> getAllUserHistory();
}
