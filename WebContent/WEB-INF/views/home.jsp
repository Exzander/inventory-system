<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inventory System Home</title>
</head>
<body>


    <h2>Welcome ${username}</h2>

    <h3>Inventory Items</h3><br>
    <a href="${pageContext.request.contextPath}/items">View Items</a><br><br>

    <!-- Clerk / Admin Features -->
    <c:if test="${currentUser.role eq 'Clerk' || currentUser.role eq 'Admin'}">
        <h3>Manage Stock Levels</h3><br>
        <a href="${pageContext.request.contextPath}/items/stock">Update Stock</a><br><br>
    </c:if>

    <!-- Admin Exclusive Features -->
    <c:if test="${currentUser.role eq 'Admin'}">
        <h3>Manage Rooms</h3><br>
        <a href="${pageContext.request.contextPath}/rooms/manage">Manage Rooms</a><br><br>

        <h3>Register New User</h3><br>
        <a href="${pageContext.request.contextPath}/register">Register User</a><br><br>
    </c:if>

    <a href="${pageContext.request.contextPath}/logout">Logout</a>
</body>
</html>