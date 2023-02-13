<%-- 
    Document   : Login
    Created on : 12-Feb-2023, 5:45:36 PM
    Author     : reda_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>LogIn</title>

    </head>

    <body>

        <h1>Login</h1>

        <br>

        <form method="post">

            Username: <input type="text" name="username" value="${username}"><br>

            Password: <input type="password" name="password" value="${password}"><br>

            <input type="submit" value="Log in"><br>

            ${message}

        </form>

    </body>

</html>

