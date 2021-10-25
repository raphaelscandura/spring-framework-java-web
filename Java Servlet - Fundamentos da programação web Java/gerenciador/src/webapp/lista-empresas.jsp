<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List, br.com.scandura.gerenciador.servlets.Empresa" %>
<%
    List<Empresa> listaDeEmpresas = (List<Empresa>)request.getAttribute("lista-de-empresas");
%>

<html>
    <body>
        <h2>Lista das empresas cadastradas</h2>
        <ul>
        <%
            for (Empresa empresa: listaDeEmpresas ) {
        %>
                <li><%= empresa.getNome() %> </li>
        <%
            }
        %>
        </ul>
    </body>
</html>