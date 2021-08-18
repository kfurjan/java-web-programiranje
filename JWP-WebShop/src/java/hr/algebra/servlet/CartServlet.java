package hr.algebra.servlet;

import hr.algebra.model.OrderDetail;
import hr.algebra.repository.purchase.PurchaseRepository;
import hr.algebra.repository.purchase.PurchaseRepositoryFactory;
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
public class CartServlet extends HttpServlet {
    
    private Integer productId;
    private Integer productQuantityToOrder;
    
    private String btnUpdateProduct;
    private String btnDeleteProduct;
    
    private static final PurchaseRepository purchaseRepository = PurchaseRepositoryFactory.getRepository();

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
        request.getSession().setAttribute(Strings.PAYMENT_METHOD_KEY, purchaseRepository.getAllPaymentMethods());
        response.sendRedirect(Strings.CART_ENDPOINT);
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
        productId = Integer.parseInt(request.getParameter(Strings.PRODUCT_ID_CART));
        
        btnUpdateProduct = request.getParameter(Strings.BUTTON_UPDATE_PRODUCT_CART);
        btnDeleteProduct = request.getParameter(Strings.BUTTON_DELETE_PRODUCT_CART);
        
        OrderDetail orderDetail = (OrderDetail) request.getSession().getAttribute(Strings.CART_KEY);
        
        if (btnDeleteProduct != null && orderDetail != null) {
            orderDetail.getOrderItems().removeIf(order -> order.getProduct().getId().equals(productId));
            orderDetail.setTotalPrice(
                orderDetail.getOrderItems()
                    .stream()
                    .reduce(
                        0.0,
                        (partial, order) -> partial + order.getQuantity() * order.getProduct().getPrice(),
                        Double::sum
                    )
            );
            
            request.getSession().setAttribute(Strings.CART_KEY, orderDetail);
        } else if (btnUpdateProduct != null && orderDetail != null) {
            productQuantityToOrder = Integer.parseInt(request.getParameter(Strings.PRODUCT_QUANTITY_TO_ORDER));
            orderDetail.getOrderItems()
                    .stream()
                    .filter(order -> order.getProduct().getId().equals(productId))
                    .forEach(order -> order.setQuantity(productQuantityToOrder));
            orderDetail.setTotalPrice(
                orderDetail.getOrderItems()
                    .stream()
                    .reduce(
                        0.0,
                        (partial, order) -> partial + order.getQuantity() * order.getProduct().getPrice(),
                        Double::sum
                    )
            );
            
            request.getSession().setAttribute(Strings.CART_KEY, orderDetail);
        }
    }
}
