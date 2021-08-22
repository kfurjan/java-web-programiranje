package hr.algebra.servlet;

import hr.algebra.model.OrderDetail;
import hr.algebra.model.User;
import hr.algebra.repository.purchase.PurchaseRepository;
import hr.algebra.repository.purchase.PurchaseRepositoryFactory;
import hr.algebra.util.Strings;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kevin
 */
public class PurchaseHistoryServlet extends HttpServlet {

    private final PurchaseRepository purchaseRepository = PurchaseRepositoryFactory.getRepository();

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
        User user = (User) request.getSession().getAttribute(Strings.USER_KEY);
        List<OrderDetail> orderDetails = 
                user.getUserType().getType().equals("User") 
                ? user.getOrderDetailList() 
                : purchaseRepository.getAllOrderDetails();
        
        request.setAttribute(Strings.ORDER_DETAILS, orderDetails);
        request.getRequestDispatcher(Strings.PURCHASE_HISTORY_ENDPOINT).forward(request, response);
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
