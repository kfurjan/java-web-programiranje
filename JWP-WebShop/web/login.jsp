<%-- 
    Document   : login
    Created on : May 14, 2021, 8:12:29 PM
    Author     : efurkev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://algebra.hr/taglib" prefix="jwp" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
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
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link custom-underline" aria-current="page" href="/">Home</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <form method="POST" action="/LoginServlet">
            <div class="contaienr p-5">
                <div class="row justify-content-center">
                    <div class="col-md-3"></div>
                    <div class="col-md-3 bg-light rounded p-5 border border-info">
                        <h4 class="text-center my-3">Sign in</h4>
                        <div class="form-group my-3">
                            <label for="email" class="form-text">Email address</label>
                            <input type="email" class="form-control" name="email" placeholder="name@example.com">
                        </div>
                        <div class="form-group my-3">
                            <label for="password" class="form-text">Password</label>
                            <input type="password" class="form-control" name="password">
                        </div>
                        <div class="form-group text-center my-3">
                            <input type="submit" value="Sign in" class="btn btn-outline-primary" />
                        </div>
                        
                        <hr class="mt-4" />
                        
                        <div class="text-center">
                            <a class="link-dark" aria-current="page" href="#">Register</a>
                        </div>
                    </div>
                    <div class="col-md-3"></div>
                </div>
            </div>
        </form>

        <jwp:js-tag/>
    </body>
</html>
