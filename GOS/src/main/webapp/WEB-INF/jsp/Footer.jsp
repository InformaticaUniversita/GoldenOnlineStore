<%@ page import="java.util.List" %>
<%@ page import="model.Categoria" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype HTML>
<html lang="en">
<body style="background-color: #FFE4C4;">
<head>
    <title>Golden Online Store</title>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </head>
    <!-- Footer -->
    <footer class="text-center text-lg-start bg-white text-muted">
        <!-- Section: Social media -->
        <section class="d-flex justify-content-center justify-content-lg-between p-4 border-bottom">
            <!-- Left -->
            <div class="me-5 d-none d-lg-block">
                <span>Resta connesso con noi:</span>
            </div>
            <!-- Left -->

            <!-- Right -->
            <div>
                <a href="" class="me-4 link-secondary">
                    <i class="fab fa-facebook-f"></i>
                </a>
                <a href="" class="me-4 link-secondary">
                    <i class="fab fa-twitter"></i>
                </a>
                <a href="" class="me-4 link-secondary">
                    <i class="fab fa-google"></i>
                </a>
                <a href="" class="me-4 link-secondary">
                    <i class="fab fa-instagram"></i>
                </a>
                <a href="" class="me-4 link-secondary">
                    <i class="fab fa-linkedin"></i>
                </a>
                <a href="" class="me-4 link-secondary">
                    <i class="fab fa-github"></i>
                </a>
            </div>
            <!-- Right -->
        </section>
        <!-- Section: Social media -->

        <!-- Section: Links  -->
        <section class="">
            <div class="container text-center text-md-start mt-5">
                <!-- Grid row -->
                <div class="row mt-3">
                    <!-- Grid column -->
                    <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
                        <!-- Content -->
                        <h6 class="text-uppercase fw-bold mb-4">
                            <i class="fas fa-gem me-3 text-secondary">Golden Online Store</i>
                        </h6>
                        <p>
                            Aperti dal 1993.
                        </p>
                    </div>
                    <!-- Grid column -->

                    <!-- Grid column -->
                    <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
                        <!-- Links -->
                        <h6 class="text-uppercase fw-bold mb-4">
                            Prodotti
                        </h6>
                        <li>
                            <a>Action Figure</a>
                            <menu>
                                <c:forEach items="${categorie1}" var="categorie1">
                                    <menuitem>
                                        <a href="Categoria?id=<c:out value="${categorie1.id}"/>">
                                            <c:out value="${categorie1.nome}" /></a>
                                    </menuitem>
                                </c:forEach>
                            </menu>
                        </li>
                        <li>
                            <a>Giochi di carte</a>
                            <menu>
                                <c:forEach items="${categorie2}" var="categorie2">
                                    <menuitem>
                                        <a href="Categoria?id=<c:out value="${categorie2.id}"/>">
                                            <c:out value="${categorie2.nome}" /></a>
                                    </menuitem>
                                </c:forEach>
                            </menu>
                        </li>
                        </li>
                        <li>
                            <a>Fumetti</a>
                            <menu>
                                <c:forEach items="${categorie3}" var="categorie3">
                                    <menuitem>
                                        <a href="Categoria?id=<c:out value="${categorie3.id}"/>"><c:out
                                                value="${categorie3.nome}" /></a>
                                    </menuitem>
                                </c:forEach>
                            </menu>
                        </li>
                    </div>
                    <!-- Grid column -->

                    <!-- Grid column -->
                    <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
                        <!-- Links -->
                        <h6 class="text-uppercase fw-bold mb-4">Contattaci</h6>
                        <p><i class="fas fa-home me-3 text-secondary"></i> Via delle grazie 14, Battipaglia (SA)</p>
                        <p>
                            <i class="fas fa-envelope me-3 text-secondary"></i>
                            goldenonlinestore@gmail.com
                        </p>
                        <p><i class="fas fa-phone me-3 text-secondary"></i> 089 34 45 65</p>
                        <p><i class="fas fa-print me-3 text-secondary"></i> 345 34 46 778</p>
                    </div>
                    <!-- Grid column -->
                </div>
                <!-- Grid row -->
            </div>
        </section>
        <!-- Section: Links  -->

        <!-- Copyright -->
        <div class="text-center p-4" style="background-color: rgba(0, 0, 0, 0.025);">
            2021 Copyright:
            <a class="text-reset fw-bold">GoldenOnlineStore</a>
        </div>
        <!-- Copyright -->
    </footer>
    <!-- Footer -->
</body>