<%-- 
    Document   : productCategory
    Created on : 12.08.2021., 18:05:27
    Author     : Kevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://algebra.hr/taglib" prefix="jwp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Product category</title>
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
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#createProductCategory">
                    Create new product category
                </button>
                
                <c:if test="${not empty productCategoryErrorMessage}">
                    <div class="alert alert-danger mt-3 alert-dismissible fade show" role="alert">
                        ${productCategoryErrorMessage}
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>
                </c:if>
            </div>
        </div>
        
        <div class="container p-5">
             <div class="row justify-content-center">
                <table id="productCategoryTable" class="table table-striped table-borderless table-hover">
                    <thead>
                      <tr>
                        <th scope="col">#</th>
                        <th scope="col">Name</th>
                        <th scope="col">Description</th>
                      </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${productCategory}" var="category">
                        <tr>
                            <td scope="row">${category.id}</td>
                            <td>${category.name}</td>
                            <td>${category.description}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                  </table>
             </div>
         </div>

        <!-- Modal - Create new category -->
        <div id="createProductCategory" class="modal fade" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Create new product category</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
              <div class="modal-body">
                  <form id="createProductCategoryForm">
                    <div class="mb-3">
                      <label for="categoryNameCreate" class="form-label">Category name</label>
                      <input type="text" class="form-control" id="categoryNameCreate" name="categoryNameCreate">
                    </div>
                    <div class="mb-3">
                      <label for="categoryDescriptionCreate" class="form-label">Category description</label>
                      <input type="text" class="form-control" id="categoryDescriptionCreate" name="categoryDescriptionCreate">
                    </div>
                  </form>
              </div>
              <div class="modal-footer">
                <button id="btnCreateProductCategory" name="btnCreateProductCategory" type="button" class="btn btn-outline-primary" value="btnCreateProductCategory_clicked">Create</button>
              </div>
            </div>
          </div>
        </div>
        
        <!-- Modal - Update/Delete category-->
        <div id="updateDeleteProductCategory" class="modal fade" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Update or delete product category</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
              <div class="modal-body">
                  <form id="createProductCategoryForm">
                    <div class="mb-3">
                      <label for="categoryID" class="form-label">Product category ID</label>
                      <input type="text" class="form-control" id="categoryID" name="categoryID" disabled>
                    </div>
                    <div class="mb-3">
                      <label for="categoryName" class="form-label">Category name</label>
                      <input type="text" class="form-control" id="categoryNameUpdateDelete" name="categoryNameUpdateDelete">
                    </div>
                    <div class="mb-3">
                      <label for="categoryDescription" class="form-label">Category description</label>
                      <input type="text" class="form-control" id="categoryDescriptionUpdateDelete" name="categoryDescriptionUpdateDelete">
                    </div>
                  </form>
              </div>
              <div class="modal-footer">
                <button id="btnUpdateProductCategory" type="button" class="btn btn-outline-success">Update</button>
                <button id="btnDeleteProductCategory" type="button" class="btn btn-outline-danger">Delete</button>
              </div>
            </div>
          </div>
        </div>
        
        <jwp:js-tag/>
        <script>
            $(function() {
                // show table
                let table = $('#productCategoryTable').DataTable();
                
                // create new category
                $('#btnCreateProductCategory').on("click", function(e){
                    e.preventDefault();
                    $.ajax({
                        url: 'ProductCategory',
                        type: 'POST', 
                        data: {
                            categoryNameCreate: $('#categoryNameCreate').val(),
                            categoryDescriptionCreate: $('#categoryDescriptionCreate').val(),
                            btnCreateProductCategory: 'true'
                        },
                        success: function () {
                            location.href = 'ProductCategory';
                        }
                    });
                });
                
                // table on click listeners
                $('#productCategoryTable tbody').on( 'click', 'tr', function () {
                    if ($(this).hasClass('selected')) {
                        $(this).removeClass('selected');
                        
                        $('#categoryID').val('');
                        $('#categoryNameUpdateDelete').val('');
                        $('#categoryDescriptionUpdateDelete').val('');
                    } else {
                        table.$('tr.selected').removeClass('selected');
                        $(this).addClass('selected');
                        
                        let dataRow = $(this).find("td").map(function() {
                            return $(this).html();
                        });
                        
                        $('#categoryID').val(dataRow[0]);
                        $('#categoryNameUpdateDelete').val(dataRow[1]);
                        $('#categoryDescriptionUpdateDelete').val(dataRow[2]);
                        
                        new bootstrap.Modal(
                            document.getElementById('updateDeleteProductCategory')
                        ).show();
                    }
                });
                
                // update category
                $('#btnUpdateProductCategory').on("click", function(e) {
                    e.preventDefault();
                    $.ajax({
                        url: 'ProductCategory',
                        type: 'POST', 
                        data: {
                            categoryID: $('#categoryID').val(),
                            categoryNameUpdateDelete: $('#categoryNameUpdateDelete').val(),
                            categoryDescriptionUpdateDelete: $('#categoryDescriptionUpdateDelete').val(),
                            btnUpdateProductCategory: 'true'
                        },
                        success: function () {
                            location.href = 'ProductCategory';
                        }
                    });
                });
               
                // delete category
                $('#btnDeleteProductCategory').on("click", function(e) {
                    e.preventDefault();
                    $.ajax({
                        url: 'ProductCategory',
                        type: 'POST', 
                        data: {
                            categoryID: $('#categoryID').val(),
                            categoryNameUpdateDelete: $('#categoryNameUpdateDelete').val(),
                            categoryDescriptionUpdateDelete: $('#categoryDescriptionUpdateDelete').val(),
                            btnDeleteProductCategory: 'true'
                        },
                        success: function () {
                            location.href = 'ProductCategory';
                        }
                    });
                });
            });
        </script>
    </body>
</html>
