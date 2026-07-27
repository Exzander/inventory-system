<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Item</title>
</head>
<body>

<h2>Add New Item</h2>

<c:if test="${not empty itemError}">
    <p style="color:red;">${itemError}</p>
</c:if>

<form action="${pageContext.request.contextPath}/create-item" method="post">

    <label for="name">Item Name:</label><br>
    <input
            type="text"
            id="name"
            name="name"
            value="${name}">
    <br><br>

    <label for="quantity">Quantity:</label><br>
    <input
            type="number"
            id="quantity"
            name="quantity"
            min="0"
            value="${quantity}">
    <br><br>

    <label for="roomId">Assigned Room:</label><br>
    <select id="roomId" name="roomId">

        <option value="">-- Unassigned --</option>

        <c:forEach var="room" items="${rooms}">
            <option value="${room.id}"
                    <c:if test="${room.id == roomId}">selected</c:if>>
                    ${room.roomName}
            </option>
        </c:forEach>

    </select>

    <br><br>

    <button type="submit">Create Item</button>

    <a href="${pageContext.request.contextPath}/item-list">
        Cancel
    </a>

</form>

</body>
</html>