<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<header>
    <jsp:include page="/resources/sharedviews/adminheader.jsp"/>
</header>

<section class="table-sub-heading-color">
    <h2>Administratorzy:</h2>
    <div class="table-tab">
        <table id="tableadmins" class="table" >
            <thead>
            <tr>
                <th>Nazwa Użytkownika</th>
                <th>Imię</th>
                <th>Nazwisko</th>
                <th>Email</th>
                <th>Akcje</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${admins}" var="admin">
                <tr>
                    <td>${admin.username}</td>
                    <td>${admin.firstName}</td>
                    <td>${admin.lastName}</td>
                    <td>${admin.email}</td>
                    <td>
                        <a href="/admin/edit/${admin.id}">
                            <button type="button" class="btn btn--small">Edytuj</button>
                        </a>
                        <a href="/admin/delete/${admin.id}" class="delete-link">
                            <button type="button" class="btn btn--small">Usuń</button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <c:if test='${delete.equals("failed")}'>
            <p class="error"> Nie można usunąć administratora</p>
        </c:if>
    </div>
</section>
<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>