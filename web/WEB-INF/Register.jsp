<%-- 
    Document   : shoppingList
    Created on : 22-Oct-2021, 4:20:54 PM
    Author     : liamm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="ShoppingList?action=register" method="post">
            <label>Username:</label>
            <input type="text" name="username" value="">
            <input type="submit" value="Register Name">
        </form>
        <p>${errormsg}</p>
    </body>
</html>
