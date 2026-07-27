<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Room</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/room/edit-room.css">
</head>
<body>

<div class="container">
    <h2>Edit Room</h2>

    <form action="${pageContext.request.contextPath}/edit-room" method="post">
        <input type="hidden" name="id" value="${room.id}">

        <div class="form-group">
            <label for="roomName">Room Name</label>
            <input type="text" id="roomName" name="roomName" value="${room.roomName}">

            <c:if test="${not empty roomError}">
                <div class="field-error">
                        ${roomError}
                </div>
            </c:if>

        </div>

        <div class="actions">
            <button type="submit">Update Room</button>
            <a class="cancel-btn" href="${pageContext.request.contextPath}/room-list">Cancel</a>
        </div>

    </form>
</div>

</body>
</html>