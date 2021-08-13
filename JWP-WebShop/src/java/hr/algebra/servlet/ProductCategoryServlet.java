package hr.algebra.servlet;

import hr.algebra.model.ProductCategory;
import hr.algebra.repository.product.ProductRepository;
import hr.algebra.repository.product.ProductRepositoryFactory;
import hr.algebra.util.Strings;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kevin
 */
public class ProductCategoryServlet extends HttpServlet {
    
    private final ProductRepository productRepository = ProductRepositoryFactory.getRepository();

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
        request.setAttribute(
            Strings.PRODUCT_CATEGORY_KEY,
            productRepository.getAllProductCategories()
        );
        request.getRequestDispatcher(Strings.PRODUCT_CATEGORY_ENDPOINT).forward(request, response);
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
        String nameInCreate = request.getParameter(Strings.CATEGORY_NAME_CREATE);
        String descriptionInCreate = request.getParameter(Strings.CATEGORY_DESCRIPTION_CREATE);
        String btnCreateProductCategory = request.getParameter(Strings.BUTTON_CREATE_CATEGORY);
        
        String categoryID = request.getParameter(Strings.CATEGORY_ID);
        String nameInUpdateDelete = request.getParameter(Strings.CATEGORY_NAME_UDPATE_DELETE);
        String descriptionInUpdateDelete = request.getParameter(Strings.CATEGORY_DESCRIPTION_UPDATE_DELETE);
        String btnUpdateProductCategory = request.getParameter(Strings.BUTTON_UPDATE_CATEGORY);
        String btnDeleteProductCategory = request.getParameter(Strings.BUTTON_DELETE_CATEGORY);
        
        if (
            nameInCreate != null 
            && descriptionInCreate != null 
            && btnCreateProductCategory != null
        ) {
            createProductCategory(nameInCreate, descriptionInCreate, request);
        } else if (
            categoryID != null
            && nameInUpdateDelete != null
            && descriptionInUpdateDelete != null
            && btnUpdateProductCategory != null
        ) {
            updateProductCategory(
                new ProductCategory(
                        Integer.parseInt(categoryID),
                        nameInUpdateDelete,
                        descriptionInUpdateDelete
                ),
                request
            );
        } else if (
            categoryID != null
            && nameInUpdateDelete != null
            && descriptionInUpdateDelete != null
            && btnDeleteProductCategory != null
        ) {
            deleteProductCategory(
                new ProductCategory(
                        Integer.parseInt(categoryID),
                        nameInUpdateDelete,
                        descriptionInUpdateDelete
                ),
                request
            );
        } else {
            request.getSession().setAttribute(
                Strings.PRODUCT_CATEGORY_ERROR_MESSAGE_KEY, 
                Strings.GENERAL_ERROR
            );
        }
    }
    
    /**
     * Create new ProductCategory based on data passed from HTML page.
     * In case an error happens, show error description by passing it to session.
     * 
     * @param name
     * @param description
     * @param request 
     */
    private void createProductCategory(
        String name,
        String description,
        HttpServletRequest request
    ) {
        boolean createSuccessful = productRepository.createProductCategory(
            new ProductCategory(
                name,
                description
            )
        );

        if (createSuccessful) {
            request.getSession().setAttribute(
                Strings.PRODUCT_CATEGORY_ERROR_MESSAGE_KEY, 
                null
            );
        } else {
            request.getSession().setAttribute(
                Strings.PRODUCT_CATEGORY_ERROR_MESSAGE_KEY, 
                Strings.ERROR_WHILE_CREATING_PRODUCT_CATEGORY
            );
        } 
    }
    
    /**
     * Update ProductCategory based on data passed from HTML page.
     * In case an error happens, show error description by passing it to session.
     * 
     * @param productCategory
     * @param request 
     */
    private void updateProductCategory(ProductCategory productCategory, HttpServletRequest request) {
        boolean updateSuccessful = productRepository.updateProductCategory(productCategory);

        if (updateSuccessful) {
            request.getSession().setAttribute(
                Strings.PRODUCT_CATEGORY_ERROR_MESSAGE_KEY, 
                null
            );
        } else {
            request.getSession().setAttribute(
                Strings.PRODUCT_CATEGORY_ERROR_MESSAGE_KEY, 
                Strings.ERROR_WHILE_UPDATING_PRODUCT_CATEGORY
            );
        } 
    }
    
    /**
     * Delete ProductCategory based on selected ProductCategory in HTML page.
     * In case an error happens, show error description by passing it to session.
     * 
     * @param productCategory
     * @param request 
     */
    private void deleteProductCategory(ProductCategory productCategory, HttpServletRequest request) {
        boolean deleteSuccessful = productRepository.deleteProductCategory(productCategory);

        if (deleteSuccessful) {
            request.getSession().setAttribute(
                Strings.PRODUCT_CATEGORY_ERROR_MESSAGE_KEY, 
                null
            );
        } else {
            request.getSession().setAttribute(
                Strings.PRODUCT_CATEGORY_ERROR_MESSAGE_KEY, 
                Strings.ERROR_WHILE_DELETING_PRODUCT_CATEGORY
            );
        }
    }
}
