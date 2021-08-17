<%-- 
    Document   : product
    Created on : 14.08.2021., 09:57:56
    Author     : Kevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://algebra.hr/taglib" prefix="jwp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Product</title>
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
                            <a class="nav-link custom-underline active" href="#">
                                <i class="bi bi-cart2"></i> Cart
                            </a>
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
                                        <li><a class="dropdown-item" href="#">Purchase history</a></li>
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
                                        <li><a class="dropdown-item" href="#">Completed purchases</a></li>
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
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#createProduct">
                    Create new product
                </button>
                
                <c:if test="${not empty productErrorMessage}">
                    <div class="alert alert-danger mt-3" role="alert">
                        ${productErrorMessage}
                    </div>
                </c:if>
            </div>
        </div>
          
        <div class="container p-5">
             <div class="row justify-content-center">
                <table id="productTable" class="table table-striped table-borderless table-hover">
                    <thead>
                      <tr>
                        <th scope="col">Product #</th>
                        <th scope="col">Name</th>
                        <th scope="col">Description</th>
                        <th scope="col">SKU</th>
                        <th scope="col">Price</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">Category</th>
                        <th scope="col">Category #</th>
                      </tr>
                    </thead>
                    <tbody>
                    <c:if test="${not empty products}"> 
                        <c:forEach items="${products}" var="product">
                            <tr>
                                <td scope="row">${product.id}</td>
                                <td>${product.name}</td>
                                <td>${product.description}</td>
                                <td>${product.sku}</td>
                                <td>${product.price}</td>
                                <td>${product.quantity}</td>
                                <td>${product.category}</td>
                                <td>${product.category.id}</td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    </tbody>
                  </table>
             </div>
         </div>
        
        <!-- Modal - Create new product -->
        <div id="createProduct" class="modal fade" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Create new product</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
              <div class="modal-body">
                  <form id="createProductCategoryForm">
                    <div class="mb-3">
                      <label for="productNameCreate" class="form-label">Product name</label>
                      <input type="text" class="form-control" id="productNameCreate" name="productNameCreate">
                    </div>
                    <div class="mb-3">
                      <label for="productDescriptionCreate" class="form-label">Product description</label>
                      <input type="text" class="form-control" id="productDescriptionCreate" name="productDescriptionCreate">
                    </div>
                    <div class="mb-3">
                      <label for="productSkuCreate" class="form-label">SKU</label>
                      <input type="text" class="form-control" id="productSkuCreate" name="productSkuCreate">
                    </div>
                    <div class="mb-3">
                      <label for="productPriceCreate" class="form-label">Price</label>
                      <input type="text" class="form-control" id="productPriceCreate" name="productPriceCreate">
                    </div>
                    <div class="mb-3">
                      <label for="productQuantityCreate" class="form-label">Quantity</label>
                      <input type="text" class="form-control" id="productQuantityCreate" name="productQuantityCreate">
                    </div>
                    <div class="mb-3">
                        <label for="productCategoryCreate">Category</label>
                        <select class="form-control" id="productCategoryCreate">
                            <c:forEach items="${productCategory}" var="category">
                                <option value="${category.id}">${category}</option>
                            </c:forEach>
                        </select>
                    </div>
                  </form>
              </div>
              <div class="modal-footer">
                <button id="btnCreateProduct" name="btnCreateProduct" type="button" class="btn btn-outline-primary" value="btnCreateProduct_clicked">Create</button>
              </div>
            </div>
          </div>
        </div>
        
        <!-- Modal - update/delete product -->
        <div id="updateDeleteProduct" class="modal fade" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Update or delete product</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
              <div class="modal-body">
                  <form id="createProductCategoryForm">
                    <div class="mb-3">
                      <label for="productIDUpdateDelete" class="form-label">Product ID</label>
                      <input type="text" class="form-control" id="productIDUpdateDelete" name="productIDUpdateDelete" disabled>
                    </div>
                    <div class="mb-3">
                      <label for="productNameUpdateDelete" class="form-label">Product name</label>
                      <input type="text" class="form-control" id="productNameUpdateDelete" name="productNameUpdateDelete">
                    </div>
                    <div class="mb-3">
                      <label for="productDescriptionUpdateDelete" class="form-label">Product description</label>
                      <input type="text" class="form-control" id="productDescriptionUpdateDelete" name="productDescriptionUpdateDelete">
                    </div>
                    <div class="mb-3">
                      <label for="productSkuUpdateDelete" class="form-label">SKU</label>
                      <input type="text" class="form-control" id="productSkuUpdateDelete" name="productSkuUpdateDelete">
                    </div>
                    <div class="mb-3">
                      <label for="productPriceUpdateDelete" class="form-label">Price</label>
                      <input type="text" class="form-control" id="productPriceUpdateDelete" name="productPriceUpdateDelete">
                    </div>
                    <div class="mb-3">
                      <label for="productQuantityUpdateDelete" class="form-label">Quantity</label>
                      <input type="text" class="form-control" id="productQuantityUpdateDelete" name="productQuantityUpdateDelete">
                    </div>
                    <div class="mb-3">
                        <label for="productCategoryUpdateDelete">Category</label>
                        <select class="form-control" id="productCategoryUpdateDelete">
                            <c:forEach items="${productCategory}" var="category">
                                <option value="${category.id}">${category}</option>
                            </c:forEach>
                        </select>
                    </div>
                  </form>
              </div>
              <div class="modal-footer">
                <button id="btnUpdateProduct" name="btnUpdateProduct" type="button" class="btn btn-outline-success" value="btnUpdateProduct_clicked">Update</button>
                <button id="btnDeleteProduct" name="btnDeleteProduct" type="button" class="btn btn-outline-danger" value="btnDeleteProduct_clicked">Delete</button>
              </div>
            </div>
          </div>
        </div>
        
        <jwp:js-tag/>
        <script>
            $(function() {
                // show table
                let table = $('#productTable').DataTable();

                // create new product
                $('#btnCreateProduct').on("click", function(e){
                    e.preventDefault();
                    $.ajax({
                        url: 'Product',
                        type: 'POST', 
                        data: {
                            productNameCreate: $('#productNameCreate').val(),
                            productDescriptionCreate: $('#productDescriptionCreate').val(),
                            productSkuCreate: $('#productSkuCreate').val(),
                            productPriceCreate: $('#productPriceCreate').val(),
                            productQuantityCreate: $('#productQuantityCreate').val(),
                            productCategoryCreateID: $('#productCategoryCreate option:selected').val(),
                            productCategoryCreateName: $('#productCategoryCreate option:selected').text(),
                            btnCreateProduct: 'true'
                        },
                        success: function () {
                            location.href = 'Product';
                        }
                    });
                });
                
                // table on click listeners
                $('#productTable tbody').on( 'click', 'tr', function () {
                    if ($(this).hasClass('selected')) {
                        $(this).removeClass('selected');
                        
                        $('#productIDUpdateDelete').val('');
                        $('#productNameUpdateDelete').val('');
                        $('#productDescriptionUpdateDelete').val('');
                        $('#productSkuUpdateDelete').val('');
                        $('#productPriceUpdateDelete').val('');
                        $('#productQuantityUpdateDelete').val('');
                        $('#productCategoryUpdateDelete').val('');
                    } else {
                        table.$('tr.selected').removeClass('selected');
                        $(this).addClass('selected');
                        
                        let dataRow = $(this).find("td").map(function() {
                            return $(this).html();
                        });

                        $('#productIDUpdateDelete').val(dataRow[0]);
                        $('#productNameUpdateDelete').val(dataRow[1]);
                        $('#productDescriptionUpdateDelete').val(dataRow[2]);
                        $('#productSkuUpdateDelete').val(dataRow[3]);
                        $('#productPriceUpdateDelete').val(dataRow[4]);
                        $('#productQuantityUpdateDelete').val(dataRow[5]);
                        $('#productCategoryUpdateDelete').val(dataRow[7]);
                        
                        new bootstrap.Modal(
                            document.getElementById('updateDeleteProduct')
                        ).show();
                    }
                });
                
                // update product
                $('#btnUpdateProduct').on("click", function(e) {
                    e.preventDefault();
                    $.ajax({
                        url: 'Product',
                        type: 'POST', 
                        data: {
                            productIDUpdateDelete: $('#productIDUpdateDelete').val(),
                            productNameUpdateDelete: $('#productNameUpdateDelete').val(),
                            productDescriptionUpdateDelete: $('#productDescriptionUpdateDelete').val(),
                            productSkuUpdateDelete: $('#productSkuUpdateDelete').val(),
                            productPriceUpdateDelete: $('#productPriceUpdateDelete').val(),
                            productQuantityUpdateDelete: $('#productQuantityUpdateDelete').val(),
                            productCategoryUpdateDelete: $('#productCategoryUpdateDelete option:selected').val(),
                            btnUpdateProduct: 'true'
                        },
                        success: function () {
                            location.href = 'Product';
                        }
                    });
                });

                // delete product
                $('#btnDeleteProduct').on("click", function(e) {
                    e.preventDefault();
                    $.ajax({
                        url: 'Product',
                        type: 'POST', 
                        data: {
                            productIDUpdateDelete: $('#productIDUpdateDelete').val(),
                            productNameUpdateDelete: $('#productNameUpdateDelete').val(),
                            productDescriptionUpdateDelete: $('#productDescriptionUpdateDelete').val(),
                            productSkuUpdateDelete: $('#productSkuUpdateDelete').val(),
                            productPriceUpdateDelete: $('#productPriceUpdateDelete').val(),
                            productQuantityUpdateDelete: $('#productQuantityUpdateDelete').val(),
                            productCategoryUpdateDelete: $('#productCategoryUpdateDelete option:selected').val(),
                            btnDeleteProduct: 'true'
                        },
                        success: function () {
                            location.href = 'Product';
                        }
                    });
                });
            });
        </script>
    </body>
</html>
