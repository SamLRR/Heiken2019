<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Equipment Registration Form</title>
	<link href="<c:url value='/css/app.css' />" rel="stylesheet"/>
	<link href="<c:url value='/css/bootstrap.css' />" rel="stylesheet"/>
</head>

<script>
    var service = 'http://localhost:8080/equipment';
    var GetAll = function (id) {
        $.ajax({
            type: 'GET',
            url: service + '/get/all_equipments/'+id,
            dataType: 'json',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result))
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR))
            }
        });
    };
</script>

<body>

 	<div class="generic-container">
	<div class="well lead">Форма регистрации оборудования</div>
 	<form:form method="POST" modelAttribute="equipment" class="form-horizontal">
		<form:input type="hidden" path="id" id="id"/>
		
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
				<label class="col-md-3 control-lable" for="armName">ARM name</label>
				<div class="col-md-7">
					<form:input type="text" path="computer.armName" id="armName" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="computer" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="type">Equipment type</label>
				<div class="col-md-7">
					<form:input type="text" path="type" id="type" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="type" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="model">Model</label>
				<div class="col-md-7">
					<form:input type="text" path="model" id="model" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="model" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="serialNumber">Serial number</label>
				<div class="col-md-7">
					<form:input type="text" path="serialNumber" id="serialNumber" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="serialNumber" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="description">Description</label>
				<div class="col-md-7">
					<form:input type="text" path="description" id="description" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="description" class="help-inline"/>
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

		<div class="row">
			<div class="form-actions floatRight">
				<c:choose>
					<c:when test="${edit}">
						<input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/computer/all_computers' />">Cancel</a>
					</c:when>
					<c:otherwise>
						<input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/computer/all_computers' />">Cancel</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</form:form>
	</div>
</body>

</html>