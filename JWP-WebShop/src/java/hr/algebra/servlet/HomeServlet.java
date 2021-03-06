package hr.algebra.servlet;

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
public class HomeServlet extends HttpServlet {

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
        request.getSession().setAttribute(Strings.CART_ERROR_MESSAGE_KEY, null);
        request.getSession().setAttribute(Strings.CART_SUCCESSFULL_PURCHASE_KEY, null);
        
        request.getSession().setAttribute(
            Strings.AVAILABLE_PRODUCT_KEY,
            productRepository.getAllAvailableProducts()
        );
        response.sendRedirect(Strings.HOME_ENDPOINT);
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
    }
}
