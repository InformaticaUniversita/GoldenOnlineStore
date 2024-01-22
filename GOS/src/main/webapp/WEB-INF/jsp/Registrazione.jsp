<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="Header.jsp">
  <jsp:param name="pageTitle" value="Registrazione utente"/>
</jsp:include>
<section>
  <h1>Registrazione utente</h1>
  <h5>Riempi tutti i campi</h5>
  <h5 style="color:red"> <c:if test="${!empty errore}">
    <c:out value="${errore}"/>
  </c:if>
  </h5>
  <form name="registrazione" action="Registrazione" method="get" onsubmit= return validate()>
    <label>Username(almeno 6 caratteri), solo lettere e numeri, non utilizzato da altri utenti</label>
    <h5 style="color:red"> <c:if test="${!empty username}">
      <c:out value="${username}"/>
    </c:if>
    </h5>
    <input type="text" name="username" >
    <label>Password (almeno 8 caratteri, deve contenere: una lettera maiuscola, un numero)</label>
    <h5 style="color:red"> <c:if test="${!empty password}">
      <c:out value="${password}"/>
    </c:if>
    </h5>
    <input type="password" name="password" >
    <label>Password conferma</label>
    <h5 style="color:red"> <c:if test="${!empty confermaPassword}">
      <c:out value="${confermaPassword}"/>
    </c:if>
    </h5>
    <input type="password" name="passwordConferma" >
    <label>Nome(solo lettere)</label>
    <h5 style="color:red"> <c:if test="${!empty nome}">
      <c:out value="${nome}"/>
    </c:if>
    </h5>
    <input type="text" name="nome" >
    <label>Cognome(solo lettere)</label>
    <h5 style="color:red"> <c:if test="${!empty cognome}">
      <c:out value="${cognome}"/>
    </c:if>
    </h5>
    <input type="text" name="cognome" >
    <label> Email</label>
    <h5 style="color:red"> <c:if test="${!empty email}">
      <c:out value="${email}"/>
    </c:if>
    </h5>
    <input type="email" name="email" >
    <input id="registrami" type="submit" value="Registrami"><span id="registramimessaggio"></span>
  </form>
</section>

<%@ include file="Footer.jsp"%>