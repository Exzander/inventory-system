<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Room</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/room/create-room.css">
</head>
<body>

    <div class="container">
        <h2>Create Room</h2>

        <form action="${pageContext.request.contextPath}/create-room" method="post">

            <div class="form-group">
                <label for="roomName">Room Name</label>
                <input type="text" id="roomName" name="roomName" value="${roomName}">

                <c:if test="${not empty roomError}">
                    <div class="field-error">
                            ${roomError}
                    </div>
                </c:if>

            </div>

            <div class="actions">
                <button type="submit">Create Room</button>
                <a class="cancel-btn" href="${pageContext.request.contextPath}/home">Cancel</a>
            </div>

        </form>
    </div>

</body>
</html>