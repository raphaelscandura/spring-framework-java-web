<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, br.com.scandura.gerenciador.servlets.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Lista empresas</title>
    </head>
    <body>
        <c:if test="${not empty empresa}">
            <h3 align="center">Empresa ${empresa} cadastrada com sucesso!</h3>
        </c:if>
        <c:if test="${empty empresa}">
            <h1>Nenhuma empresa foi cadastrada nesse momento</h1>
        </c:if>
        <hr/>
        <h1>Lista de empresas cadastradas</h1>
        <ul>
            <c:forEach var="empresa" items="${listaDeEmpresas}">
                <fmt:formatDate value="${empresa.dataCadastro}" pattern="dd/MM/yyyy" var="dataCadastroEmpresa"/>
                <li>Empresa: ${empresa.nome} Cadastrada em: ${dataCadastroEmpresa}</li>
            </c:forEach>
        </ul>
    </body>
</html>