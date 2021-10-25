package br.com.scandura.gerenciador.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class NovaEmpresaServlet
 */

@WebServlet(urlPatterns = "/nova-empresa")
public class NovaEmpresaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Empresa novaEmpresa = new Empresa(request.getParameter("nome"));
        BancoDeDados banco = new BancoDeDados();
        banco.adicionaEmpresa(novaEmpresa);
        RequestDispatcher rd = request.getRequestDispatcher("/resultado-cadastro-empresa.jsp");
        request.setAttribute("empresa", novaEmpresa.getNome());
        rd.forward(request, response);
    }
}
