
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var ="operazione" value="${param.rimuovi != null ? 'Rimozione' : (prodotto == null ? 'Aggiungi' : 'Modifica')}"/>
<jsp:include page="Header.jsp">
    <jsp:param name="pageTitle" value="${operazione}prodotto"/>
</jsp:include>
<section>
    <h1>Modifica prodotto</h1>
    <h5>${notifica}</h5>
    <c:if test="${param.rimuovi == null}">
        <form action="ModificaProdotto?id=${prodotto.id}" method="post">
            <input type="hidden" name="idProdotto" value="${prodotto.id}">
            <label>Categoria</label>
            <input type="text" name="categoria" value="${categoria}">
            <br>
            <label>Nome</label>
            <input type="text" name="nome" value="${prodotto.nome}">
            <label>Descrizione</label>
            <textarea name ="descrizione">${prodotto.descrizione}</textarea>
            <label>Prezzo</label>
            <input type="number" name="prezzo" value="${prodotto.prezzo}">
            <label>Marca</label>
            <textarea name="marca">${prodotto.marca}</textarea>
            <input type="submit" value="Modifica">
        </form>
    </c:if>
</section>
<%@include file="Footer.jsp"%>