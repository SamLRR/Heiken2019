<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Registration Form</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link href="<c:url value='/css/app.css' />" rel="stylesheet"/>
    <link href="<c:url value='/css/bootstrap.css' />" rel="stylesheet"/>
    <link href="/css/style.css" rel="stylesheet" type="text/css">
</head>

<body>
<%@ include file="header.jsp" %>
<div class="generic-container">
    <div class="well lead">Форма регистрации пользователя</div>
    <form:form method="POST" modelAttribute="user" class="form-horizontal">

    <%--<div class="row">--%>
        <%--<div class="form-group col-md-12">--%>
            <%--<label class="col-md-3 control-lable" for="id">ID</label>--%>
            <%--<div class="col-md-7">--%>
                <%--<c:choose>--%>
                    <%--<c:when test="${edit}">--%>
                        <%--<form:input type="hidden" path="id" id="id" class="form-control input-sm" disabled="true"/>--%>
                    <%--</c:when>--%>
                    <%--<c:otherwise>--%>
                        <%--<form:input type="hidden" path="id" id="id" class="form-control input-sm"/>--%>
                        <%--<div class="has-error">--%>
                            <%--<form:errors path="id" class="help-inline"/>--%>
                        <%--</div>--%>
                    <%--</c:otherwise>--%>
                <%--</c:choose>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>

    <div class="row">
        <div class="form-group col-md-12">
            <label class="col-md-3 control-lable" for="login">Логин</label>
            <div class="col-md-7">
                <form:input type="text" path="login" id="login" class="form-control input-sm"/>
                <div class="has-error">
                    <form:errors path="login" class="help-inline"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="form-group col-md-12">
            <label class="col-md-3 control-lable" for="password">Пароль</label>
            <div class="col-md-7">
                <form:input type="text" path="password" id="password" class="form-control input-sm"/>
                <div class="has-error">
                    <form:errors path="password" class="help-inline"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="form-group col-md-12">
            <label class="col-md-3 control-lable" for="firstName">Имя пользователя</label>
            <div class="col-md-7">
                <form:input type="text" path="firstName" id="firstName" class="form-control input-sm"/>
                <div class="has-error">
                    <form:errors path="firstName" class="help-inline"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="form-group col-md-12">
            <label class="col-md-3 control-lable" for="lastName">Фамилия пользователя</label>
            <div class="col-md-7">
                <form:input type="text" path="lastName" id="lastName" class="form-control input-sm"/>
                <div class="has-error">
                    <form:errors path="lastName" class="help-inline"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="form-group col-md-12">
            <label class="col-md-3 control-lable" for="email">Адрес электронной почты</label>
            <div class="col-md-7">
                <form:input type="text" path="email" id="email" class="form-control input-sm"/>
                <div class="has-error">
                    <form:errors path="email" class="help-inline"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="form-group col-md-12">
            <label class="col-md-3 control-lable" for="active">Активный</label>
            <div class="col-md-7">
                <form:input type="text" path="active" id="active" class="form-control input-sm"/>
                <div class="has-error">
                    <form:errors path="active" class="help-inline"/>
                </div>
            </div>
        </div>
    </div>

        <div class="row">
            <div class="form-actions floatRight">
                <c:choose>
                    <c:when test="${edit}">
                        <input type="submit" value="Обновить" class="btn btn-primary btn-sm"/> или <a
                            href="<c:url value='/' />">Отмена</a>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Создать" class="btn btn-primary btn-sm"/> или <a
                            href="<c:url value='/' />">Отмена</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        </form:form>
</div>
<%@ include file="footer.jsp" %>
</body>

</html>