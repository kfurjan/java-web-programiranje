package hr.algebra.repository.product;

/**
 *
 * @author Kevin
 */
public class ProductCategoryRepositoryFactory {
    
    /**
     * Get class that implements ProductCategoryRepository interface
     * 
     * @return exact class that implements ProductCategoryRepository interface
     */
    public static ProductCategoryRepository getRepository() {
        return new ProductCategoryRepositorySQL();
    }
}
