<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Item List</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/item/item-list.css">
</head>
<body>

<div class="container">
        <div class="top-bar">
            <h2>Inventory Items</h2>

            <c:if test="${currentUser.role == 'ADMIN'}">
                <a class="button" href="${pageContext.request.contextPath}/create-item">Add New Item</a>
            </c:if>
        </div>

        <table>
            <tr>
                <th>ID</th>
                <th>Item Name</th>
                <th>Quantity</th>
                <th>Room</th>

                <c:if test="${currentUser.role == 'ADMIN' || currentUser.role == 'CLERK'}">
                    <th>Action</th>
                </c:if>
            </tr>

            <c:choose>
                <c:when test="${empty items}">
                    <tr>
                        <td class="empty-message" colspan="${currentUser.role == 'ADMIN' || currentUser.role == 'CLERK' ? 5 : 4}">No items found.</td>
                    </tr>
                </c:when>

                <c:otherwise>
                    <c:forEach var="item" items="${items}">
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.name}</td>
                            <td>${item.quantity}</td>

                            <td>
                                <c:choose>
                                    <c:when test="${not empty item.roomName}">
                                        ${item.roomName}
                                    </c:when>

                                    <c:otherwise>
                                        Unassigned
                                    </c:otherwise>
                                </c:choose>
                            </td>

                            <c:if test="${currentUser.role == 'ADMIN' || currentUser.role == 'CLERK'}">
                                <td>
                                    <c:if test="${currentUser.role == 'ADMIN'}">
                                        <a class="action-link" href="${pageContext.request.contextPath}/edit-item?id=${item.id}">Edit</a>
                                        |
                                    </c:if>
                                    <a class="action-link" href="${pageContext.request.contextPath}/manage-stock?id=${item.id}">Update Quantity</a>
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