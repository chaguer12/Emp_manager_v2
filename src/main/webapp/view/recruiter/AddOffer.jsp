<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add offer</title>
</head>
<body>
    <section>
        <div id="container">
            <div>
                <img src="/view/recruiter/images/work.jpg">
            </div>
            <div id="form-container">
                <form action="/add-offer" method="post" enctype="application/x-www-form-urlencoded">
                    <label for="title">Title:</label>
                    <input type="text" name="title" id="title" placeholder="title">
                    <label for="description">Description:</label>
                    <input type="text" name="desc" id="description" placeholder="Description">
                    <label for="end_Date">End date:</label>
                    <input id="end_date" name="end_date" placeholder="End Date">
                </form>
            </div>
        </div>
    </section>
</body>
</html>
