<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, br.com.scandura.gerenciador.servlets.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/show-empresa" var="linkServletAtualizaEmpresa"/>
<c:url value="/delete-empresa" var="linkServletRemoveEmpresa"/>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Lista empresas</title>
    </head>
    <body>
        <h3 align="center">Empresa ${empresa} cadastrada com sucesso!</h3>
        <hr/>
        <h1>Lista de empresas cadastradas</h1>
        <ul>
            <c:forEach var="empresa" items="${listaDeEmpresas}">
                <fmt:formatDate value="${empresa.dataCadastro}" pattern="dd/MM/yyyy" var="dataCadastroEmpresa"/>
                <li>
                Empresa: ${empresa.nome} Cadastrada em: ${dataCadastroEmpresa}
                <a href="${linkServletAtualizaEmpresa}?id=${empresa.id}" value="${empresa}">editar</a>
                <a href="${linkServletRemoveEmpresa}?id=${empresa.id}"/>remover</a>
                </li>
            </c:forEach>
        </ul>
    </body>
</html>