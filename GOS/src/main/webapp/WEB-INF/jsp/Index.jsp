
<%@ page import="model.Prodotto" %>
<%@ page import="java.util.List" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<jsp:include page="Header.jsp">
    <jsp:param name="pageTitle" value="Home"/>
</jsp:include>
<meta charset="UTF-8">
<section>
    <link href="${pageContext.request.contextPath}/css/animate.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css" type="text/css">
    <link rel="stylesheet" href="css/bare.min.css" type="text/css">
    <div class="slideshow-container">

        <!-- Full-width images with number and caption text -->
        <div class="mySlides">
            <div class="numbertext">1 / 3</div>
            <img src="img/Fumetteria1.jpeg" style="width:100%">
        </div>

        <div class="mySlides">
            <div class="numbertext">2 / 3</div>
            <img src="img/Fumetteria2.jpeg" style="width:100%">
        </div>

        <div class="mySlides">
            <div class="numbertext">3 / 3</div>
            <img src="img/Fumetteria1.jpeg" style="width:100%">
        </div>


    </div>
    <br>

    <!-- The dots/circles -->
    <div style="text-align:center">
        <span class="dot" onclick="currentSlide(1)"></span>
        <span class="dot" onclick="currentSlide(2)"></span>
        <span class="dot" onclick="currentSlide(3)"></span>
    </div>
</section>
<section >
    <grid>
        <c:forEach items="${Prodotti}" var="prodotto">
            <div col="1/3">
                <h3>
                    <a href="Prodotto?id=<c:out value="${prodotto.id}"/>"><c:out value="${prodotto.nome}" /></a>
                </h3>
                <a href="Prodotto?id=<c:out value="${prodotto.id}"/>"><img src="img/products/prodotto${prodotto.id}.jpeg"></a>
                <h4>Prezzo: <c:out value="${prodotto.prezzo}" /> &euro;</h4>
            </div>
        </c:forEach>
    </grid>
</section>
<script>
    var slideIndex = 0;
    showSlides();

    function showSlides() {
        var i;
        var slides = document.getElementsByClassName("mySlides");
        var dots = document.getElementsByClassName("dot");
        for (i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";
        }
        slideIndex++;
        if (slideIndex > slides.length) {slideIndex = 1}
        for (i = 0; i < dots.length; i++) {
            dots[i].className = dots[i].className.replace(" active", "");
        }
        slides[slideIndex-1].style.display = "block";
        dots[slideIndex-1].className += " active";
        setTimeout(showSlides, 4000); // Change image every 2 seconds
    }
</script>
<%@include file="Footer.jsp"%>
