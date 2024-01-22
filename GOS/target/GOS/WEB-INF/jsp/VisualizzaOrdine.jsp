<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Date" %>

<jsp:include page="Header.jsp">
  <jsp:param name="pageTitle" value="Ordine"/>
</jsp:include>
<section>
  <grid>
    <h1>Ordine N."${id}"</h1>

    <c:forEach items="${prodotti}" var="prodotti">
      <div col="1/3">
        <img src="img/products/prodotto${prodotti.id}.jpeg"></a>
      </div>
      <div col="2/3">
        <h3>
          <a>${prodotti.nome}</a>
        </h3>
        <p>${prodotti.descrizione}</p>
      </div>
    </c:forEach>
    <div col="3/3">
      <a>Data ordine: ${ordine.dataOrdine}</a><br>
      <a>Data spedizione: ${ordine.dataSpedizione}</a><br>
      <a>Totale ordine: ${ordine.prezzoTotale}</a>
    </div>
    <c:set var="oggi" value="<%= new java.util.Date() %>"></c:set>
    <c:choose>
      <c:when test="${ordine.dataSpedizione.after(oggi)}">
        <button type="submit" style="color: red" onclick="confermaEliminazione()">Annulla Ordine</button>
        <script>
          function confermaEliminazione(){
            var conferma = confirm("Eliminare l'ordine?");
            if(conferma){
              var form = document.createElement("form");
              form.setAttribute("method", "post");
              form.setAttribute("action", "AnnullaOrdine?id=${ordine.id}");
              document.body.appendChild(form);
              form.submit();
            }
          }
        </script>
      </c:when>
      <c:otherwise>
        <h2 style="color: red">L'ordine non può essere più annullato, è già stato spedito!</h2>
      </c:otherwise>
    </c:choose>

  </grid>

<%@include file="Footer.jsp"%>