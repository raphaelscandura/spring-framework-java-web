<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/create-empresa" var="linkServletNovaEmpresa"/>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Empresa</title>
</head>
<body>
    <form action="${linkServletNovaEmpresa}" method="POST">
        <p>Nome da empresa: <input type="text" name="nome" required><input type="submit"></p>
    </form>
</body>
</html>