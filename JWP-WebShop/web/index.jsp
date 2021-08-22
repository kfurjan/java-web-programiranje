<%-- 
    Document   : index
    Created on : May 12, 2021, 9:02:49 PM
    Author     : efurkev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://algebra.hr/taglib" prefix="jwp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>JWP WebShop</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
                <c:if test="${not empty homeErrorMessage}">
                   <div class="alert alert-danger alert-dismissible fade show" role="alert">
                       ${homeErrorMessage}
                       <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                   </div>
                </c:if>
                <table id="productTable" class="table table-striped table-borderless table-hover">
                    <thead>
                      <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Description</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">Category</th>
                        <th scope="col">Price (kn)</th>
                      </tr>
                    </thead>
                    <tbody>
                    <c:if test="${not empty availableProducts}"> 
                        <c:forEach items="${availableProducts}" var="product">
                            <tr>
                                <td data-product-id="${product.id}">${product.name}</td>
                                <td data-sku="${product.sku}">${product.description}</td>
                                <td>${product.quantity}</td>
                                <td data-category-id="${product.category.id}">${product.category}</td>
                                <td>${product.price}</td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    </tbody>
                  </table>
             </div>
         </div>
        
        <!-- Modal - Order product -->
        <div id="orderProductModal" class="modal fade" tabindex="-1" aria-labelledby="orderProductModal" aria-hidden="true">
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
                      <label for="productTotalQuantity" class="form-label">Product total quantity</label>
                      <input type="text" class="form-control" id="productTotalQuantity" name="productTotalQuantity" disabled>
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
                <button id="btnOrderProduct" name="btnOrderProduct" type="button" class="btn btn-outline-primary" value="btnOrderProduct_clicked">Order</button>
              </div>
            </div>
          </div>
        </div>
        
        <jwp:js-tag/>
        <script>
            $(function() {
                let productId, categoryId, sku;
                
                // show table
                let table = $('#productTable').DataTable();
                
                // table on click listeners
                $('#productTable tbody').on( 'click', 'tr', function () {
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
                        $('#productTotalQuantity').val(dataRow[2]);
                        $('#productCategory').val(dataRow[3]);
                        $('#productPrice').val(dataRow[4]);
                        
                        $('#productQuantityToOrder').attr({
                            "max": dataRow[2],
                            "min": 1
                         });
                        
                        new bootstrap.Modal(
                            document.getElementById('orderProductModal')
                        ).show();
                    }
                });
                
                // order product
                $('#btnOrderProduct').on("click", function(e) {
                    e.preventDefault();
                    $.ajax({
                        url: 'OrderProduct',
                        type: 'POST', 
                        data: {
                            productIdOrder: productId,
                            productNameOrder: $('#productName').val(),
                            productDescriptionOrder: $('#productDesc').val(),
                            productSkuOrder: sku,
                            productTotalQuantityOrder: $('#productTotalQuantity').val(),
                            productCategoryOrder: $('#productCategory').val(),
                            productCategoryIdOrder: categoryId,
                            productPriceOrder: $('#productPrice').val(),
                            productQuantityToOrder: $('#productQuantityToOrder').val(),
                            btnOrderProduct: 'true'
                        },
                        success: function () {
                            location.reload();
                        }
                    });
                });
            });
        </script>
    </body>
</html>