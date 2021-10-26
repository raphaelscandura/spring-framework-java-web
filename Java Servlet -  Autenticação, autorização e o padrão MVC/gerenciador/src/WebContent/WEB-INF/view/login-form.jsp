<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/control?action=login-usuario" var="linkServletLoginUsuario"/>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Login Usuario</title>
</head>
<body>
    <form action="${linkServletLoginUsuario}" method="POST">
        <p>Login: <input type="text" name="login" required></p>
        <p>Senha: <input type="password" name="senha" required></p>
        <p><input type="submit"></>
    </form>
</body>
</html>