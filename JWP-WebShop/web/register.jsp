<%-- 
    Document   : register
    Created on : May 18, 2021, 9:40:48 AM
    Author     : efurkev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://algebra.hr/taglib" prefix="jwp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Register user</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jwp:css-tag/>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
            <div class="container">
                <a class="navbar-brand" href="/">JWP WebShop</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
            </div>
        </nav>

        <form method="POST" action="/Register">
            <div class="contaienr p-5">
                <div class="row justify-content-center">
                    <div class="col-md-3"></div>
                    <div class="col-md-4 bg-light rounded p-5 border border-info">
                        <h4 class="text-center my-3">Register new user</h4>
                        <c:if test="${not empty errorMessage}">
                            <div class="alert alert-danger" role="alert">
                                ${errorMessage}
                            </div>
                         </c:if>
                        <div class="form-group my-3">
                            <label for="email" class="form-text">Email address</label>
                            <input type="email" class="form-control" name="email" placeholder="name@example.com">
                        </div>
                        <div class="form-group my-3">
                            <label for="email" class="form-text">First name</label>
                            <input type="text" class="form-control" name="firstName">
                        </div>
                        <div class="form-group my-3">
                            <label for="email" class="form-text">Last name</label>
                            <input type="text" class="form-control" name="lastName">
                        </div>
                        <div class="form-group my-3">
                            <label for="password" class="form-text">Password</label>
                            <input type="password" class="form-control" name="password">
                        </div>
                        <div class="form-group my-3">
                            <label for="passwordRepeat" class="form-text">Repeat password</label>
                            <input type="password" class="form-control" name="passwordRepeat">
                        </div>
                        <div class="form-group text-center my-3">
                            <input type="submit" value="Register" class="btn btn-outline-primary" />
                        </div>
                    </div>
                    <div class="col-md-3"></div>
                </div>
            </div>
        </form>

        <jwp:js-tag/>
    </body>
</html>
