<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

    <h1>Client Detail</h1>
    <br />

    <div class="row">
        <label class="col-sm-2">ID</label>
        <div class="col-sm-10">${client.pKey}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Name</label>
        <div class="col-sm-10">${client.name}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">PersonalNumericalCode</label>
        <div class="col-sm-10">${client.personalNumCode}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Address</label>
        <div class="col-sm-10">${client.address}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Accounts</label>
        <div class="col-sm-10">${client.accounts}</div>
    </div>

    <%--<div class="row">--%>
        <%--<label class="col-sm-2">Web Frameworks</label>--%>
        <%--<div class="col-sm-10">${user.framework}</div>--%>
    <%--</div>--%>

    <%--<div class="row">--%>
        <%--<label class="col-sm-2">Sex</label>--%>
        <%--<div class="col-sm-10">${user.sex}</div>--%>
    <%--</div>--%>

    <%--<div class="row">--%>
        <%--<label class="col-sm-2">Number</label>--%>
        <%--<div class="col-sm-10">${user.number}</div>--%>
    <%--</div>--%>

    <%--<div class="row">--%>
        <%--<label class="col-sm-2">Country</label>--%>
        <%--<div class="col-sm-10">${user.country}</div>--%>
    <%--</div>--%>

    <%--<div class="row">--%>
        <%--<label class="col-sm-2">Skill</label>--%>
        <%--<div class="col-sm-10">${user.skill}</div>--%>
    <%--</div>--%>

</div>

</body>
</html>