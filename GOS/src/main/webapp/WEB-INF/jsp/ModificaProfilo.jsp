<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="Header.jsp">
    <jsp:param name="pageTitle" value="Modifica Profilo"/>
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
    <button type="submit" style="background-color: red; color: white" onclick="confermaEliminazione()">Cancella il profilo</button>
    <script>
        function confermaEliminazione(){
            var conferma = confirm("Eliminare l'account? Sei sicuro?");
            if(conferma){
                var form = document.createElement("form");
                form.setAttribute("method", "post");
                form.setAttribute("action", "CancellazioneProfilo?username=${utente.username}");
                document.body.appendChild(form);
                form.submit();
            }
        }
    </script>
    <%@ include file="Footer.jsp" %>
</section>
</body>
</html>