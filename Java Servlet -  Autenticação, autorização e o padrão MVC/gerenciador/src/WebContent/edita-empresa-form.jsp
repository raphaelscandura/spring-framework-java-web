<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/update-empresa" var="linkServletEditaEmpresa"/>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Atualização de cadastro de empresa</title>
</head>
<body>
    <form action="${linkServletEditaEmpresa}" method="POST">
        <p>
        Nome da empresa: <input type="text" name="nome" placeholder="${empresa.nome}" required>
        <input type="submit">
        <input type="hidden" name="id" value="${empresa.id}"
        </p>
    </form>
</body>
</html>