<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>

<%@ page import="scissortail.todo.util.AttributeNames" %>
<%@ page import="scissortail.todo.util.Mappings" %>

<html>
<head>
    <title>todo</title>

    <meta>
        <c:url var="back" value="${Mappings.ITEMS}"/>
    </meta>

    <style>
        td {
            padding: 5px;
            margin: 10px 5px;
        }
        textarea {
            width:300px;
            height:120px;
        }
    </style>
</head>
<body>
    <div align="center" style="margin:0 auto;width:max-content;padding:10px 50px;box-sizing:border-box;">
        <h1>add | edit</h1>
        <div style="border:3px double black;padding:50px 30px">
            <form:form method="POST" modelAttribute="${AttributeNames.TODO}">
                <table>
                    <tr>
                        <td><label>ID</label></td>
                        <td><form:input path="id" disabled="true"/></td>
                    </tr>
                    <tr>
                        <td><label>Title</label></td>
                        <td><form:input path="title"/></td>
                    </tr>
                    <tr>
                        <td><label>DeadLine</label></td>
                        <td><form:input path="deadline"/></td>
                    </tr>
                    <tr>
                        <td><label>Details</label></td>
                        <td><form:textarea path="details"/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Submit"/></td>
                    </tr>
                </table>
            </form:form>
        </div>

        <div align="center" style="margin:0 auto;width:max-content">
            <a href="${back}"><button style="padding:10px;margin:10px;">cancel</button></a>
        </div>
    </div>
</body>
<html>