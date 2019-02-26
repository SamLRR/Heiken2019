<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Equipment Registration Form</title>
	<link href="<c:url value='/css/app.css' />" rel="stylesheet"/>
	<link href="<c:url value='/css/bootstrap.css' />" rel="stylesheet"/>
	<link href="/css/style.css" rel="stylesheet" type="text/css">
</head>

<body>
<%@ include file = "header.jsp" %>

 	<div class="generic-container">
	<div class="well lead">Форма регистрации узлов СПД</div>
 	<form:form method="POST" modelAttribute="node" class="form-horizontal">

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="id">ID</label>
				<div class="col-md-7">
					<c:choose>
						<c:when test="${edit}">
							<form:input type="text" path="id" id="id" class="form-control input-sm" disabled="true"/>
						</c:when>
						<c:otherwise>
							<form:input type="text" path="id" id="id" class="form-control input-sm" />
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
				<label class="col-md-3 control-lable" for="name">Наименование узла СПД</label>
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
				<label class="col-md-3 control-lable" for="stationName">Название станции</label>
				<div class="col-md-7">
					<form:input type="text" path="stationName" id="stationName" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="stationName" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="ipDiapason">Диапазон IP адресов</label>
				<div class="col-md-7">
					<form:input type="text" path="ipDiapason" id="ipDiapason" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="ipDiapason" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="description">Описание</label>
				<div class="col-md-7">
					<form:input type="text" path="description" id="description" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="description" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-actions floatRight">
				<c:choose>
					<c:when test="${edit}">
						<input type="submit" value="Обновить" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/equipment/all_equipments' />">Отмена</a>
					</c:when>
					<c:otherwise>
							<input type="submit" value="Создать" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/equipment/all_equipments' />">Отмена</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</form:form>
	</div>
<%@ include file = "footer.jsp" %>
</body>

</html>