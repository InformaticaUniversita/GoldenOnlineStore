<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="Header.jsp">
  <jsp:param name="pageTitle" value="Registrazione utente"/>
</jsp:include>

<body>
<section>
  <hr>
  <form action="ModificaDati" method="post">
    <h1>Bentornato ${utente.nome}</h1>
    <label>Nome</label>
    <p>${utente.nome}</p>
    <label>Cognome</label>
    <p>${utente.cognome}</p>
    <label>Email</label>
    <p>${utente.email}</p>
    <label>Password</label>
    <p>${utente.password}</p>
    <label>Username</label>
    <p>${utente.username}</p>
    <input type="submit" value="Modifica dati">
  </form>
  <hr>
  <%@ include file="Footer.jsp" %>
</section>
</body>
</html>