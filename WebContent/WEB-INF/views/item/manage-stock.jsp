<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Manage Item Stock</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/item/manage-stock.css">
</head>
<body>

    <div class="container">
        <h2>Manage Item Stock</h2>

        <c:if test="${not empty itemError}">
            <div class="error">
                    ${itemError}
            </div>
        </c:if>

        <c:if test="${not empty item}">

            <form action="${pageContext.request.contextPath}/manage-stock" method="post">
                <input type="hidden" name="id" value="${item.id}">

                <div class="info-box">
                    <p><strong>Item:</strong> ${item.name}</p>
                    <p><strong>Current Quantity:</strong> ${item.quantity}</p>
                </div>

                <div class="form-group">
                    <label>Operation</label>

                    <div class="radio-group">
                        <label>
                            <input type="radio" name="operation" value="ADD" <c:if test="${empty operation || operation eq 'ADD'}">checked</c:if>>
                            Add
                        </label>

                        <label>
                            <input type="radio" name="operation" value="SUBTRACT" <c:if test="${operation eq 'SUBTRACT'}">checked</c:if>>
                            Subtract
                        </label>
                    </div>
                </div>

                <div class="form-group">
                    <label for="quantity">Quantity</label>

                    <input type="number" id="quantity" name="quantity" min="1" value="${quantity}">

                    <c:if test="${not empty quantityError}">
                        <div class="field-error">
                                ${quantityError}
                        </div>
                    </c:if>
                </div>

                <div class="actions">
                    <button type="submit">Update Quantity</button>
                    <a class="cancel-btn" href="${pageContext.request.contextPath}/item-list">Cancel</a>
                </div>
            </form>
        </c:if>
    </div>

</body>
</html>