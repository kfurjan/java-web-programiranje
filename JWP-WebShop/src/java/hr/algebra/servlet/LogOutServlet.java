package hr.algebra.servlet;

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
public class LogOutServlet extends HttpServlet {

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
        request.getSession().setAttribute(Strings.USER_KEY, null);
        request.getSession().setAttribute(Strings.CART_KEY, null);
        request.getSession().setAttribute(Strings.PRODUCT_KEY, null);
        request.getSession().setAttribute(Strings.PRODUCT_CATEGORY_KEY, null);
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
        request.getSession().setAttribute(Strings.USER_KEY, null);
        request.getSession().setAttribute(Strings.CART_KEY, null);
        request.getSession().setAttribute(Strings.PRODUCT_KEY, null);
        request.getSession().setAttribute(Strings.PRODUCT_CATEGORY_KEY, null);
        response.sendRedirect(Strings.HOME_ENDPOINT);
    }
}
