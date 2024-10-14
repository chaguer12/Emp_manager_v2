<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EmpManager</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<div class="container">
    <a href="/offer">recruiter</a>
    <!-- Form Section -->
    <section id="add-form">
        <h1 class="title">Welcome back admin!</h1>
        <form action="/add-employee" method="POST" enctype="application/x-www-form-urlencoded">
            <label for="nom">Nom :</label>
            <input type="text" id="nom" name="nom" required>

            <label for="prenom">Prénom :</label>
            <input type="text" id="prenom" name="prenom" required>

            <label for="tel">Téléphone :</label>
            <input type="tel" id="tel" name="tel" required pattern="[0-9]{10}" placeholder="0612345678">

            <label for="email">Email :</label>
            <input type="email" id="email" name="email" required>

            <label for="password">Password :</label>
            <input type="password" id="password" name="password" required>

            <label for="poste">Poste :</label>
            <input type="text" id="poste" name="poste" required>

            <label for="nss">NSS :</label>
            <input type="number" id="nss" name="nss">

            <label for="insertion">Insertion :</label>
            <input type="date" id="insertion" name="insertion">

            <label for="departement">Département :</label>
            <input type="text" id="departement" name="departement" required>

            <input hidden name="_method" value="ADD">
            <button type="submit">Ajouter l'employé</button>
        </form>
        <form action="/emplist" method="get" enctype="application/x-www-form-urlencoded">
            <input hidden name="_method" value="LIST">
            <button id="edit-btn" type="submit">See employees</button>
        </form>
    </section>
</div>

</body>
</html>
