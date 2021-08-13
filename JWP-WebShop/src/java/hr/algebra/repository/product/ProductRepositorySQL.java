package hr.algebra.repository.product;

import hr.algebra.model.ProductCategory;
import hr.algebra.util.EntityManagerSingleton;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Kevin
 */
public class ProductRepositorySQL implements ProductRepository {

    /**
     * Create ProductCategory, for example in database.
     * 
     * @param productCategory
     * @return true if successfully created ProductCategory.
     */
    @Override
    public boolean createProductCategory(ProductCategory productCategory) {
        
        try {
            EntityManager entityManager = EntityManagerSingleton.getInstance();
            
            entityManager.getTransaction().begin();
            entityManager.persist(productCategory);
            entityManager.getTransaction().commit();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Update ProductCategory, for example in database.
     * 
     * @param productCategory
     * @return true if successfully updated ProductCategory.
     */
    @Override
    public boolean updateProductCategory(ProductCategory productCategory) {
        
        try {
            EntityManager entityManager = EntityManagerSingleton.getInstance();
            
            entityManager.getTransaction().begin();
            entityManager.merge(productCategory);
            entityManager.getTransaction().commit();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Delete ProductCategory, for example in database.
     * 
     * @param productCategory
     * @return true if successfully deleted ProductCategory.
     */
    @Override
    public boolean deleteProductCategory(ProductCategory productCategory) {
        
        try {
            EntityManager entityManager = EntityManagerSingleton.getInstance();
            
            entityManager.getTransaction().begin();
            entityManager.remove(
                entityManager.contains(productCategory) 
                        ? productCategory 
                        : entityManager.merge(productCategory)
            );
            entityManager.getTransaction().commit();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Get all ProductCategory, for example from database.
     * 
     * @return list of all ProductCategory
     */
    @Override
    public List<ProductCategory> getAllProductCategories() {
        
        try {
            EntityManager entityManager = EntityManagerSingleton.getInstance();
            
            TypedQuery<ProductCategory> query = entityManager.createNamedQuery(
                ProductCategory.FIND_ALL_QUERY,
                ProductCategory.class
            );
            
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
