<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<jsp:include page="Header.jsp">
  <jsp:param name="productPage" value="Home"/>
</jsp:include>
<div col="1/3">
  <img src="img/products/prodotto${prodotto.id}.jpeg">
</div>
<div col="1/3">
  <h1>
    <a>${prodotto.nome}</a>
  </h1>
  ${prodotto.descrizione}
</div>
<div col="3/3">
  <c:if test="${amministratore != null}">
    <form action="AdminProdotto" method="post">
      <input type="hidden" name="id" value="${prodotto.id}">
      <input type="submit" value="modifica">
      <input type="submit" name="rimuovi" value="Rimuovi">
    </form>
  </c:if>
  <p>Marca: ${prodotto.marca}
  </p>
  <h4>Prezzo: ${prodotto.prezzo} &euro; </h4>
  <form action="Carrello" method="post">
    <label>Quantità:</label>
    <select name="addNum">
      <c:forEach begin="1" end="30" varStatus="loop">
        <option value="${loop.index}">${loop.index}</option>
      </c:forEach>
    </select>
    <input type="hidden" name="prodId" value="${prodotto.id}">
    <input type="submit" value="Aggiungi al carrello">
  </form>
</div>
<%@include file="Footer.jsp"%>