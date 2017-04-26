<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Log in with your account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container">

    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert"
                    aria-label="Close">
                <span aria-hidden="true">×</span>
            </button>
            <strong>${msg}</strong>
        </div>
    </c:if>

    <h1>All Clients</h1>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>#ID</th>
            <th>Name</th>
            <th>Address</th>
            <th>NumericalCode</th>
            <th>CardNo</th>
            <th>Accounts</th>
        </tr>
        </thead>

        <c:forEach var="client" items="${clients}">
            <tr>
                <td>
                        ${client.pKey}
                </td>
                <td>${client.name}</td>
                <td>${client.address}</td>
                <td>${client.personalNumCode}</td>
                <td>${client.cardNo}</td>
                <td>${client.accounts}</td>
                <td>
                    <c:forEach var="framework" items="${client.framework}"
                               varStatus="loop">
                        ${framework}
                        <c:if test="${not loop.last}">,</c:if>
                    </c:forEach>
                </td>
                <td>
                    <spring:url value="/clients/${client.pKey}" var="clientUrl" />
                    <spring:url value="/clients/${client.pKey}/delete" var="deleteUrl" />
                    <spring:url value="/clients/${client.pKey}/update" var="updateUrl" />

                    <button class="btn btn-info"
                            onclick="location.href='${clientUrl}'">Query</button>
                    <button class="btn btn-primary"
                            onclick="location.href='${updateUrl}'">Update</button>
                    <button class="btn btn-danger"
                            onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>


</body>
</html>