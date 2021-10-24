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
        <p>Hello, ${username} <a href="ShoppingList?action=logout">Logout</a></p>
        <h2>List</h2>
        <form method="post" action="ShoppingList?action=add">
            <label for="item">Add Item:</label>
            <input type="text" value="" name="item">
            <input type="submit" value="Add">
        </form>
        <form action="ShoppingList?action=delete" method="post">
            
            <c:forEach var="itemList" items="${list}">
                <input type="radio" name="listItems" value="${itemList}" id="${itemList}">
                <label for="${itemList}">${itemList}</label><br>
            </c:forEach>
            <c:if test="${list != null}"><input type="submit" value="Delete">  </c:if>
                   
        </form>
    </body>
</html>
