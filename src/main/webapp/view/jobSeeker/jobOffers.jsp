<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Available job offers</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/recruiter.css">
</head>
<body>
<section class="offer-section">
    <div class="container">
        <h1>Published Job Offers</h1>
        <button class="open-modal-btn">Apply to an offer</button>

        <!-- Display Job Offers -->
        <div class="job-offers-list">
            <c:forEach var="offer" items="${offers}">
                <!-- Example job offer card -->
                <div class="job-offer">
                    <h2>${offer.getTitle()}</h2>
                    <p>${offer.getDesc()}</p>
                    <p>End Date: ${offer.getEndDate()}</p>
                    <p>Status:
                        <c:choose>
                            <c:when test="${offer.isStatus()}"> <!-- Assuming status is a boolean property -->
                                <span style="color: green;">Active</span>
                            </c:when>
                            <c:otherwise>
                                <span style="color: red;">Inactive</span>
                            </c:otherwise>
                        </c:choose>
                    </p>
                    <form method="post" action="${pageContext.request.contextPath}/delete-offer">
                        <input hidden name="_method" value="DELETE">
                        <input hidden name="id" value="${offer.getId()}">
                        <button class="delete-btn">Delete</button>
                    </form>

                </div>
                <!-- More job offers go here -->
            </c:forEach>
        </div>
    </div>
</section>
</body>
</html>
