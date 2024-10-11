<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Employees</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<section id="add-form">
    <form action="${pageContext.request.contextPath}/update-emp" method="POST" enctype="application/x-www-form-urlencoded">
        <label for="nom">Nom :</label>
        <input type="text" value="${employee.getLastname()}" id="nom" name="nom" required>

        <label for="prenom">Prénom :</label>
        <input type="text" value="${employee.getName()}" id="prenom" name="prenom" required>

        <label for="tel">Téléphone :</label>
        <input type="tel" value="${employee.getTel()}" id="tel" name="tel" required pattern="[0-9]{10}" placeholder="0612345678">

        <label for="email">Email :</label>
        <input type="email" value="${employee.getEmail()}" id="email" name="email" required>

        <label for="poste">Poste :</label>
        <input type="text" value="${employee.getPoste()}" id="poste" name="poste" required>

        <label for="nss">Numéro de sécurité nationale</label>
        <input type="number" value="${employee.getNss()}" name="nss" id="nss">

        <label for="departement">Département :</label>
        <input type="text" value="${employee.getDepartment()}" id="departement" name="departement" required>

        <label for="insertion">Insertion :</label>
        <input type="date" id="insertion" value="${employee.getDate_insertion()}" name="insertion">

        <input hidden value="${employee.getId()}" name="id">
        <input hidden name="_method" value="UPDATE">
        <button type="submit">Ajouter l'employé</button>
    </form>
</section>

</body>
</html>