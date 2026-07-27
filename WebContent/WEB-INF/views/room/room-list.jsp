<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Room List</title>
</head>
<body>

<h2>Manage Rooms</h2>

<c:if test="${currentUser.role == 'ADMIN'}">
    <a href="${pageContext.request.contextPath}/create-room">+ Add New Room</a><br><br>
</c:if>

<table border="1" cellpadding="8" cellspacing="0">
    <thead>
    <tr>
        <th>ID</th>
        <th>Room Name</th>
        <c:if test="${currentUser.role == 'ADMIN'}">
            <th>Actions</th>
        </c:if>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="room" items="${rooms}">
        <tr>
            <td>${room.id}</td>
            <td>${room.roomName}</td>
            <c:if test="${currentUser.role == 'ADMIN'}">
                <td>
                    <a href="${pageContext.request.contextPath}/edit-room?id=${room.id}">Edit</a>
                </td>
            </c:if>
        </tr>
    </c:forEach>
    <c:if test="${empty rooms}">
        <tr>
            <td colspan="${currentUser.role == 'ADMIN' ? '3' : '2'}" style="text-align: center;">No rooms found.</td>
        </tr>
    </c:if>
    </tbody>
</table>

<br>
<a href="${pageContext.request.contextPath}/home">Back to Home</a>

</body>
</html>