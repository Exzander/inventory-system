<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Room</title>
</head>
<body>

<h2>Edit Room</h2>

<c:if test="${not empty roomError}">
    <p style="color: red;">${roomError}</p>
</c:if>

<form action="${pageContext.request.contextPath}/edit-room" method="post">

    <input type="hidden" name="id" value="${room.id}" />

    <label for="roomName">Room Name:</label><br>
    <input type="text" id="roomName" name="roomName" value="${room.roomName}" required /><br><br>

    <button type="submit">Update Room</button>
    <a href="${pageContext.request.contextPath}/room-list">Cancel</a>
</form>

</body>
</html>