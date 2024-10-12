<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Offer</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/recruiter.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
</head>
<body>
<section class="offer-section">
    <div class="container">
        <div class="image-container">
            <img src="/view/images/work.jpg" alt="Work Image">
        </div>
        <div class="form-container">
            <h1>Add a New Job Offer</h1>
            <form action="/add-offer" method="post" enctype="application/x-www-form-urlencoded">
                <div class="form-group">
                    <label for="title">Title:</label>
                    <input type="text" name="title" id="title" placeholder="Job Title" required>
                </div>
                <div class="form-group">
                    <label for="description">Description:</label>
                    <textarea name="desc" id="description" rows="4" placeholder="Job Description" required></textarea>
                </div>
                <div class="form-group">
                    <label for="end_date">End Date:</label>
                    <input type="date" name="end_date" id="end_date" required>
                </div>
                <div class="form-group">

                    <input hidden name="_method" value="ADD">
                </div>
                <button type="submit" class="submit-btn">Submit</button>
            </form>
        </div>
    </div>
</section>
</body>
</html>
