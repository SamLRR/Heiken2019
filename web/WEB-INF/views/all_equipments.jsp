<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <title>Устройства</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css">
</head>
<script>
    var service = "http://localhost:8080"
    var RestGetIp = function (ip) {
        $.ajax({
            type: 'GET',
            url: service + '/equipment/get/ip/' + ip,
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
<%@ include file = "header.jsp" %>

<div id="mainContainer">
    <div id="mainRow">
        <section id="main">
            <h1>Список всех устройств</h1>
            <form method="post" action="/equipment/findBySerial">
                <input type="text" name="serial">
                <button type="submit">Найти по сер. ном., типу, модели, описанию</button>
            </form>
            <form method="post" action="/equipment/findByBarCode">
                <input type="text" name="barCode">
                <button type="submit">Найти по ШК</button>
            </form>
            <div class="well">
                <a href="<c:url value='/equipment/0/add'/>"><font color="#f0f8ff" size="5px">Добавить новое устройство</font></a>
            </div>
            <table id="equipments" border="1">
                <tr>
                    <th>ID</th>
                    <th>Тип</th>
                    <th>Модель</th>
                    <th>Серийный номер</th>
                    <th>Штрих код</th>
                    <th>Описание</th>
                </tr>
                <c:forEach items="${equipment}" var="e">
                    <tr>
                        <td><a href=<c:url value='/equipment/edit-equipment-${e.id}'/>><font color="#f0f8ff">${e.id}</font></a></td>
                        <td>${e.type}</td>
                        <td>${e.model}</td>
                        <td>${e.serialNumber}</td>
                        <td>${e.barCode}</td>
                        <td>${e.description}</td>
                    </tr>
                </c:forEach>
            </table>
            <br/>
            <p>
                <%--<a href=<c:url value='/admin/clients'/>>НАЗАД</a> <br/>--%>
            </p>
        </section>
        <section id="news">
            <%--<jsp:include page="../fragments/newssection.jsp"/>--%>
        </section>
    </div>

</div>

<%@ include file = "footer.jsp" %>

</body>
</html>