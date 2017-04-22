<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>Clients List</title>
</head>
<body>
<h1>Clients List</h1>
<table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0" >
    <thead>
    <tr>
        <th width="25px">pKey</th><th width="150px">name</th><th width="25px">address</th><th width="50px">accounts</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="shop" items="${clientsList}">
        <tr>
            <td>${client.pKey}</td>
            <td>${client.name}</td>
            <td>${client.cardNo}</td>
            <td>${client.personalNumCode}</td>
            <td>${client.address}</td>
            <td>${client.accounts}</td>
            <td>
                <a href="${pageContext.request.contextPath}/clients/edit/${client.pKey}.html">Edit</a><br/>
                <a href="${pageContext.request.contextPath}/clients/delete/${client.pKey}.html">Delete</a><br/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="${pageContext.request.contextPath}/">Home page</a>
</body>
</html>