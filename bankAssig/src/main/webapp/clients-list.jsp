<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Clients List</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<h1>Clients List</h1>
<table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0" >
    <thead>
    <tr>
        <th width="25px">pKey</th><th width="150px">name</th><th width="25px">address</th><th width="50px">personalNumCode</th><th width="50px">cardNo</th>
        <%--<th width="100px">accounts</th>--%>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="client" items="${clientsList}">
        <tr>
            <td>${client.pKey}</td>
            <td>${client.name}</td>
            <td>${client.address}</td>
            <td>${client.personalNumCode}</td>
            <td>${client.cardNo}</td>
            <%--<td>${client.accounts}</td>--%>
            <td>
                <a href="${pageContext.request.contextPath}/client/edit/${client.pKey}">Edit</a><br/>
                <a href="${pageContext.request.contextPath}/client/delete/${client.pKey}">Delete</a><br/>
                <a href="${pageContext.request.contextPath}/account/list/${client.pKey}">See Accounts</a><br/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="${pageContext.request.contextPath}/">Log out</a>
<a href="${pageContext.request.contextPath}/client/create">Add Client</a><br/>

<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>