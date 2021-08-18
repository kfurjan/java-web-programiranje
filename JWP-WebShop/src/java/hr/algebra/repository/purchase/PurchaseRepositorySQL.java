package hr.algebra.repository.purchase;

import hr.algebra.model.PaymentMethod;
import hr.algebra.util.EntityManagerSingleton;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Kevin
 */
public class PurchaseRepositorySQL implements PurchaseRepository {

    /**
     * Get all defined PaymentMethods
     * 
     * @return list of PaymentMethods
     */
    @Override
    public List<PaymentMethod> getAllPaymentMethods() {
        
        try {
            EntityManager entityManager = EntityManagerSingleton.getInstance();
            
            TypedQuery<PaymentMethod> query = entityManager.createNamedQuery(
                PaymentMethod.FIND_ALL_QUERY,
                PaymentMethod.class
            );
            
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
