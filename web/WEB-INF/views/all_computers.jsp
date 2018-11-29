<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <%--<script src="../" type="text/javascript"></script>--%>
</head>
<script>
    var service = "http://localhost:8080"
    var RestGetIp = function (ip) {
        $.ajax({
            type: 'GET',
            url: service + '/computer/get/ip/' + ip,
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

<div id="mainContainer">
    <div id="mainRow">
        <section id="main">
            <h1>Список всех компьютеров</h1>
            <form method="post" action="filter">
                <input type="text" name="ip">
                <button type="submit">Найти по описанию</button>
            </form>
            <div class="well">
                <a href="<c:url value='/new_computer' />">Добавить новый компьютер</a>
            </div>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Код</th>
                    <th>Название АРМа</th>
                    <th>Описание АРМа(IP адрес, узел, предпр)</th>
                    <th>Имя в домене</th>
                    <th>Контактный Телефон</th>
                    <th>Описание пользователя</th>
                    <th>Диапазон IP</th>
                </tr>
                <c:forEach items="${computer}" var="c">
                    <tr>
                        <td><a href=<c:url value='/edit-computer-${c.id}'/>>${c.id}</a></td>
                        <td>${c.code}</td>
                        <td>${c.name}</td>
                        <td>${c.description}</td>
                        <td>${c.domainName}</td>
                        <td>${c.phone}</td>
                        <td>${c.userDescription}</td>
                        <td>${c.diap_ip}</td>
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


<div class="panel panel-default">
    <div class="panel-heading">
        <strong>RESPONSE</strong>
    </div>
    <div class="panel-body" id="response"></div>
</div>

<footer>
    &copy; 2018, InfoTrance co.
</footer>

</body>
</html>