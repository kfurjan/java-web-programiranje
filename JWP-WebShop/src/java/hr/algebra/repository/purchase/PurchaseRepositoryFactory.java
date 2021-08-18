package hr.algebra.repository.purchase;

/**
 *
 * @author Kevin
 */
public class PurchaseRepositoryFactory {
    
    /**
     * Get class that implements PurchaseRepository interface
     * 
     * @return exact class that implements PurchaseRepository interface
     */
    public static PurchaseRepository getRepository() {
        return new PurchaseRepositorySQL();
    }
}
