<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="utf-8"%>

<!DOCTYPE html>
<jsp:include page="Header.jsp">
    <jsp:param name="pageTitle" value="${categoria.nome}"/>
</jsp:include>

<section>
    <c:if test="${!Amministratore}">
        <h1>${categoria.nome}</h1>
    </c:if>
    <c:if test="${Amministratore != null}">
        <form action="AdminCategoria" method="post">
            <h1>${categoria.nome}
                <input type="hidden" name="id" value="${categoria.id}">
                <input type="submit" value="Modifica">
                <input type="submit" name="rimuovi" value="Rimuovi">
            </h1>
        </form>
    </c:if>
    <p>${categoria.descrizione}</p>
    <p text="r" fs="s">Ordine:
        <c:forEach items="${ord.values()}" var="o">
            <c:choose>
                <c:when test="${o == 'DEFAULT'}">
                    <c:set var="desc" value="default" />
                </c:when>
                <c:when test="${o == 'PREZZO_ASC'}">
                    <c:set var="desc" value="prezzo (crescente)" />
                </c:when>
                <c:when test="${o == 'PREZZO_DESC'}">
                    <c:set var="desc" value="prezzo (decrescente)" />
                </c:when>
            </c:choose>
            <c:choose>
                <c:when test="${o == ord}">
                    <i>${desc}</i>
                </c:when>
                <c:otherwise>
                    <a href="?id=${param.id}&perpag=${perpag}&ord=${o}">${desc}</a>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </p>
    <grid>
        <div class="container text-center">
            <div class="row row-cols-2">
                <c:forEach items="${prodotti}" var="prodotto">
                    <div class="col">
                        <div class="card" style="margin: 0 auto; float: none; margin-bottom: 10px; width: 300px; height: auto; max-width: 100%;">
                            <img class="card-img-top" src="img/products/prodotto${prodotto.id}.jpeg" alt="Card image">
                            <div class="card-body">
                                <h4 class="card-title">${prodotto.nome}</h4>
                                <p class="card-text">${prodotto.descrizione}</p>
                                <p class="card-text">Prezzo:${prodotto.prezzo}€</p>
                                <a href="Prodotto?id=${prodotto.id}" class="btn btn-primary" style="background-color: crimson; color: white;">Visualizza</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <c:if test="${empty prodotti}">
            <div col="1">Nessun prodotto nella categoria.</div>
        </c:if>

        <div col="1/1" txt = "c" style="background-color:#E8E8E8">
            <a <c:if test="${pag > 1}">href="?id=${param.id}&pag =${pag - 1}"</c:if>>&larr; precedente</a>
            &emsp;
            <c:forEach begin="1" end="${npag}" varStatus="loop">
                <c:choose>
                    <c:when test="${loop.index == pag}">
                        <b>${loop.index}</b>
                    </c:when>
                    <c:otherwise>
                        <a href="?id=${param.id}&pag=${loop.index}">${loop.index}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            &emsp;
            <a <c:if test="${pag < npag}">href="?id=${param.id}&pag=${pag + 1}" </c:if>>successiva &rarr; </a>
        </div>
    </grid>
</section>
<%@include file="Footer.jsp"%>