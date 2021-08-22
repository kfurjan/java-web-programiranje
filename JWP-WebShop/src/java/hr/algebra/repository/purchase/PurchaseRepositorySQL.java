package hr.algebra.repository.purchase;

import hr.algebra.model.OrderDetail;
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
     * Creates new OrderDetail
     * 
     * @param OrderDetail
     * @return returns true if successful
     */
    @Override
    public boolean createOrderDetail(OrderDetail OrderDetail) {
        
        try {
            EntityManager entityManager = EntityManagerSingleton.getInstance();
            
            entityManager.getTransaction().begin();
            entityManager.persist(OrderDetail.getPaymentDetail());
            entityManager.merge(OrderDetail);
            entityManager.getTransaction().commit();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

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
    
    /**
     * Get all defined OrderDetail
     * 
     * @return list of OrderDetail
     */
    @Override
    public List<OrderDetail> getAllOrderDetails() {
        
        try {
            EntityManager entityManager = EntityManagerSingleton.getInstance();
            
            TypedQuery<OrderDetail> query = entityManager.createNamedQuery(
                OrderDetail.FIND_ALL_QUERY,
                OrderDetail.class
            );
            
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
