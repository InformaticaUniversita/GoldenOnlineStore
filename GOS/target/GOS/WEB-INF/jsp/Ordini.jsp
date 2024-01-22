<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="Header.jsp">
  <jsp:param name="pageTitle" value="Ordini"/>
</jsp:include>
<section>
  <table>
    <thead>
    <tr>
      <th>Numero ordine</th>
      <th>Data Ordine</th>
      <th>Data consegna</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${ordini}" var="ordine">
      <tr>
        <td>${ordine.id}</td>
        <td>${ordine.dataOrdine}</td>
        <td>${ordine.dataSpedizione}</td>
        <td>
          <form action="VisualizzaOrdine?id=${ordine.id}" method="post">
            <input type="submit" value="Visualizza Dettagli" style="color: red">
          </form>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</section>
<%@include file="Footer.jsp"%>