<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="Header.jsp">
  <jsp:param name="pageTitle" value="Registrazione utente"/>
</jsp:include>

<body>
<section>
  <hr>
  <form action="ModificaDati" method="get">
    <h1>Bentornato ${utente.nome}</h1>
    <label>Nome</label>
    <input type="text" name="nome" value="${utente.nome}" readonly>
    <label>Cognome</label>
    <input type="text" name ="cognome"value="${utente.cognome}" readonly>
    <label>Email</label>
    <input type="text" name="email"value="${utente.email}">
    <label>Password</label>
    <input type="password" name="password"value="${utente.password}">
    <label>Conferma Nuova Password</label>
    <input type="password" name="passwordConferma"value="">
    <label>Username</label>
    <input type="text" name="username"value="${utente.username}">
    <input type="submit" value="Modifica dati">
  </form>
  <%@ include file="Footer.jsp" %>
</section>
</body>
</html>