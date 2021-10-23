<%-- 
    Document   : register
    Created on : 22-Oct-2021, 4:20:36 PM
    Author     : liamm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${username} <a href="ShoppingList?logout">Logout</a></p>
        <h2>List</h2>
        <form method="ShoppingList" method="post">
        <label for="item">Add Item:</label>
        <input type="text" value="" name="item">
        </form>
        <c:if test="${item != null}">
            <ul>
                
            </ul>
            <input type="submit" value="Delete">
        </c:if>
    </body>
</html>