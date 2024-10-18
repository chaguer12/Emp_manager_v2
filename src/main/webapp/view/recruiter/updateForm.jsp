<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Job Offers</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            color: #333;
        }

        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        /* Image Styling */
        .image-container {
            text-align: center;
            margin-bottom: 20px;
        }

        .image-container img {
            width: 100%;
            max-height: 300px;
            object-fit: cover;
        }

        /* Form Styling */
        .form-container {
            width: 100%;
            max-width: 600px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 8px;
        }

        input[type="text"],
        input[type="date"],
        textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
            box-sizing: border-box;
        }

        textarea {
            resize: vertical;
        }

        button.submit-btn {
            width: 100%;
            padding: 12px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
        }

        button.submit-btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="image-container">
    <img src="/view/images/work.jpg" alt="Work Image">
</div>
<div class="form-container">
    <h1>Update a Job Offer</h1>
    <form action="/update-offer" method="post" enctype="application/x-www-form-urlencoded">
        <div class="form-group">
            <label for="title">Title:</label>
            <input type="text" value="${offer.getTitle()}" name="title" id="title" placeholder="Job Title" required>
        </div>
        <div class="form-group">
            <label for="description">Description:</label>
            <textarea name="desc"   id="description" rows="4" placeholder="Job Description" required>${offer.getDesc()}</textarea>
        </div>
        <div class="form-group">
            <label for="end_date">End Date:</label>
            <input type="date" value="${offer.getEndDate()}" name="end_date" id="end_date" required>
            <input hidden name="id" value="${offer.getId()}">
            <input hidden name="_method" value="UPDATE">
        </div>
        <button type="submit" class="submit-btn">Submit</button>
    </form>
</div>

</body>
</html>
