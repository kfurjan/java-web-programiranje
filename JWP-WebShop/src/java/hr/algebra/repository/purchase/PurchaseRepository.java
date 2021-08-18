package hr.algebra.repository.purchase;

import hr.algebra.model.PaymentMethod;
import java.util.List;

/**
 *
 * @author Kevin
 */
public interface PurchaseRepository {
    
    /**
     * Get all defined PaymentMethods
     * 
     * @return list of PaymentMethods
     */
    public List<PaymentMethod> getAllPaymentMethods();
}
