<%-- 
    Document   : cart
    Created on : 17.08.2021., 18:53:00
    Author     : Kevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://algebra.hr/taglib" prefix="jwp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Cart</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jwp:css-tag/>
    </head>
    <body>
        <%-- NAVBAR --%>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
            <div class="container">
                <a class="navbar-brand" href="/">JWP WebShop</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    </ul>
                    <ul class="navbar-nav me-end mb-2 mb-lg-0">
                        <li class="nav-itemw mx-2">
                            <c:choose>
                                <c:when test="${cart.orderItems.size() > 0}" >
                                    <a class="nav-link custom-underline active" href="/Cart">
                                        <i class="bi bi-cart2"></i> Cart <span class="badge bg-danger">${cart.orderItems.size()}</span>
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <a class="nav-link custom-underline active" href="/Cart">
                                        <i class="bi bi-cart2"></i> Cart
                                    </a>
                                </c:otherwise>
                            </c:choose>
                        </li>
                        <c:choose>
                        <c:when test="${empty user}" >
                            <li class="nav-item mx-2">
                                <a class="nav-link custom-underline active" href="/Login">
                                    <i class="bi bi-person"></i> Login
                                </a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle custom-underline" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    ${user}
                                </a>
                                    <c:choose>
                                    <c:when test="${user.userType.type eq 'Admin'}" >
                                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                            <h5 class="dropdown-header">User management</h5>
                                            <li><a class="dropdown-item" href="/UserHistory">History</a></li>
                                            <div class="dropdown-divider"></div>
                                            <h5 class="dropdown-header">Webshop management</h5>
                                            <li><a class="dropdown-item" href="/PurchaseHistory">Purchase history</a></li>
                                            <div class="dropdown-divider"></div>
                                            <h5 class="dropdown-header">Product management</h5>
                                            <li><a class="dropdown-item" href="/Product">Product</a></li>
                                            <li><a class="dropdown-item" href="/ProductCategory">Product category</a></li>
                                            <div class="dropdown-divider"></div>
                                            <li><a class="dropdown-item text-danger" href="/Logout">Log out</a></li>
                                        </ul>
                                    </c:when>
                                    <c:otherwise>
                                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                            <h5 class="dropdown-header">User information</h5>
                                            <li><a class="dropdown-item" href="/PurchaseHistory">Completed purchases</a></li>
                                            <div class="dropdown-divider"></div>
                                            <li><a class="dropdown-item text-danger" href="/Logout">Log out</a></li>
                                        </ul>
                                    </c:otherwise>
                                    </c:choose>
                            </li>
                        </c:otherwise>
                        </c:choose>
                    </ul>
                </div>
            </div>
        </nav>
        
        <div class="container p-5">
             <div class="row justify-content-center">
                <c:if test="${not empty successfulPurchase}"> 
                   <div class="alert alert-success alert-dismissible fade show" role="alert">
                        ${successfulPurchase}
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                   </div>
                </c:if>
                <c:if test="${empty user}"> 
                   <div class="alert alert-primary alert-dismissible fade show" role="alert">
                        In order to complete purchase, please log in
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                   </div>
                </c:if>
                <c:if test="${not empty cartErrorMessage}">
                   <div class="alert alert-danger alert-dismissible fade show" role="alert">
                        ${cartErrorMessage}
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                   </div>
                </c:if>
                <table id="cartTable" class="table table-striped table-borderless table-hover">
                    <thead>
                      <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Description</th>
                        <th scope="col">Category</th>
                        <th scope="col">Order quantity</th>
                        <th scope="col">Price (kn)</th>
                        <th scope="col">Total (kn)</th>
                      </tr>
                    </thead>
                    <tbody>
                    <c:if test="${not empty cart}"> 
                        <c:forEach items="${cart.orderItems}" var="orderItem">
                            <tr>
                                <td data-product-id="${orderItem.product.id}">${orderItem.product.name}</td>
                                <td data-sku="${orderItem.product.sku}">${orderItem.product.description}</td>
                                <td data-category-id="${orderItem.product.category.id}">${orderItem.product.category}</td>
                                <td data-product-quantity="${orderItem.product.quantity}">${orderItem.quantity}</td>
                                <td>${orderItem.product.price}</td>
                                <td><fmt:formatNumber type="number" maxFractionDigits="2" value="${orderItem.quantity * orderItem.product.price}" /></td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    </tbody>
                  </table>
                <div class="p-3 d-flex justify-content-end">
                    <h3>
                       Total price: <b><fmt:formatNumber type="number" maxFractionDigits="2" value="${cart.totalPrice}" /> kn</b>
                    </h3>
                </div>
                <c:if test="${not empty user && not empty cart}"> 
                    <div id="onDeliveryPaymentDiv" class="d-flex justify-content-center">
                        <div class="d-grid gap-2 col-2 mx-auto">
                           <button id="btnPayOnDelivery" type="button" class="btn btn-outline-primary btn-lg">Pay on delivery</button>
                        </div>
                    </div>
                    <div class="p-5 d-flex justify-content-center">
                        <div id="onPayPalPaymentDiv" class="d-grid gap-2 col-2 mx-auto"></div>
                    </div>
                 </c:if>
             </div>
         </div>
                     
        <!-- Modal - Update/Delete cart -->
        <div id="cartModal" class="modal fade" tabindex="-1" aria-labelledby="cartModal" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Order product</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
              <div class="modal-body">
                  <form id="orderProductForm">
                    <div class="mb-3">
                      <label for="productName" class="form-label">Product name</label>
                      <input type="text" class="form-control" id="productName" name="productName" disabled>
                    </div>
                    <div class="mb-3">
                      <label for="productDesc" class="form-label">Product description</label>
                      <input type="text" class="form-control" id="productDesc" name="productDesc" disabled>
                    </div>
                    <div class="mb-3">
                      <label for="productCategory" class="form-label">Product category</label>
                      <input type="text" class="form-control" id="productCategory" name="productCategory" disabled>
                    </div>
                    <div class="mb-3">
                      <label for="productPrice" class="form-label">Product price (kn)</label>
                      <input type="text" class="form-control" id="productPrice" name="productPrice" disabled>
                    </div>
                    <div class="mb-3">
                      <label for="productQuantityToOrder" class="form-label">Quantity to order</label>
                      <input type="number" class="form-control" id="productQuantityToOrder" name="productQuantityToOrder">
                    </div>
                  </form>
              </div>
              <div class="modal-footer">
                <button id="btnUpdateCartItem" name="btnUpdateCartItem" type="button" class="btn btn-outline-success" value="btnUpdateCartItem_clicked">Update</button>
                <button id="btnDeleteCartItem" name="btnDeleteCartItem" type="button" class="btn btn-outline-danger" value="btnDeleteCartItem_clicked">Delete</button>
              </div>
            </div>
          </div>
        </div>
        
        <jwp:js-tag/>
        <script src="https://www.paypal.com/sdk/js?client-id=Aa18pNSaHaWmhAChuoYk3smo2VYRhiNjAZU7PAv0s_UvDXr_Yj7jS0Q8ickqkKfQRgQhaQ9W40LqoqJJ&currency=EUR"></script>
        <script>            
            $(function() {
                let productId, categoryId, sku;
                let table = $('#cartTable').DataTable();
                
                // table on click listeners
                $('#cartTable tbody').on( 'click', 'tr', function () {
                    if ($(this).hasClass('selected')) {
                        $(this).removeClass('selected');
                    } else {
                        table.$('tr.selected').removeClass('selected');
                        $(this).addClass('selected');
                                                
                        let dataRow = $(this).find("td").map(function() {
                            return $(this).html();
                        });
                        let productIdArray = $(this).find("td[data-product-id]").map(function() {
                            return $(this).data("product-id");
                        });
                        let productTotalQuantityArray = $(this).find("td[data-product-quantity]").map(function() {
                            return $(this).data("product-quantity");
                        });
                        let categoryIdArray = $(this).find("td[data-category-id]").map(function() {
                            return $(this).data("category-id");
                        });
                        let skuArray = $(this).find("td[data-sku]").map(function() {
                            return $(this).data("sku");
                        });
                        
                        productId  = productIdArray[0];
                        categoryId = categoryIdArray[0];
                        sku = skuArray[0];
                        
                        $('#productName').val(dataRow[0]);
                        $('#productDesc').val(dataRow[1]);
                        $('#productCategory').val(dataRow[2]);
                        $('#productPrice').val(dataRow[4]);
                        $('#productQuantityToOrder').val(dataRow[3]);
                        
                        $('#productQuantityToOrder').attr({
                            "max": productTotalQuantityArray[0],
                            "min": 1
                         });
                        
                        new bootstrap.Modal(
                            document.getElementById('cartModal')
                        ).show();
                    }
                });
                
                // delete product from cart
                $('#btnDeleteCartItem').on("click", function(e) {
                    e.preventDefault();
                    $.ajax({
                        url: 'Cart',
                        type: 'POST', 
                        data: {
                            productIdCart: productId,
                            btnDeleteCartItem: 'true'
                        },
                        success: function () {
                            location.reload();
                        }
                    });
                });
                
                // update product in cart
                $('#btnUpdateCartItem').on("click", function(e) {
                    e.preventDefault();
                    $.ajax({
                        url: 'Cart',
                        type: 'POST', 
                        data: {
                            productIdCart: productId,
                            productQuantityToOrder: $('#productQuantityToOrder').val(),
                            btnUpdateCartItem: 'true'
                        },
                        success: function () {
                            location.reload();
                        }
                    });
                });
                
                // Pay on-delivery
                $('#btnPayOnDelivery').on("click", function(e) {
                    e.preventDefault();                    
                    $.ajax({
                        url: 'Cart',
                        type: 'POST', 
                        data: {
                            paymentType: 'On delivery'
                        },
                        success: function () {
                            location.reload();
                        }
                    });
                });
                
                // Pay with PayPal
                paypal.Buttons({
                    createOrder: function(data, actions) {
                        return actions.order.create({
                            purchase_units: [{
                                amount: {
                                    value: "${cart.totalPrice}"
                                }
                            }]
                        });
                    },
                    onApprove: function(data, actions) {
                      return actions.order.capture().then(function(details) {
                        $.ajax({
                            url: 'Cart',
                            type: 'POST', 
                            data: {
                                paymentType: 'PayPal'
                            },
                            success: function () {
                                location.reload();
                            }
                        });
                      });
                    }
                }).render('#onPayPalPaymentDiv');             
            });
        </script>
    </body>
</html>
