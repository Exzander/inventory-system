<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Room</title>
</head>
<body>

<h2>Add New Room</h2>

<c:if test="${not empty roomError}">
    <p style="color: red;">${roomError}</p>
</c:if>

<form action="${pageContext.request.contextPath}/create-room" method="post">

    <label for="roomName">Room Name:</label><br>
    <input type="text" id="roomName" name="roomName" value="${roomName}"/><br><br>

    <button type="submit">Create Room</button>
    <a href="${pageContext.request.contextPath}/home">Cancel</a>
</form>

</body>
</html>