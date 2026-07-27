<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Item</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/item/create-item.css">
</head>
<body>

    <div class="container">
        <h2>Add New Item</h2>

        <form action="${pageContext.request.contextPath}/create-item" method="post">
            <div class="form-group">
                <label for="name">Item Name</label>
                <input type="text" id="name" name="name" value="${name}">

                <c:if test="${not empty nameError}">
                    <div class="error">${nameError}</div>
                </c:if>
            </div>

            <div class="form-group">
                <label for="quantity">Quantity</label>
                <input type="number" id="quantity" name="quantity" min="0" value="${quantity}">

                <c:if test="${not empty quantityError}">
                    <div class="error">${quantityError}</div>
                </c:if>
            </div>

            <div class="form-group">
                <label for="roomId">Assigned Room</label>

                <select id="roomId" name="roomId">
                    <option value="">-- Unassigned --</option>

                    <c:forEach var="room" items="${rooms}">
                        <option value="${room.id}" <c:if test="${room.id == roomId}">selected</c:if>>${room.roomName}</option>
                    </c:forEach>
                </select>

                <c:if test="${not empty roomError}">
                    <div class="error">${roomError}</div>
                </c:if>
            </div>

            <div class="actions">
                <button type="submit">Create Item</button>
                <a class="cancel-btn" href="${pageContext.request.contextPath}/home">Cancel</a>
            </div>

        </form>
    </div>

</body>
</html>