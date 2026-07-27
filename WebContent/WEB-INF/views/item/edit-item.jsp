<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Item</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/edit-item.css">
</head>
<body>

    <div class="container">
        <h2>Edit Item</h2>

        <c:if test="${not empty itemError}">
            <div class="general-error">
                    ${itemError}
            </div>
        </c:if>

        <c:if test="${not empty item}">
            <form action="${pageContext.request.contextPath}/edit-item" method="post">
                <input type="hidden" name="id" value="${item.id}">

                <div class="form-group">
                    <label for="name">Item Name</label>
                    <input type="text" id="name" name="name" value="${item.name}">

                    <c:if test="${not empty nameError}">
                        <div class="error">${nameError}</div>
                    </c:if>
                </div>

                <div class="form-group">
                    <label for="quantity">Quantity</label>
                    <input type="number" id="quantity" name="quantity" min="0" value="${item.quantity}">

                    <c:if test="${not empty quantityError}">
                        <div class="error">${quantityError}</div>
                    </c:if>
                </div>

                <div class="form-group">
                    <label for="roomId">Assigned Room</label>

                    <select id="roomId" name="roomId">
                        <option value="">-- Unassigned --</option>

                        <c:forEach var="room" items="${rooms}">
                            <option value="${room.id}" <c:if test="${room.id == item.roomId}">selected</c:if>>${room.roomName}</option>
                        </c:forEach>
                    </select>

                    <c:if test="${not empty roomError}">
                        <div class="error">${roomError}</div>
                    </c:if>
                </div>

                <div class="actions">
                    <button type="submit">Update Item</button>
                    <a class="cancel-btn" href="${pageContext.request.contextPath}/item-list">Cancel</a>
                </div>
            </form>
        </c:if>
    </div>

</body>
</html>