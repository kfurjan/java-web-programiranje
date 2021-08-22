<%-- 
    Document   : purchaseHistory
    Created on : 21.08.2021., 20:18:07
    Author     : Kevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://algebra.hr/taglib" prefix="jwp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Purchase history</title>
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
                <table id="orderDetailsTable" class="table table-striped table-borderless table-hover">
                    <thead>
                      <tr>
                        <th scope="col">User</th>
                        <th scope="col">Time</th>
                        <th scope="col">Purchase #</th>
                        <th scope="col">Purchase Status</th>
                        <th scope="col">Payment Method</th>
                        <th scope="col">Total price (kn)</th>
                      </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${orderDetails}" var="orderDetail">
                        <tr>
                            <td>${orderDetail.user}</td>
                            <td>${orderDetail.paymentDetail.createdAt}</td>
                            <td>${orderDetail.id}</td>
                            <td>${orderDetail.paymentDetail.paymentStatus}</td>
                            <td>${orderDetail.paymentDetail.paymentMethod}</td>
                            <td>${orderDetail.totalPrice}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                  </table>
             </div>
         </div>
        
        <jwp:js-tag/>
        <script>
            $(document).ready(function () {
                $('#orderDetailsTable').DataTable();
            });
        </script>
    </body>
</html>
