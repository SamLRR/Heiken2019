<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <title>Узлы СПД</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@ include file = "header.jsp" %>

<div id="mainContainer">
    <div id="mainRow">
        <section id="main">
            <h1>Список узлов СПД</h1>

            <div class="well">
                <a href="<c:url value='node/add' />">Добавить новый узел СПД</a>
            </div>
            <table id="nodes" border="1">
                <tr>
                    <th>ID</th>
                    <th>Название узла</th>
                    <th>Название станции</th>
                    <th>Диапазон IP</th>
                    <th>Описание</th>
                </tr>
                <c:forEach items="${node}" var="e">
                    <tr>
                        <td><a href=<c:url value='/node/edit-node-${e.id}'/>><font color="#f0f8ff">${e.id}</font></a></td>
                        <td>${e.name}</td>
                        <td>${e.stationName}</td>
                        <td>${e.ipDiapason}</td>
                        <td>${e.description}</td>
                    </tr>
                </c:forEach>
            </table>
            <br/>
        </section>
        <section id="news">
        </section>
    </div>

</div>


<div class="panel panel-default">
    <div class="panel-heading">
        <strong>RESPONSE</strong>
    </div>
    <div class="panel-body" id="response"></div>
</div>

<%@ include file = "footer.jsp" %>

</body>
</html>