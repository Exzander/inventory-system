<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Manage Item Stock</title>
</head>
<body>

<h2>Manage Item Stock</h2>

<c:if test="${not empty itemError}">
    <p style="color:red;">
            ${itemError}
    </p>
</c:if>

<c:if test="${not empty item}">

    <form action="${pageContext.request.contextPath}/manage-stock" method="post">

        <input type="hidden" name="id" value="${item.id}">

        <p>
            <strong>Item:</strong>
                ${item.name}
        </p>

        <p>
            <strong>Current Quantity:</strong>
                ${item.quantity}
        </p>

        <label>Operation:</label><br>

        <input
                type="radio"
                id="add"
                name="operation"
                value="ADD"
                checked>

        <label for="add">Add</label>

        <input
                type="radio"
                id="subtract"
                name="operation"
                value="SUBTRACT">

        <label for="subtract">Subtract</label>

        <br><br>

        <label for="amount">Amount:</label><br>

        <input
                type="number"
                id="amount"
                name="amount"
                min="1"
                required>

        <br><br>

        <button type="submit">
            Update Quantity
        </button>

        <a href="${pageContext.request.contextPath}/item-list">
            Cancel
        </a>

    </form>

</c:if>

</body>
</html>