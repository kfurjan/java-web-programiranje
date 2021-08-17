package hr.algebra.repository.product;

import hr.algebra.model.Product;
import java.util.List;

/**
 *
 * @author Kevin
 */
public interface ProductRepository {
    
    /**
     * Creates new Product
     * 
     * @param product
     * @return true if successful
     */
    public boolean createProduct(Product product);
    
    /**
     * Update Product
     * 
     * @param product
     * @return true if successful
     */
    public boolean updateProduct(Product product);

    /**
     * Delete Product
     * 
     * @param product
     * @return true if successful
     */
    public boolean deleteProduct(Product product);
    
    /**
     * Get all saved products.
     * 
     * @return list of products
     */
    public List<Product> getAllProducts();
    
    /**
     * Get all saved products that have quantity greater than 0.
     * 
     * @return list of products
     */
    public List<Product> getAllAvailableProducts();
}
