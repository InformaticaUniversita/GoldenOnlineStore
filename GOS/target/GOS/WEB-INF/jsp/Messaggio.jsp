<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="Header.jsp">
  <jsp:param name="pageTitle" value="Registrazione utente"/>
</jsp:include>
<section>
  <div>
    <h1 type="text" name="messaggio">${messaggio}</h1>
    <a href="Home" class="btn btn-primary">Torna alla HomePage</a>
  </div>
</section>
<%@ include file="Footer.jsp"%>
