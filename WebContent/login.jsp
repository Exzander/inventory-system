<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inventory System Login</title>
</head>
<body>
    <h3>Login</h3>

    <form action="${pageContext.request.contextPath}/login.jsp" method="post">
        <label>Username</label><br>
        <input type="text" name="username"><br><br>

        <label>Password</label><br>
        <input type="password" name="password"><br><br>

        <input type="submit" value="Login">
    </form>

</body>
</html>