package hr.algebra.repository.auth;

/**
 *
 * @author Kevin
 */
public class AuthenticationRepositoryFactory {
    
    /**
     * Get class that implements AuthenticationRepository interface
     * 
     * @return exact class that implements AuthenticationRepository interface
     */
    public static AuthenticationRepository getRepository() {
        return new AuthenticationRepositorySQL();
    }
}
