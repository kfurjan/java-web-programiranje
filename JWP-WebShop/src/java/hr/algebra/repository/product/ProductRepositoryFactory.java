package hr.algebra.repository.product;

/**
 *
 * @author Kevin
 */
public class ProductRepositoryFactory {
    
    public static ProductRepository getRepository() {
        return new ProductRepositorySQL();
    }
}
