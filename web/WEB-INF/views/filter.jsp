<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <%--<script src="../" type="text/javascript"></script>--%>
</head>

<div id="mainContainer">
    <div id="mainRow">
        <section id="main">
            <h1>Список всех компьютеров</h1>

            <form method="post" action="/computer/filter">
                <input type="text" name="ip">
                <button type="submit">Найти</button>
            </form>
            <div class="well">
                <a href="<c:url value='/computer/add' />">Добавить новый компьютер</a>
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
                <c:forEach items="${computers}" var="e">
                    <tr>
                        <td><a href=<c:url value='/computer/edit-computer-${e.id}'/>>${e.id}</a></td>
                        <td>${e.code}</td>
                        <td>${e.name}</td>
                        <td>${e.description}</td>
                        <td>${e.domainName}</td>
                        <td>${e.phone}</td>
                        <td>${e.userDescription}</td>
                        <td>${e.diap_ip}</td>
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