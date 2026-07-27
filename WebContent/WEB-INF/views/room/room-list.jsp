<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Room List</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/room/room-list.css">
</head>
<body>

    <div class="container">
        <div class="top-bar">
            <h2>Manage Rooms</h2>

            <c:if test="${currentUser.role == 'ADMIN'}">
                <a class="button" href="${pageContext.request.contextPath}/create-room">Add New Room</a>
            </c:if>
        </div>

        <table>
            <tr>
                <th>ID</th>
                <th>Room Name</th>

                <c:if test="${currentUser.role == 'ADMIN'}">
                    <th>Action</th>
                </c:if>
            </tr>

            <c:choose>
                <c:when test="${empty rooms}">
                    <tr>
                        <td class="empty-message"
                            colspan="${currentUser.role == 'ADMIN' ? 3 : 2}">
                            No rooms found
                        </td>
                    </tr>
                </c:when>


                <c:otherwise>
                    <c:forEach var="room" items="${rooms}">
                        <tr>
                            <td>${room.id}</td>
                            <td>${room.roomName}</td>

                            <c:if test="${currentUser.role == 'ADMIN'}">
                                <td>
                                    <a class="action-link" href="${pageContext.request.contextPath}/edit-room?id=${room.id}">Edit</a>
                                </td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </table>

        <div class="back">
            <a href="${pageContext.request.contextPath}/home">Back to Home</a>
        </div>

    </div>

</body>
</html>