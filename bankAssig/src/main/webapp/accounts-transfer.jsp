<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
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
<h1>Transfer page</h1>

<style>
    table, th, td {
        border: 1px solid black;
    }
</style>

<%--<c:forEach var="client" items="${allClients2}">--%>
<%--<ul>--%>
<%--<td>"${client}"/>--%>
<%--<input type="hidden" name="name" value="${client.name}"/>--%>

<%--&lt;%&ndash;<select>&ndash;%&gt;--%>
<%--&lt;%&ndash;<c:forEach var="acc" items="${client.accounts}">&ndash;%&gt;--%>
<%--&lt;%&ndash;<option>${acc}</option>&ndash;%&gt;--%>
<%--&lt;%&ndash;</c:forEach>&ndash;%&gt;--%>
<%--&lt;%&ndash;</select>&ndash;%&gt;--%>
<%--&lt;%&ndash;<form:select path="account">&ndash;%&gt;--%>
<%--&lt;%&ndash;<form:option value="NONE" label="--- Select ---"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;<form:options items="${list.accounts}"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;</form:select>&ndash;%&gt;--%>

<%--&lt;%&ndash;<td>&ndash;%&gt;--%>
<%--&lt;%&ndash;<select name="dropdown">&ndash;%&gt;--%>
<%--&lt;%&ndash;<c:forEach var="rowSelect" items="${list.accounts}">&ndash;%&gt;--%>
<%--&lt;%&ndash;<option value="${rowItemSelect}">${rowItemSelect}</option>&ndash;%&gt;--%>
<%--&lt;%&ndash;</c:forEach>&ndash;%&gt;--%>
<%--&lt;%&ndash;</select>&ndash;%&gt;--%>
<%--&lt;%&ndash;</td>&ndash;%&gt;--%>
<%--</td>--%>

<%--</ul>--%>
<%--</c:forEach>--%>


<form:form method="POST" commandName="account"
           action="${pageContext.request.contextPath}/account/transfer/${account.accountId}">
    <table style="width:100%">
        <tr>
            <th>Name</th>
            <th>Acounts</th>
        </tr>
        <c:forEach var="client" items="${clients}">
            <tr>
                <th>${client.name}</th>
                <th><select  name="id" value="0" selected="Nothing">
                    <option selected value = "0">Nothing</option>
                    <c:forEach var="account" items="${client.accounts}">
                        <option value="${account.accountId}">${account.type} ${account.money}</option>
                    </c:forEach>
                </select></th>

            </tr>


        </c:forEach>
    </table>

    <tr>
        <td>Sum:</td>
        <td><form:input path="money"/></td>
        <td><form:errors path="money" cssStyle="color: red;"/></td>
    </tr>


    <tr>
        <td><input type="submit" value="Transfer TO"/></td>
        <td></td>
        <td></td>
    </tr>


</form:form>
<a href="${pageContext.request.contextPath}/">Log out</a>

<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>