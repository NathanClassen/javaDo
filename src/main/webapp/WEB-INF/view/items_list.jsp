<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="scissortail.todo.util.Mappings" %>

<html>
<head>
    <title>todo</title>

    <meta>
        <c:url var="link" value="${Mappings.TODO}"/>
        <c:url var="delete" value="${Mappings.DELETE_TODO}"/>
        <c:url var="newTodo" value="${Mappings.PROCESS_TODO}"/>
    </meta>
    <style>
        td {
            padding:10px;
        }
    </style>
</head>

<body>
    <div style="width:max-content;margin:0 auto;">
        <h1 style="text-align:center">todo list</h1>
        <table style="margin:10px 10px 20px" border="1" cellPadding="5">
            <tr>
                <th>Id</th>
                <th>Title</th>
                <th>DeadLine</th>
                <th>Delete</th>
            </tr>

            <c:forEach var="item" items="${todoData.items}">
                <tr>
                    <td>${item.id}</td>
                    <td><a href="${link}?id=${item.id}">${item.title}</a></td>
                    <td>${item.deadline}</td>
                    <td><a href="${delete}?id=${item.id}">delete</a></td>
                </tr>
            </c:forEach>
        </table>
        <a href="${newTodo}"><button style="padding:10px;margin:5px">add</button></a>
    </div>
</body>
<html>