<%-- 
    Document   : userHistory
    Created on : 11.08.2021., 18:56:09
    Author     : Kevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://algebra.hr/taglib" prefix="jwp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>User history</title>
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
                                            <li><a class="dropdown-item" href="#">Product</a></li>
                                            <li><a class="dropdown-item" href="#">Product category</a></li>
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
                <table id="userHistoryTable" class="table table-striped table-borderless table-hover">
                    <thead>
                      <tr>
                        <th scope="col">#</th>
                        <th scope="col">User</th>
                        <th scope="col">Date and time</th>
                        <th scope="col">IP Address</th>
                      </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${userHistory}" var="userHistory">
                        <tr>
                            <th scope="row">${userHistory.id}</th>
                            <td>${userHistory.user}</td>
                            <td>${userHistory.logInAt}</td>
                            <td>${userHistory.ipAddress}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                  </table>
             </div>
         </div>
        
        <jwp:js-tag/>
        <script>
            $(document).ready(function () {
                $('#userHistoryTable').DataTable();
            });
        </script>
    </body>
</html>
