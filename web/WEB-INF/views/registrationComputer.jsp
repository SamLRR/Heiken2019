<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Computer Registration Form</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link href="<c:url value='/css/app.css' />" rel="stylesheet"/>
    <link href="<c:url value='/css/bootstrap.css' />" rel="stylesheet"/>
    <link href="/css/style.css" rel="stylesheet" type="text/css">
</head>

<script>
    var service = 'http://localhost:8080/equipment';
    var RemoveToStorage = function (id) {
        $.ajax({
            type: 'POST',
            url: service + '/remove_to_storage/' + id,
            dataType: 'json',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result));

                alert("Equipment was removed.");
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR))
            }
        });
    };

</script>

<body>
<%@ include file="header.jsp" %>
<div class="generic-container">
    <div class="well lead">Форма регистрации АРМа</div>
    <form:form method="POST" modelAttribute="computer" class="form-horizontal">
    <%--<form:input type="hidden" path="id" id="id"/>--%>

    <div class="row">
        <div class="form-group col-md-12">
            <label class="col-md-3 control-lable" for="id">ID</label>
            <div class="col-md-7">
                <c:choose>
                    <c:when test="${edit}">
                        <form:input type="text" path="id" id="id" class="form-control input-sm" disabled="true"/>
                    </c:when>
                    <c:otherwise>
                        <form:input type="text" path="id" id="id" class="form-control input-sm"/>
                        <div class="has-error">
                            <form:errors path="id" class="help-inline"/>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="form-group col-md-12">
            <label class="col-md-3 control-lable" for="armName">Название АРМа</label>
            <div class="col-md-7">
                <form:input type="text" path="armName" id="armName" class="form-control input-sm"/>
                <div class="has-error">
                    <form:errors path="armName" class="help-inline"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="form-group col-md-12">
            <label class="col-md-3 control-lable" for="description">Описание(IP, здание, предпр)</label>
            <div class="col-md-7">
                <form:input type="text" path="description" id="description" class="form-control input-sm"/>
                <div class="has-error">
                    <form:errors path="description" class="help-inline"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="form-group col-md-12">
            <label class="col-md-3 control-lable" for="nodeId">ID узла СПД</label>
            <div class="col-md-7">
                <form:input type="text" path="nodeId.id" id="nodeId" class="form-control input-sm"/>
                <div class="has-error">
                    <form:errors path="nodeId" class="help-inline"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="form-group col-md-12">
            <label class="col-md-3 control-lable" for="domainName">Доменное имя</label>
            <div class="col-md-7">
                <form:input type="text" path="domainName" id="domainName" class="form-control input-sm"/>
                <div class="has-error">
                    <form:errors path="domainName" class="help-inline"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="form-group col-md-12">
            <label class="col-md-3 control-lable" for="name">Подробное описание АРМа</label>
            <div class="col-md-7">
                <form:input type="text" path="name" id="name" class="form-control input-sm"/>
                <div class="has-error">
                    <form:errors path="name" class="help-inline"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="form-group col-md-12">
            <label class="col-md-3 control-lable" for="phone">Телефон</label>
            <div class="col-md-7">
                <form:input type="text" path="phone" id="phone" class="form-control input-sm"/>
                <div class="has-error">
                    <form:errors path="phone" class="help-inline"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="form-group col-md-12">
            <label class="col-md-3 control-lable" for="userDescription">Пользователь</label>
            <div class="col-md-7">
                <form:input type="text" path="userDescription" id="userDescription" class="form-control input-sm"/>
                <div class="has-error">
                    <form:errors path="userDescription" class="help-inline"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="form-group col-md-12">
            <label class="col-md-3 control-lable" for="departmentId">ID отдела</label>
            <div class="col-md-7">
                <form:input type="text" path="departmentId" id="departmentId" class="form-control input-sm"/>
                <div class="has-error">
                    <form:errors path="code" class="help-inline"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="form-group col-md-12">
                <%--<label class="col-md-3 control-lable" for="code">Code</label>--%>
            <div class="col-md-7">
                <form:input type="hidden" path="code" id="code" class="form-control input-sm"/>
                <div class="has-error">
                    <form:errors path="code" class="help-inline"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="form-group col-md-12">
                <%--<label class="col-md-3 control-lable" for="code">Code</label>--%>
            <div class="col-md-7">
                <form:input type="hidden" path="diap_ip" id="diap_ip" class="form-control input-sm"/>
                <div class="has-error">
                    <form:errors path="diap_ip" class="help-inline"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="form-group col-md-12">
                <%--<label class="col-md-3 control-lable" for="code">Code</label>--%>
            <div class="col-md-7">
                <form:input type="hidden" path="tip_pk" id="tip_pk" class="form-control input-sm"/>
                <div class="has-error">
                    <form:errors path="tip_pk" class="help-inline"/>
                </div>
            </div>
        </div>
    </div>

        <%--<div class="row">--%>
        <%--<div class="form-group col-md-12">--%>
        <%--<label class="col-md-3 control-lable" for="userProfiles">Roles</label>--%>
        <%--<div class="col-md-7">--%>
        <%--<form:select path="userProfiles" items="${roles}" multiple="true" itemValue="id" itemLabel="type" class="form-control input-sm" />--%>
        <%--<div class="has-error">--%>
        <%--<form:errors path="userProfiles" class="help-inline"/>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--</div>--%>


    <table border="1" style="font-family:Georgia, Garamond, Serif;color:black;font-style:italic;">
        <tr>
            <th>ID</th>
            <th>Тип</th>
            <th>Модель</th>
            <th>Серийный номер</th>
            <th>Штрих код</th>
            <th>Описание</th>
            <th>Перем на склад</th>
        </tr>
        <c:forEach items="${equipments}" var="e">
        <tr>
            <td><a href=<c:url value='/equipment/edit-equipment-${e.id}'/>>${e.id}</a></td>
            <td>${e.type}</td>
            <td>${e.model}</td>
            <td>${e.serialNumber}</td>
            <td>${e.barCode}</td>
            <td>${e.description}</td>
            <td>
                    <a href="<c:url value='/equipment/remove_to_storage/${e.id}'/>"><font size="3"/>Перемещение</a>
            </td>
        </tr>
        </c:forEach>

        <a href="<c:url value='/equipment/${computer.id}/add'/>"><font size="3"/>Добавить новое оборудование</a>

        <div class="row">
            <div class="form-actions floatRight">
                <c:choose>
                    <c:when test="${edit}">
                        <input type="submit" value="Обновить" class="btn btn-primary btn-sm"/> или <a
                            href="<c:url value='/computer/all_computers' />">Отмена</a>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Создать" class="btn btn-primary btn-sm"/> или <a
                            href="<c:url value='/computer/all_computers' />">Отмена</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        </form:form>
</div>
<%@ include file="footer.jsp" %>
</body>

</html>