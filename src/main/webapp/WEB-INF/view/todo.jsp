<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>

<%@ page import="scissortail.todo.util.AttributeNames" %>
<%@ page import="scissortail.todo.util.Mappings" %>

<html>
<head>
    <title>todo</title>

    <meta>
        <c:url var="home" value="${Mappings.ITEMS}"/>
        <c:url var="edit" value="${Mappings.PROCESS_TODO}"/>
    </meta>
</head>

<body>
    <div align="center" style="border:3px double black;width:max-content;padding:0 100px;margin:100px auto 0;">
        <h2>${todo.title}</h2>
        <p>${todo.details}</p>
        <br/>
        <br/>
        <h4>deadline:</h4>
        <p>${todo.deadline}</p>
        <a href="${edit}?id=${todo.id}"><button style="padding:10px;margin:0 0 15px;">modify</button></a>
    </div>
    <div align="center" style="margin:0 auto;width:max-content">
        <a href="${home}"><button style="padding:10px;margin:10px;">back</button></a>
    </div>
</body>
<html>