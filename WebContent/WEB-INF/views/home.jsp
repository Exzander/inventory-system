<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inventory System</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
</head>
<body>

    <div class="container">
        <div class="header">
            <div>
                <h1>Welcome, <c:out value="${currentUser.username}"/></h1>
                <p>Inventory Management System Dashboard</p>
            </div>

            <a class="logout-btn" href="${pageContext.request.contextPath}/logout">Logout</a>
        </div>

        <h2 class="section-title">General Features</h2>

        <div class="grid">
            <div class="card">
                <h3>Room Management</h3>
                <p>View all rooms and manage room information.</p>

                <a href="${pageContext.request.contextPath}/room-list">View Rooms</a>
            </div>

            <div class="card">
                <h3>Item Management</h3>
                <p>View inventory items and monitor stock information.</p>

                <a href="${pageContext.request.contextPath}/item-list">View Items</a>
            </div>
        </div>

        <c:if test="${currentUser.role eq 'ADMIN'}">
            <h2 class="admin-title">Administrator Features</h2>

            <div class="grid">
                <div class="card">
                    <h3>Register User</h3>
                    <p>Create a new account for another system user.</p>

                    <a href="${pageContext.request.contextPath}/register">Register User</a>
                </div>

                <div class="card">
                    <h3>Create Room</h3>
                    <p>Add a new room to the inventory database.</p>

                    <a href="${pageContext.request.contextPath}/create-room">Create Room</a>
                </div>

                <div class="card">
                    <h3>Create Item</h3>
                    <p>Add a new inventory item and assign it to a room.</p>

                    <a href="${pageContext.request.contextPath}/create-item">
                        Create Item
                    </a>
                </div>
            </div>
        </c:if>
    </div>

</body>
</html>