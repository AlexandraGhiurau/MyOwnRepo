<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>Accounts List</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<h1>Accounts List</h1>
<table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0" >
    <thead>
    <tr>
        <th width="25px">accountId</th><th width="150px">type</th><th width="25px">money</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="account" items="${accountsList}">
        <tr>
            <td>${account.accountId}</td>
            <td>${account.type}</td>
            <td>${account.money}</td>
            <td>
                <a href="${pageContext.request.contextPath}/account/edit/${account.accountId}">Edit</a><br/>
                <a href="${pageContext.request.contextPath}/account/delete/${account.accountId}">Delete</a><br/>
                <a href="${pageContext.request.contextPath}/account/transfer/${account.accountId}">Transfer</a><br/>
                <%--<a href="${pageContext.request.contextPath}/account/create">See Accounts</a><br/>--%>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="${pageContext.request.contextPath}/">Log out</a>
<a href="${pageContext.request.contextPath}/account/create/${client.pKey}">Add Account</a><br/>

<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>