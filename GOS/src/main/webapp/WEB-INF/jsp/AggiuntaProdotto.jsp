<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var ="operazione" value="${param.rimuovi != null ? 'Rimozione' : (prodotto == null ? 'Aggiungi' : 'Modifica')}"/>
<jsp:include page="Header.jsp">
    <jsp:param name="pageTitle" value="${operazione}prodotto"/>
</jsp:include>
<section>
    <h1>Aggiunta prodotto</h1>
    <h5 style="color: red">${notifica}</h5>
    <c:if test="${param.rimuovi == null}">
        <form action="AggiuntaProdotto" method="post">
            <input type="hidden" name="id" value="">
            <label>Categoria</label>
            <input type="text" name="categoria" value="">
            <br>
            <label>Nome</label>
            <input type="text" name="nome" value="">
            <label>Descrizione</label>
            <textarea name ="descrizione"></textarea>
            <label>Prezzo</label>
            <input type="number" name="prezzo" value="">
            <label>Marca</label>
            <textarea name="marca"></textarea>
            <input type="submit" value="Aggiungi prodotto">
        </form>
    </c:if>
</section>
<%@include file="Footer.jsp"%>