package hr.algebra.repository.purchase;

import hr.algebra.model.OrderDetail;
import hr.algebra.model.PaymentMethod;
import java.util.List;

/**
 *
 * @author Kevin
 */
public interface PurchaseRepository {
    
    /**
     * Creates new OrderDetail
     * 
     * @param OrderDetail
     * @return returns true if successful
     */
    public boolean createOrderDetail(OrderDetail OrderDetail);
    
    /**
     * Get all defined PaymentMethods
     * 
     * @return list of PaymentMethods
     */
    public List<PaymentMethod> getAllPaymentMethods();
    
    /**
     * Get all defined OrderDetail
     * 
     * @return list of OrderDetail
     */
    public List<OrderDetail> getAllOrderDetails();
}
