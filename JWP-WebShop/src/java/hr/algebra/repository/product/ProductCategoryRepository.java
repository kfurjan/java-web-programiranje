package hr.algebra.repository.product;

import hr.algebra.model.ProductCategory;
import java.util.List;

/**
 *
 * @author Kevin
 */
public interface ProductCategoryRepository {
    
    /**
     * Create ProductCategory, for example in database.
     * 
     * @param productCategory
     * @return true if successfully created ProductCategory.
     */
    public boolean createProductCategory(ProductCategory productCategory);
    
    /**
     * Update ProductCategory, for example in database.
     * 
     * @param productCategory
     * @return true if successfully updated ProductCategory.
     */
    public boolean updateProductCategory(ProductCategory productCategory);
    
    /**
     * Delete ProductCategory, for example in database.
     * 
     * @param productCategory
     * @return true if successfully deleted ProductCategory.
     */
    public boolean deleteProductCategory(ProductCategory productCategory);
    
    /**
     * Get all ProductCategory, for example from database.
     * 
     * @return list of all ProductCategory
     */
    public List<ProductCategory> getAllProductCategories();
}
