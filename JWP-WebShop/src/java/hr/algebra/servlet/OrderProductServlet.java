package hr.algebra.servlet;

import hr.algebra.model.OrderDetail;
import hr.algebra.model.OrderItem;
import hr.algebra.model.Product;
import hr.algebra.model.ProductCategory;
import hr.algebra.model.User;
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
public class OrderProductServlet extends HttpServlet {
    
    private String productName;
    private String productDesc;
    private String productSku;
    private String productCategoryName;
    private String btnOrderProduct;
    
    private Integer productId;
    private Integer productTotalQuantity;
    private Integer productCategoryId;
    private Integer productQuantityToOrder;
    
    private Double productPrice;

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
        productName         = request.getParameter(Strings.PRODUCT_NAME_ORDER);
        productDesc         = request.getParameter(Strings.PRODUCT_DESC_ORDER);
        productSku          = request.getParameter(Strings.PRODUCT_SKU_ORDER);
        productCategoryName = request.getParameter(Strings.PRODUCT_CATEGORY_ORDER);
        btnOrderProduct     = request.getParameter(Strings.BUTTON_ORDER_PRODUCT);
        
        productId              = Integer.parseInt(request.getParameter(Strings.PRODUCT_ID_ORDER));
        productTotalQuantity   = Integer.parseInt(request.getParameter(Strings.PRODUCT_TOTAL_QUANTITY_ORDER));
        productCategoryId      = Integer.parseInt(request.getParameter(Strings.PRODUCT_CATEGORY_ID_ORDER));
        productQuantityToOrder = Integer.parseInt(request.getParameter(Strings.PRODUCT_QUANTITY_TO_ORDER));
        
        productPrice = Double.parseDouble(request.getParameter(Strings.PRODUCT_PRICE_ORDER));
        
        request.getSession().setAttribute(
            Strings.HOME_ERROR_MESSAGE_KEY,
            null
        );
        
        if (productQuantityToOrder > productTotalQuantity) {
            request.getSession().setAttribute(
                Strings.HOME_ERROR_MESSAGE_KEY,
                Strings.ERROR_WITH_ORDER_QUANTITY
            );
        } else if (btnOrderProduct != null) {
            addProductToCart(request);
        } else {
            request.getSession().setAttribute(
                Strings.HOME_ERROR_MESSAGE_KEY,
                Strings.GENERAL_ERROR
            );
        }
    }

    private void addProductToCart(HttpServletRequest request) {
        OrderDetail orderDetail = (OrderDetail) request.getSession().getAttribute(Strings.CART_KEY);
        User user = (User) request.getSession().getAttribute(Strings.USER_KEY);
        
        if (orderDetail != null) {
            if (orderDetail.getOrderItems().stream().anyMatch(item -> item.getProduct().getId().equals(productId))) {
                request.getSession().setAttribute(
                    Strings.HOME_ERROR_MESSAGE_KEY,
                    Strings.ERROR_ITEM_ALREADY_IN_CART
                );
                return;
            }
            
            Product product = new Product(
                productId,
                productName,
                productDesc,
                productSku, 
                productPrice,
                productTotalQuantity,
                new ProductCategory(productCategoryId, productCategoryName)
            );
            OrderItem orderItem = new OrderItem(productQuantityToOrder, product);
            
            orderDetail.setTotalPrice(
                orderDetail.getTotalPrice() + (product.getPrice() * productQuantityToOrder)
            );
            orderDetail.getOrderItems().add(orderItem);
            if (user != null) {
                orderDetail.setUser(user);
            }
            
            request.getSession().setAttribute(
                Strings.CART_KEY,
                orderDetail
            );
        } else {
            Product product = new Product(
                productId,
                productName,
                productDesc,
                productSku, 
                productPrice,
                productTotalQuantity,
                new ProductCategory(productCategoryId, productCategoryName)
            );
            orderDetail = new OrderDetail();
            OrderItem orderItem = new OrderItem(productQuantityToOrder, product);
            
            orderDetail.setTotalPrice(
                orderDetail.getTotalPrice() + (product.getPrice() * productQuantityToOrder)
            );
            orderDetail.getOrderItems().add(orderItem);
            if (user != null) {
                orderDetail.setUser(user);
            }
            
            request.getSession().setAttribute(
                Strings.CART_KEY,
                orderDetail
            );
        }
    }
}
