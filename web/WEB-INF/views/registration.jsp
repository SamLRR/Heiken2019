<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>User Registration Form</title>
	<link href="<c:url value='css/bootstrap.css' />" rel="stylesheet"/>
	<link href="<c:url value='css/app.css' />" rel="stylesheet"/>
</head>

<body>

 	<div class="generic-container">
	<div class="well lead">Computer Registration Form</div>
 	<form:form method="POST" modelAttribute="computer" class="form-horizontal">
		<form:input type="hidden" path="id" id="id"/>
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="armName">ARM name</label>
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
				<label class="col-md-3 control-lable" for="description">Description Name</label>
				<div class="col-md-7">
					<form:input type="text" path="description" id="description" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="description" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

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
				<label class="col-md-3 control-lable" for="nodeId">Node Id</label>
				<div class="col-md-7">
					<form:input type="password" path="nodeId" id="nodeId" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="nodeId" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="domainName">Domain name</label>
				<div class="col-md-7">
					<form:input type="text" path="domainName" id="domainName" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="domainName" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="name">Name</label>
				<div class="col-md-7">
					<form:input type="text" path="name" id="name" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="name" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="phone">Phone</label>
				<div class="col-md-7">
					<form:input type="text" path="phone" id="phone" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="phone" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="userDescription">User description</label>
				<div class="col-md-7">
					<form:input type="text" path="userDescription" id="userDescription" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="userDescription" class="help-inline"/>
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
						<input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/all_computers' />">Cancel</a>
					</c:when>
					<c:otherwise>
						<input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/all_computers' />">Cancel</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</form:form>
	</div>
</body>

</html>