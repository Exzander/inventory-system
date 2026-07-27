<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Item List</title>
</head>
<body>

<h2>Items</h2>

<p>
    <a href="${pageContext.request.contextPath}/create-item">
        Add New Item
    </a>
</p>

<table border="1" cellpadding="8">

    <tr>
        <th>ID</th>
        <th>Item Name</th>
        <th>Quantity</th>
        <th>Room</th>
        <th>Action</th>
    </tr>

    <c:forEach var="item" items="${items}">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.quantity}</td>
            <td>${item.roomName}</td>
            <td>
                <c:if test="${currentUser.role eq 'ADMIN'}">
                    <a href="${pageContext.request.contextPath}/edit-item?id=${item.id}">
                        Edit
                    </a>

                    |

                    <a href="${pageContext.request.contextPath}/manage-stock?id=${item.id}">
                        Update Quantity
                    </a>
                </c:if>

                <c:if test="${currentUser.role eq 'CLERK'}">
                    <a href="${pageContext.request.contextPath}/manage-stock?id=${item.id}">
                        Update Quantity
                    </a>
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>

<br>

    <a href="${pageContext.request.contextPath}/home">
        Back to Home
    </a>

</body>
</html>