package hr.algebra.repository.product;

import hr.algebra.model.Product;
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
     * Creates new Product
     * 
     * @param product
     * @return true if successful
     */
    @Override
    public boolean createProduct(Product product) {
        
        try {
            EntityManager entityManager = EntityManagerSingleton.getInstance();
            
            entityManager.getTransaction().begin();
            entityManager.persist(product);
            entityManager.getTransaction().commit();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Update Product
     * 
     * @param product
     * @return true if successful
     */
    @Override
    public boolean updateProduct(Product product) {
    
        try {
            EntityManager entityManager = EntityManagerSingleton.getInstance();
            
            entityManager.getTransaction().begin();
            entityManager.merge(product);
            entityManager.getTransaction().commit();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Delete Product
     * 
     * @param product
     * @return true if successful
     */
    @Override
    public boolean deleteProduct(Product product) {
        try {
            EntityManager entityManager = EntityManagerSingleton.getInstance();
            
            entityManager.getTransaction().begin();
            entityManager.remove(
                entityManager.contains(product) 
                        ? product 
                        : entityManager.merge(product)
            );
            entityManager.getTransaction().commit();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Get all saved products.
     * 
     * @return list of products
     */
    @Override
    public List<Product> getAllProducts() {
        
        try {
            EntityManager entityManager = EntityManagerSingleton.getInstance();
            
            
            TypedQuery<Product> query = entityManager.createNamedQuery(
                Product.FIND_ALL_QUERY,
                Product.class
            );
            
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public List<Product> getAllAvailableProducts() {
        
        try {
            EntityManager entityManager = EntityManagerSingleton.getInstance();
            
            
            TypedQuery<Product> query = entityManager.createNamedQuery(
                Product.FIND_ALL_AVAILABLE_QUERY,
                Product.class
            );
            
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
