<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="Header.jsp">
    <jsp:param name="pageTitle" value="Carrello"/>
</jsp:include>
<section>
    <h1>Carrello</h1>
    <grid>
        <c:forEach items="${carrello.prodotti}" var="pq">
            <div col="1/3">
                <a href="Prodotto?id=${pq.prodotto.id}"><img src="img/products/prodotto${pq.prodotto.id}.jpeg"></a>
            </div>
            <div col="2/3">
                <h3>
                    <a href="Prodotto?id=${pq.prodotto.id}">${pq.prodotto.nome}</a>
                </h3>
                <p>${pq.prodotto.descrizione}</p>
                <h5>Quantità:${pq.quantità}</h5>
                <h5>Prezzo Unitario:${pq.prodotto.prezzo}€</h5>
                <h5>Prezzo totale:${pq.prezzoTot}€</h5>
                <form action="Carrello" method="post">
                    <input type="hidden" name="prodId" value="${pq.prodotto.id}">
                    <input type="hidden" name="setNum" value="0">
                    <input type="submit" value="Rimuovi">
                </form>
                <form action="Carrello" method="post">
                    <input type="hidden" name="prodId" value="${pq.prodotto.id}">
                    <input type="hidden" name="operazione" value="modificaQuantita">
                    <input type="number" name="nuovaQuantita" value="${pq.quantità}">
                    <input type="submit" value="Modifica Quantità">
                </form>
            </div>
        </c:forEach>
        <c:if test="${empty carrello.prodotti}">
            <div col="1">
                <h5 style="color:red">Nessun prodotto inserito nel carrello</h5>
            </div>
        </c:if>
    </grid>
</section>
<c:if test="${not empty carrello.prodotti}">
    <section>
        <grid>
            <div col="1/3">
                <h2>Totale:${carrello.prezzoTot}</h2>
            </div>
            <div col="1/3">
                <form action="Pagamento" method = get>
                    <input type="submit" value="Completa acquisto">
                </form>
            </div>
            <div col="2/3">
                <form action="Carrello" method = post>
                    <input type="hidden" name="operazione" value="svuotaCarrello">
                    <input type="submit" value="Svuota Carrello">
                </form>
            </div>
        </grid>
    </section>
</c:if>
<%@include file="Footer.jsp"%>