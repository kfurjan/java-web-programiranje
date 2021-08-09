package hr.algebra.repository.auth;

import hr.algebra.model.User;
import hr.algebra.util.EntityManagerSingleton;
import hr.algebra.util.Strings;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Kevin
 */
public class AuthenticationRepositorySQL implements AuthenticationRepository {
    
    /**
     * Performs login and returns user
     * 
     * @param email
     * @param password
     * @return optional user
     */
    @Override
    public Optional<User> loginUser(String email, String password) {
        
        try {
            EntityManager entityManager = EntityManagerSingleton.getInstance();
            
            TypedQuery<User> query = entityManager.createNamedQuery(
                User.LOGIN_USER_QUERY,
                User.class
            );
            query.setParameter(Strings.EMAIL, email);
            query.setParameter(Strings.PASSWORD, password);
            
            return Optional.of(query.getSingleResult());
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    /**
     * Registers new user and returns that user
     * 
     * @param user
     * @return optional user
     */
    @Override
    public Optional<User> registerUser(User user) {
        
        try {
            EntityManager entityManager = EntityManagerSingleton.getInstance();
            
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            
            return Optional.of(user);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
