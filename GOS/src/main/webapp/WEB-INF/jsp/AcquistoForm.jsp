<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<body>
<jsp:include page="Header.jsp">
    <jsp:param name="pageTitle" value="Acquisto"/>
</jsp:include>
<section>
    <form action="Pagamento" method="post">
        <br>
        <label>Nome</label>
        <h5 style="color:red"> <c:if test="${!empty nome}">
            <c:out value="${nome}"/>
        </c:if>
        </h5>
        <input type="text" name="nome" value="${utente.nome}">
        <label>Cognome</label>
        <h5 style="color:red"> <c:if test="${!empty cognome}">
            <c:out value="${cognome}"/>
        </c:if>
        </h5>
        <input type="text" name ="cognome" value="${utente.cognome}">
        <label>Email</label>
        <h5 style="color:red"> <c:if test="${!empty email}">
            <c:out value="${email}"/>
        </c:if>
        </h5>
        <input type="text" name="email" value="${utente.email}">
        <label>Provincia</label>
        <h5 style="color:red"> <c:if test="${!empty provincia}">
            <c:out value="${provincia}"/>
        </c:if>
        </h5>
        <input type="text" name="provincia" placeholder="Inserire provincia">
        <label>Città</label>
        <h5 style="color:red"> <c:if test="${!empty city}">
            <c:out value="${city}"/>
        </c:if>
        </h5>
        <input type="text" name="city" placeholder="Inserire la città">
        <label>CAP</label>
        <h5 style="color:red"> <c:if test="${!empty cap}">
            <c:out value="${cap}"/>
        </c:if>
        </h5>
        <input type="text" name="cap" placeholder="Inserire il cap">
        <label>Indirizzo</label>
        <h5 style="color:red"> <c:if test="${!empty indirizzo}">
            <c:out value="${indirizzo}"/>
        </c:if>
        </h5>
        <input type="text" name="indirizzo" placeholder="Inserire l'indirizzo">
        <label>Numero Carta</label>
        <h5 style="color:red"> <c:if test="${!empty numeroCarta}">
            <c:out value="${numeroCarta}"/>
        </c:if>
        </h5>
        <input type="text" name="numeroCarta" placeholder="Inserire numero carta">
        <label>CVV</label>
        <h5 style="color:red"> <c:if test="${!empty cvv}">
            <c:out value="${cvv}"/>
        </c:if>
        </h5>
        <input type="text" name ="cvv" placeholder= "CVV">
        <label>Data di scadenza carta</label>
        <h5 style="color:red"> <c:if test="${!empty dataScadenza}">
            <c:out value="${dataScadenza}"/>
        </c:if>
        </h5>
        <input type="text" name="dataScadenza" placeholder= "GG/MM/AAAA">
        <label>Nome intestatario carta</label>
        <h5 style="color:red"> <c:if test="${!empty nomeIntestatario}">
            <c:out value="${nomeIntestatario}"/>
        </c:if>
        </h5>
        <input type="text" name="nomeIntestatario" placeholder="Nome e cognome intestatario carta">
        <label></label>
        <c:choose>
            <c:when test="${utente != null}">
                <input type="submit" value="Avanti">
            </c:when>
            <c:otherwise>
                <label>
                    <h5 style="color:red">Effettua l'accesso per completare l'acquisto</h5>
                </label>
            </c:otherwise>
        </c:choose>
    </form>
</section>
</body>
<script>
    var borderOk = '2px solid #080';
    var borderNo = '2px solid #f00';
    var usernameOk = false;
    var nomeOk = false;
    var cognomeOK = false;
    var passwordOk = false;
    var emailOk = false;
    var cartaOk = false;

    function validaUsername(){
        var input = document.forms['Pagamento']['username'];
        if (input.value.length >= 6 && input.value.match(/^[0-9a-zA-Z]+$/)){
            var xmlHttpReq = new XMLHttpRequest();
            xmlHttpReq.onreadystatechange = function(){
                if(this.readyState == 4 && this.status == 200 && this.responseText =='<ok/>'){
                    usernameOk = true;
                    input.style.border = borderOk;
                }else{
                    input.style.border = borderNo;
                    usernameOk = false;
                }
                cambiaStatoRegistrami()
            }
            xmlHttpReq.open("GET","VerificaUsername?username="+encodeURIComponent(input.value),true);
            xmlHttpReq.send();
        }else{

        }
    }

    function validaNome(){
        var input = document.forms['Pagamento']['nome'];
        if(input.value.trim().length > 0 && input.value().match(/^[a-zA-Z\u00C0-\u00ff]+$/)) {
            input.style.border = borderOk;
            nomeOk = true;
        }else {
            input.style.border = borderNo;
            nomeOk = false;
        }
        cambiaStatoRegistrami();
    }

    function validaCognome(){
        var input = document.forms['Pagamento']['cognome'];
        if(input.value.trim().length > 0 && input.value().match(/^[a-zA-Z\u00C0-\u00ff]+$/)) {
            input.style.border = borderOk;
            nomeOk = true;
        }else {
            input.style.border = borderNo;
            nomeOk = false;
        }
        cambiaStatoRegistrami();
    }

    function validaEmail(){
        var input = document.forms['Pagamento']['email'];
        if(input.value.match(/^\w+([\.-]?w+)'@\w+([\.-]?\w+)*(\.\w+)+$/)){
            input.style.border = borderOk;
            emailOk = true;
        }else {
            input.style.border = borderNo;
            emailOk = false;
        }
        cambiaStatoRegistrami();
    }

    function validaCarta(){
        var input = document.forms['Pagamento']['carta'];
        if(input.value.match(/^\w+([\.-]?w+)'@\w+([\.-]?\w+)*(\.\w+)+$/)){
            input.style.border = borderOk;
            cartaOk = true;
        }else {
            input.style.border = borderNo;
            emailOk = false;
        }
        cambiaStatoRegistrami();
    }

    function cambiaStatoRegistrami(){
        if(usernameOk && nomeOk && cognomeOK && passwordOk && emailOk){
            document.getElementById('registrami').disabled = false;
            document.getElementById('registramimessaggio').innerHTML ='';
        }else{
            document.getElementById('registrami').disabled = true;
            document.getElementById('registramimessaggio').innerHTML = 'Verifica che tutti i campi siano in verde.';
        }
    }

</script>
<%@include file="Footer.jsp"%>