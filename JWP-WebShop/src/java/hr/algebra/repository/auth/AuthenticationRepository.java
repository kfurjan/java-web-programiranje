package hr.algebra.repository.auth;

import hr.algebra.model.User;
import java.util.Optional;

/**
 *
 * @author Kevin
 */
public interface AuthenticationRepository {
    
    /**
     * Performs login and returns user
     * 
     * @param email
     * @param password
     * @return optional user
     */
    Optional<User> loginUser(String email, String password);
    
    /**
     * Registers new user and returns that user
     * 
     * @param user
     * @return optional user
     */
    Optional<User> registerUser(User user);
}
