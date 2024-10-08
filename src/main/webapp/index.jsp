<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>EmpManager</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<div class="container">
    <!-- Form Section -->
    <section id="add-form">
        <h1 class="title">Welcome back admin!</h1>
        <form action="/add-employee" method="POST" enctype="application/x-www-form-urlencoded">
            <label for="nom">Nom :</label><br>
            <input type="text" id="nom" name="nom" required><br><br>

            <label for="prenom">Prénom :</label><br>
            <input type="text" id="prenom" name="prenom" required><br><br>

            <label for="tel">Téléphone :</label><br>
            <input type="tel" id="tel" name="tel" required pattern="[0-9]{10}" placeholder="0612345678"><br><br>

            <label for="email">Email :</label><br>
            <input type="email" id="email" name="email" required><br><br>

            <label for="poste">Poste :</label><br>
            <input type="text" id="poste" name="poste" required><br><br>

            <label for="departement">Département :</label><br>
            <input type="text" id="departement" name="departement" required><br><br>
            <input hidden name="_method" value="ADD">
            <button type="submit">Ajouter l'employé</button>
        </form>
        <form action="/emplist" method="get" enctype="application/x-www-form-urlencoded">
            <input hidden name="_method" value="LIST">
            <button id="edit-btn"  type="submit" >See employees</button>
        </form>
    </section>


</div>



</body>
</html>