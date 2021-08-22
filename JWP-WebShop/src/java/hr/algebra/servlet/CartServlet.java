package hr.algebra.servlet;

import hr.algebra.model.OrderDetail;
import hr.algebra.model.PaymentDetail;
import hr.algebra.model.PaymentMethod;
import hr.algebra.model.PaymentStatus;
import hr.algebra.model.User;
import hr.algebra.repository.product.ProductRepository;
import hr.algebra.repository.product.ProductRepositoryFactory;
import hr.algebra.repository.purchase.PurchaseRepository;
import hr.algebra.repository.purchase.PurchaseRepositoryFactory;
import hr.algebra.util.DateUtils;
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
    
    private String paymentType;
    private String btnUpdateProduct;
    private String btnDeleteProduct;
    
    private final ProductRepository productRepository = ProductRepositoryFactory.getRepository();
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
        paymentType = request.getParameter(Strings.PAYMENT_TYPE);
        btnUpdateProduct = request.getParameter(Strings.BUTTON_UPDATE_PRODUCT_CART);
        btnDeleteProduct = request.getParameter(Strings.BUTTON_DELETE_PRODUCT_CART);
        
        OrderDetail orderDetail = (OrderDetail) request.getSession().getAttribute(Strings.CART_KEY);
        
        if (btnDeleteProduct != null && orderDetail != null) {
            deleteProductFromCart(orderDetail, request);            
        } else if (btnUpdateProduct != null && orderDetail != null) {
            updateProductInCart(orderDetail, request);
        } else if (paymentType != null && orderDetail != null) {
            processPurchase(orderDetail, request);
        } else {
            request.getSession().setAttribute(
                Strings.CART_ERROR_MESSAGE_KEY, 
                Strings.GENERAL_ERROR
            );
        }
    }

    private void deleteProductFromCart(OrderDetail orderDetail, HttpServletRequest request) {
        productId   = Integer.parseInt(request.getParameter(Strings.PRODUCT_ID_CART));
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
    }

    private void updateProductInCart(OrderDetail orderDetail, HttpServletRequest request) {
        productId   = Integer.parseInt(request.getParameter(Strings.PRODUCT_ID_CART));
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

    private void processPurchase(OrderDetail orderDetail, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(Strings.USER_KEY);
        orderDetail.setUser(user);
        
        PaymentDetail paymentDetail = new PaymentDetail(
            DateUtils.getCurrentDate(Strings.DATE_PATTERN),
            new PaymentMethod(paymentType.equals(Strings.DELIVERY_PAYMENT) ? 1 : 2, paymentType),
            new PaymentStatus(1, Strings.PURCHASE_COMPLETED)
        );
        orderDetail.setPaymentDetail(paymentDetail);
        
        orderDetail.getOrderItems().forEach(orderItem -> {
            orderItem.getProduct().setQuantity(
                orderItem.getProduct().getQuantity() - orderItem.getQuantity()
            );
            productRepository.updateProduct(orderItem.getProduct());
        });
        
        boolean purchaseSuccessful = purchaseRepository.createOrderDetail(orderDetail);
        
        if (purchaseSuccessful) {
            request.getSession().setAttribute(Strings.CART_KEY, null);
            request.getSession().setAttribute(
                Strings.CART_SUCCESSFULL_PURCHASE_KEY,
                Strings.SUCCESSFUL_PURCHASE
            );
            request.getSession().setAttribute(
                Strings.CART_ERROR_MESSAGE_KEY,
                null
            );
        } else {
            request.getSession().setAttribute(
                Strings.CART_ERROR_MESSAGE_KEY,
                Strings.UNSUCCESSFUL_PURCHASE
            );
            request.getSession().setAttribute(Strings.CART_SUCCESSFULL_PURCHASE_KEY, null);
        }
    }
}
