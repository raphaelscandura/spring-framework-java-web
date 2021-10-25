<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List, br.com.scandura.gerenciador.servlets.Empresa" %>
<%
    String nomeEmpresa = (String)request.getAttribute("empresa");
    List<Empresa> listaDeEmpresas = (List<Empresa>)request.getAttribute("lista-de-empresas");
%>

<html>
    <body>
        <h1>Empresa <%= nomeEmpresa %> cadastrada com sucesso!</h1>
    </body>
</html>