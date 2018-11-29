<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Heiken</title>
</head>
<body>
<header>
    <div class="header">
        <nav>
            <a href="/"><img src="images/Heiken.png" alt="logo"/></a>
        </nav>
        <div class="header__section">
            <div class="header__item headerButton"><a>Hello, ${author}!</a></div>
            <div class="header__item headerButton"><h2><a href="/all_computers"><strong>Show computers</strong></a></h2></div>
            <%--<c:if test="${pageContext.request.userPrincipal.name == null}">--%>
                <%--<div class="header__item headerButton"><a href="/login">Войти</a></div>--%>
            <%--</c:if>--%>

            <%--<c:if test="${pageContext.request.userPrincipal.name != null}">--%>
                <%--<div class="header__item headerButton"><a href="/logout">Выйти</a></div>--%>
            <%--</c:if>--%>
        </div>
    </div>
</header>

</body>
</html>
