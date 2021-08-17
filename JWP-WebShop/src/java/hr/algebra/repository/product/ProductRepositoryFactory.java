package hr.algebra.repository.product;

/**
 *
 * @author Kevin
 */
public class ProductRepositoryFactory {
    
    /**
     * Get class that implements ProductRepository interface
     * 
     * @return exact class that implements ProductRepository interface
     */
    public static ProductRepository getRepository() {
        return new ProductRepositorySQL();
    }
}
