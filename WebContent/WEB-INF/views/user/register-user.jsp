<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register User</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/user/register-user.css">
</head>
<body>

    <div class="container">
        <h2>Register New User</h2>

        <c:if test="${not empty registrationError}">
            <div class="message-error">
                    ${registrationError}
            </div>
        </c:if>

        <c:if test="${not empty success}">
            <div class="success">
                    ${success}
            </div>
        </c:if>

        <form action="${pageContext.request.contextPath}/register" method="post">
            <div class="form-group">
                <label for="username">Username</label>
                <input type="text" id="username" name="username" value="${username}">

                <c:if test="${not empty usernameError}">
                    <div class="field-error">
                            ${usernameError}
                    </div>
                </c:if>
            </div>

            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password">

                <c:if test="${not empty passwordError}">
                    <div class="field-error">
                            ${passwordError}
                    </div>
                </c:if>
            </div>

            <div class="form-group">
                <label for="role">Role</label>
                <select id="role" name="role">
                    <option value="">-- Select Role --</option>
                    <option value="REGISTERED_USER"${role == 'REGISTERED_USER' ? 'selected' : ''}>Registered User</option>
                    <option value="CLERK" ${role == 'CLERK' ? 'selected' : ''}>Clerk</option>
                    <option value="ADMIN"${role == 'ADMIN' ? 'selected' : ''}>Admin</option>
                </select>

                <c:if test="${not empty roleError}">
                    <div class="field-error">
                            ${roleError}
                    </div>
                </c:if>
            </div>

            <div class="actions">
                <button type="submit" class="btn">Register User</button>
                <a href="${pageContext.request.contextPath}/home" class="btn btn-secondary">Cancel</a>
            </div>

        </form>
    </div>

</body>
</html>