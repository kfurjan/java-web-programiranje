package hr.algebra.servlet;

import hr.algebra.model.Product;
import hr.algebra.model.ProductCategory;
import hr.algebra.repository.product.ProductCategoryRepositoryFactory;
import hr.algebra.util.Strings;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import hr.algebra.repository.product.ProductCategoryRepository;
import hr.algebra.repository.product.ProductRepository;
import hr.algebra.repository.product.ProductRepositoryFactory;

/**
 *
 * @author Kevin
 */
public class ProductServlet extends HttpServlet {
    
    private String productIdInUpdateDelete;
    
    private String productNameInCreate;
    private String productNameInUpdateDelete;
    
    private String productDescInCreate;
    private String productDescInUpdateDelete;
    
    private String productSkuInCreate;
    private String productSkuInUpdateDelete;
    
    private String productPriceInCreate;
    private String productPriceInUpdateDelete;
    
    private String productQuantityInCreate;
    private String productQuantityInUpdateDelete;
    
    private String productCategoryIDInCreate;
    private String productCategoryIDInUpdateDelete;
        
    private String productCategoryNameInCreate;
    
    private String btnCreateProduct;
    private String btnUpdateProduct;
    private String btnDeleteProduct;
    
    private final ProductRepository productRepository = ProductRepositoryFactory.getRepository();
    private final ProductCategoryRepository productCategoryRepository = ProductCategoryRepositoryFactory.getRepository();

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().setAttribute(
            Strings.PRODUCT_KEY,
            productRepository.getAllProducts()
        );
        request.getSession().setAttribute(
            Strings.PRODUCT_CATEGORY_KEY,
            productCategoryRepository.getAllProductCategories()
        );
        response.sendRedirect(Strings.PRODUCT_ENDPOINT);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        productNameInCreate         = request.getParameter(Strings.PRODUCT_NAME_CREATE);
        productDescInCreate         = request.getParameter(Strings.PRODUCT_DESCRIPTION_CREATE);
        productSkuInCreate          = request.getParameter(Strings.PRODUCT_SKU_CREATE);
        productPriceInCreate        = request.getParameter(Strings.PRODUCT_PRICE_CREATE);
        productQuantityInCreate     = request.getParameter(Strings.PRODUCT_QUANTITY_CREATE);
        productCategoryIDInCreate   = request.getParameter(Strings.PRODUCT_CATEGORY_ID_CREATE);
        productCategoryNameInCreate = request.getParameter(Strings.PRODUCT_CATEGPRY_NAME_CREATE);
        
        productIdInUpdateDelete         = request.getParameter(Strings.PRODUCT_ID_UPDATE_DELETE);
        productNameInUpdateDelete       = request.getParameter(Strings.PRODUCT_NAME_UPDATE_DELETE);
        productDescInUpdateDelete       = request.getParameter(Strings.PRODUCT_DESC_UPDATE_DELETE);
        productSkuInUpdateDelete        = request.getParameter(Strings.PRODUCT_SKU_UPDATE_DELETE);
        productPriceInUpdateDelete      = request.getParameter(Strings.PRODUCT_PRICE_UPDATE_DELETE);
        productQuantityInUpdateDelete   = request.getParameter(Strings.PRODUCT_QUANTITY_UPDATE_DELETE);
        productCategoryIDInUpdateDelete = request.getParameter(Strings.PRODUCT_CATEGPRY_UPDATE_DELETE);
        
        btnCreateProduct = request.getParameter(Strings.BUTTON_CREATE_PRODUCT);
        btnUpdateProduct = request.getParameter(Strings.BUTTON_UPDATE_PRODUCT);
        btnDeleteProduct = request.getParameter(Strings.BUTTON_DELETE_PRODUCT);
        
        if (createFormValidated()) {
            createProduct(
                new Product(
                    productNameInCreate,
                    productDescInCreate,
                    productSkuInCreate,
                    Double.parseDouble(productPriceInCreate),
                    Integer.parseInt(productQuantityInCreate),
                    new ProductCategory(
                        Integer.parseInt(productCategoryIDInCreate),
                        productCategoryNameInCreate
                    )
                ),
                request
            );
        } else if (updateDeleteFormValidated(btnUpdateProduct)) {
            updateProduct(
                new Product(
                    Integer.parseInt(productIdInUpdateDelete),
                    productNameInUpdateDelete,
                    productDescInUpdateDelete,
                    productSkuInUpdateDelete,
                    Double.parseDouble(productPriceInUpdateDelete),
                    Integer.parseInt(productQuantityInUpdateDelete),
                    new ProductCategory(
                        Integer.parseInt(productCategoryIDInUpdateDelete)
                    )
                ),
                request
            );
        } else if (updateDeleteFormValidated(btnDeleteProduct)) {
            deleteProduct(
                new Product(
                    Integer.parseInt(productIdInUpdateDelete),
                    productNameInUpdateDelete,
                    productDescInUpdateDelete,
                    productSkuInUpdateDelete,
                    Double.parseDouble(productPriceInUpdateDelete),
                    Integer.parseInt(productQuantityInUpdateDelete),
                    new ProductCategory(
                        Integer.parseInt(productCategoryIDInUpdateDelete)
                    )
                ),
                request
            );
        } else {
            request.getSession().setAttribute(
                Strings.PRODUCT_ERROR_MESSAGE_KEY, 
                Strings.GENERAL_ERROR
            );
        }
     }

    private boolean createFormValidated() {
        return 
                productNameInCreate != null
                && productDescInCreate != null
                && productSkuInCreate != null
                && productPriceInCreate != null
                && productQuantityInCreate != null
                && productCategoryIDInCreate != null
                && btnCreateProduct != null;
    }

    private void createProduct(Product product, HttpServletRequest request) {
        boolean createSuccessful = productRepository.createProduct(product);

        if (createSuccessful) {
            request.getSession().setAttribute(
                Strings.PRODUCT_ERROR_MESSAGE_KEY, 
                null
            );
        } else {
            request.getSession().setAttribute(
                Strings.PRODUCT_ERROR_MESSAGE_KEY, 
                Strings.ERROR_WHILE_CREATING_PRODUCT
            );
        } 
    }

    private boolean updateDeleteFormValidated(String button) {
        return 
                productIdInUpdateDelete != null
                && productNameInUpdateDelete != null
                && productDescInUpdateDelete != null
                && productSkuInUpdateDelete != null
                && productPriceInUpdateDelete != null
                && productQuantityInUpdateDelete != null
                && productCategoryIDInUpdateDelete != null
                && button != null;

    }

    private void updateProduct(Product product, HttpServletRequest request) {
        boolean createSuccessful = productRepository.updateProduct(product);

        if (createSuccessful) {
            request.getSession().setAttribute(
                Strings.PRODUCT_ERROR_MESSAGE_KEY, 
                null
            );
        } else {
            request.getSession().setAttribute(
                Strings.PRODUCT_ERROR_MESSAGE_KEY, 
                Strings.ERROR_WHILE_UPDATING_PRODUCT
            );
        }
    }

    private void deleteProduct(Product product, HttpServletRequest request) {
        boolean createSuccessful = productRepository.deleteProduct(product);

        if (createSuccessful) {
            request.getSession().setAttribute(
                Strings.PRODUCT_ERROR_MESSAGE_KEY, 
                null
            );
        } else {
            request.getSession().setAttribute(
                Strings.PRODUCT_ERROR_MESSAGE_KEY, 
                Strings.ERROR_WHILE_DELETING_PRODUCT
            );
        }
    }
}
