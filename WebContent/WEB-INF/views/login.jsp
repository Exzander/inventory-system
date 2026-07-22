<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h3>Login</h3>
<form action="/login/" method="post">
    Username: <input type="text" name="username"/><br/>
    Passowrd: <input type="password" name="password"/><br/>
    <input type="submit" value="Login"/>
</form>
</body>
</html>
