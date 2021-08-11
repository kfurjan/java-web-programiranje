package hr.algebra.repository.history;

/**
 *
 * @author Kevin
 */
public class UserHistoryRepositoryFactory {
    
    /**
     * Get class that implements UserHistoryRepository interface
     * 
     * @return exact class that implements UserHistoryRepository interface
     */
    public static UserHistoryRepository getRepository() {
        return new UserHistoryRepositorySQL();
    }
}
