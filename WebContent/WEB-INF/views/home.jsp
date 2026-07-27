<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inventory System</title>
</head>
<body>

    <div class="main-container">

        <h1>Welcome, <c:out value="${currentUser.username}"/></h1>

        <!-- Available to all authenticated users -->
        <div class="room-list">
            <h3>Room Management</h3>
            <a href="${pageContext.request.contextPath}/room-list">
                View Rooms
            </a>
        </div>

        <div class="item-list">
            <h3>Item Management</h3>
            <a href="${pageContext.request.contextPath}/item-list">
                View Items
            </a>
        </div>

        <!-- Admin Features -->
        <c:if test="${currentUser.role eq 'ADMIN'}">

            <div class="registration-container">
                <h3>Register New User</h3>
                <a href="${pageContext.request.contextPath}/register">
                    Register User
                </a>
            </div>

            <div class="create-room">
                <h3>Create Room</h3>
                <a href="${pageContext.request.contextPath}/create-room">
                    Create Room
                </a>
            </div>

            <div class="create-item">
                <h3>Create Item</h3>
                <a href="${pageContext.request.contextPath}/create-item">
                    Create Item
                </a>
            </div>

        </c:if>

        <a href="${pageContext.request.contextPath}/logout">Logout</a>

    </div>

</body>
</html>