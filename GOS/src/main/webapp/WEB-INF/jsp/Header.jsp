<%@ page import="java.util.List" %>
<%@ page import="model.Categoria" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype HTML>
<html lang="en">
<head>
    <title>Golden Online Store</title>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </head>

    <!-- meta -->
    <meta charset=utf-8>
    <meta name="description" content="BareCSS template file">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no"/>

    <!-- css -->

    <link href="css/bare.min.css" rel="stylesheet" type="text/css">
</head>
<body style="background-color: #FFE4C4">
<nav><!-- use fx attribute for fixed positioning -->
    <label>
        <ul>
            <div>
                <a href="Home"><img src="img/logoSito.png" style="width: auto" height="50px"></a>
            </div>
            <!-- Caricamento delle varie categorie di prodotti all'interno dell'header della home-->
            <li>
                <p style="margin-left: 30px">Action Figure</p>
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
                <p style="margin-left: 30px">Giochi di carte</p>
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
                <p style="margin-left: 30px">Fumetti</p>
                <menu>
                    <c:forEach items="${categorie3}" var="categorie3">
                        <menuitem>
                            <a href="Categoria?id=<c:out value="${categorie3.id}"/>"><c:out
                                    value="${categorie3.nome}" /></a>
                        </menuitem>
                    </c:forEach>
                </menu>
            </li>

            <li>
                <c:choose>
                    <c:when test="${utente == null && amministratore == null}">
                        <!-- In caso l'utente non sia loggato verrà data la possibilità di effettuare il login mediante un menù a tendina-->
                        <a> <img src="img/profilo.png" style="width: 50px" height="50px"> </a>
                        <menu>
                            <menuitem>
                                <card>
                                    <form action="LoginServlet" method="post">
                                        <input type="text" name="username" value="Spaghettino"><br>
                                        <input type="password" name="password" value="Ciaone55"><br>
                                        <input type="submit" value="Login">
                                    </form>
                                </card>
                            </menuitem>
                            <menuitem>
                                <form action="Registrazione" method="post">
                                    <input type="submit" value="Registrazione">
                                </form>
                            </menuitem>
                            <menuitem>
                                <card>
                                    <form action="LoginAmministratoreServlet" method="post">
                                        <input type="text" name="username" value="Username"><br>
                                        <input type="password" name="password" value="Password"><br>
                                        <input type="text" name="codice" value="codice"><br>
                                        <input type="submit" value="Login Amministratore">
                                    </form>
                                </card>
                            </menuitem>
                        </menu>
                    </c:when>


                    <c:otherwise>
                        <!-- In caso l'utente sia loggato avrà la possibilità di controllare il proprio profilo o la pagina dei propri ordini -->
                        <a> <img src="img/profilo.png" style="width: 50px" height="50px"> </a>
                        <menu>
                            <c:choose>
                                <c:when test="${utente != null}">
                                    <menuitem><a href="PaginaProfilo">Profilo</a> </menuitem>
                                    <menuitem><a href="VisualizzaOrdini">I miei ordini</a> </menuitem>
                                    <menuitem>
                                        <card>
                                            <form action="Logout">
                                                <input type="submit" value="Logout">
                                            </form>
                                        </card>
                                    </menuitem>
                                </c:when>
                                <c:otherwise>
                                    <menuitem><a href="AggiuntaProdottoForm">Aggiungi prodotto</a> </menuitem>
                                    <menuitem>
                                        <card>
                                            <form action="Logout">
                                                <input type="submit" value="Logout">
                                            </form>
                                        </card>
                                    </menuitem>
                                </c:otherwise>
                            </c:choose>
                        </menu>
                    </c:otherwise>
                </c:choose>

            </li>
            <c:if test="${amministratore == null}">
                <li><a href="Carrello"><img src="img/carrello.png" style="width: 50px" height="50px"></a></li>
            </c:if>
        </ul>
    </label>
</nav>
