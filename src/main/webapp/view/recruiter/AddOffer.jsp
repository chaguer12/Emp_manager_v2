<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Job Offers</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/recruiter.css">
</head>
<body>

<section class="offer-section">
    <div class="container">
        <h1>Published Job Offers</h1>
        <button class="open-modal-btn">Add New Offer</button>

        <!-- Display Job Offers -->
        <div class="job-offers-list">
            <!-- Example job offer card -->
            <div class="job-offer">
                <h2>Software Engineer</h2>
                <p>Description of the job offer.</p>
                <p>End Date: 2024-12-31</p>
                <button class="update-btn">Update</button>
                <button class="delete-btn">Delete</button>
            </div>
            <!-- More job offers go here -->
        </div>
    </div>
</section>

<!-- Modal for Adding a New Job Offer -->
<div class="modal" id="addOfferModal">
    <div class="modal-content">
        <span class="close-btn">&times;</span>
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
                    <input hidden name="_method" value="ADD">
                </div>
                <button type="submit" class="submit-btn">Submit</button>
            </form>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/main.js"></script>
</body>
</html>
