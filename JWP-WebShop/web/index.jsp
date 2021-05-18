<%-- 
    Document   : index
    Created on : May 12, 2021, 9:02:49 PM
    Author     : efurkev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://algebra.hr/taglib" prefix="jwp" %>

<!DOCTYPE html>
<html>
    <head>
        <title>JWP WebShop</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <jwp:css-tag/>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
            <div class="container">
                <a class="navbar-brand" href="#">JWP WebShop</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link custom-underline" aria-current="page" href="#">Home</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle custom-underline" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Categories
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="#">Action</a></li>
                                <li><a class="dropdown-item" href="#">Another action</a></li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="navbar-nav me-end mb-2 mb-lg-0">
                        <li class="nav-item mx-2">
                            <a class="nav-link custom-underline active" href="/Login">
                                <i class="bi bi-person"></i> Login
                            </a>
                        </li>
                        <li class="nav-itemw mx-2">
                            <a class="nav-link custom-underline active" href="#">
                                <i class="bi bi-cart2"></i> Cart
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        
        <jwp:js-tag/>
    </body>
</html>