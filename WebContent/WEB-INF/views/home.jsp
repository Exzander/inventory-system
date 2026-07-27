<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inventory System</title>
</head>
<body>
<div class="Main-Container">
    <h1>Welcome <c:out value="${currentUser.username}"/></h1>

    <div class="Room-List">
        <h3>Display Rooms</h3>
        <a href="${pageContext.request.contextPath}/room-list">View Rooms</a>
    </div>

    <div class="Item-List">
        <h3>View Items</h3>
        <a href="${pageContext.request.contextPath}/item-list">
            View Items
        </a>
    </div>


    <%--    Admin Feature    --%>
    <c:if test="${currentUser.role == 'ADMIN'}" >
        <div class="Registration-Container">
            <h3>Register New User</h3>
            <a href="${pageContext.request.contextPath}/register">Register User</a>
        </div>

        <div class="Create-Room">
            <h3>Create Room</h3>
            <a href="${pageContext.request.contextPath}/create-room">Create Room</a>
        </div>

        <div class="Create-Item">
            <h3>Create Item</h3>
            <a href="${pageContext.request.contextPath}/create-item">Create Item</a>
        </div>

    </c:if>

    <!-- CLERK FEATURES -->
    <c:if test="${currentUser.role == 'CLERK' || currentUser.role == 'ADMIN'}">
        <div class="Stock-Management">
            <h3>Update Item Stock</h3>
            <a href="${pageContext.request.contextPath}/manage-stock">Add / Subtract Quantity</a>
        </div>
    </c:if>

    <a href="${pageContext.request.contextPath}/logout">Logout</a>
</div>
</body>
</html>