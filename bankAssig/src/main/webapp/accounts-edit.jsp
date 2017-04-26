<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>Edit page</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<h1>Edit page</h1>
<%--<form:form method="POST" commandName="client" action="${pageContext.request.contextPath}/clients/edit/${client.pKey}.html" >--%>
<form:form method="POST" commandName="account" action="${pageContext.request.contextPath}/account/edit/${account.accountId}" >
    <table>
        <tbody>
        <tr>
            <td>Account ID:</td>
            <td><form:input path="accountId" /></td>
            <td><form:errors path="accountId" cssStyle="color: red;"/></td>
        </tr>

        <tr>
            <td>Account money:</td>
            <td><form:input path="money" /></td>
            <td><form:errors path="money" cssStyle="color: red;"/></td>
        </tr>

        <tr>
            <td>Account type:</td>
            <td><form:input path="type" /></td>
            <td><form:errors path="type" cssStyle="color: red;"/></td>
        </tr>

        <tr>
            <td><input type="submit" value="Edit" /></td>
            <td></td>
            <td></td>
        </tr>
        </tbody>
    </table>
</form:form>
<a href="${pageContext.request.contextPath}/">Log out</a>

<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>