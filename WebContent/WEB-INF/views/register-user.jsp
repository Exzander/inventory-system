<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inventory System Registration</title>
</head>
<body>

    <h2>Register New User</h2>
    <form action="${pageContext.request.contextPath}/register" method="post">

        <label for="username">Username</label><br>
        <input type="text" id="username" name="username" value="<%= request.getAttribute("username") != null ? request.getAttribute("username") : "" %>" /><br><br>


        <label for="password">Password</label><br>
        <input type="password" id="password" name="password" /><br><br>


        <label for="role">Role</label><br>
        <select id="role" name="role">
            <option value="">-- Select Role --</option>
            <option value="Registered User" <%= "Registered User".equals(request.getAttribute("role")) ? "selected" : "" %>>Registered User</option>
            <option value="Clerk" <%= "Clerk".equals(request.getAttribute("role")) ? "selected" : "" %>>Clerk</option>
            <option value="Admin" <%= "Admin".equals(request.getAttribute("role")) ? "selected" : "" %>>Admin</option>
        </select><br><br>


        <button type="submit" class="btn">Register User</button>
        <a href="${pageContext.request.contextPath}/home" class="btn btn-secondary">Cancel</a>

    </form>

</body>
</html>