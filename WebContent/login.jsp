<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>

    <div class="login-container">
        <h1>Login</h1>

        <!-- Invalid credentials -->
        <c:if test="${not empty error}">
            <div class="error-message">
                <c:out value="${error}"/>
            </div>
        </c:if>

        <form action="${pageContext.request.contextPath}/login" method="post">
            <div class="form-container">
                <label for="username">Username</label>
                <input type="text" id="username" name="username" placeholder="Enter your username" value="<c:out value='${username}'/>">

                <c:if test="${not empty usernameError}">
                    <p class="error">
                        <c:out value="${usernameError}"/>
                    </p>
                </c:if>
            </div>

            <div class="form-container">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" placeholder="Enter your password">

                <c:if test="${not empty passwordError}">
                    <p class="error">
                        <c:out value="${passwordError}"/>
                    </p>
                </c:if>
            </div>

            <div class="submit-button">
                <input type="submit" value="Login">
            </div>

        </form>
    </div>

</body>
</html>